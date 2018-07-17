<%-- 
    Document   : form_listar_mensagem
    Created on : 01/12/2012, 19:18:10
    Author     : Everton
--%>

<%@page import="classes.Mensagem"%>
<%@page import="DAO.MensagemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagems</title>
        <script type="text/javascript" language="javascript">
            function deletarMensagem(idMensagem){
                if (confirm('Deseja excluir o mensagem' +idMensagem+'?')) { 
                    window.location.href='deletar_mensagem.do?idMensagem='+idMensagem;
                }  
            }            
                        
        </script>
    </head>
    <body>
        <div align="center">
            <table border="1" width="760">
                <tr><td height="150">
                        <%@include file="banner.jsp" %>
                    </td>
                </tr>
                <tr>
                    <td height="20">
                        <%@include file="menu.jsp" %>
                    </td>
                </tr>
                <tr><td height="370">


                        <div align="center">



                            <%
                                try {
                                    MensagemDAO mDB = new MensagemDAO();
                                    mDB.conectar();
                                    ArrayList<Mensagem> lista = mDB.listar();


                            %>
                            <h2>Mensagems</h2>

                            <a href="form_enviar_mensagem.jsp">
                                <img src="imagens/ico_novo.png" border="0"/>
                            </a> 

                            <table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>Titulo</th>
                                        <th>Mensagem</th>
                                        <th>Cliente</th>
                                        <th>Funcionario</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        for (Mensagem ms : lista) {
                                    %>

                                    <%
                                        if ((usuario.getPerfil().getIdPerfil() == 1) || (ms.getFuncionario().getUsuario().getIdUsuario() == usuario.getIdUsuario()) || (ms.getCliente().getUsuario().getIdUsuario() == usuario.getIdUsuario())) {
                                    %>
                                    <tr>
                                        <td><%=ms.getTitulo()%></td>
                                        <td><%=ms.getDescricao()%></td>
                                        <td><%=ms.getCliente().getNome()%></td>
                                        <td><%=ms.getFuncionario().getNome()%></td>

                                        <td><a href="form_responder_mensagem.jsp?idMensagem=<%=ms.getIdMensagem()%>"><img src="imagens/ico_alterar.gif"/></a>

                                            <a href="javascript: deletarMensagem(<%=ms.getIdMensagem()%>); "><img src="imagens/ico_excluir.gif"/></a></td>
                                    </tr>

                                    <%
                                            }
                                        }


                                    %>





                                    <%



                                            mDB.desconectar();
                                        } catch (Exception e) {
                                            out.print(e);
                                        }
                                    %>

                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
