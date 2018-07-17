<%-- 
    Document   : form_responder_mensagem
    Created on : 01/12/2012, 19:08:05
    Author     : Everton
--%>

<%@page import="classes.Mensagem"%>
<%@page import="DAO.MensagemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responder Mensagem</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_mensagem_cliente;
                if(formulario.descricao.value == ""){
                    alert("O campo nome deve ser preenchido!");
                    return false;
                }
                if(formulario.titulo.value == ""){
                    alert("O campo endereço deve ser preenchido!");
                    return false;
                }
                if(formulario.Funcionario_funcionario.value == ""){
                    alert("O campo cidade deve ser preenchido!");
                    return false;
                }
                if(formulario.Cliente_idCliente.value == ""){
                    alert("O campo uf deve ser preenchido!");
                    return false;
                }
                return true;
                 
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
                            <h2>Responder Mensagem</h2>
                            <form name="form_mensagem" action="enviar_mensagem.do" method="post" onsubmit="return validaForm();">


                                <%
                                    int idMensagem = Integer.parseInt(request.getParameter("idMensagem"));
                                    try {

                                        MensagemDAO mDB = new MensagemDAO();

                                        mDB.conectar();
                                        Mensagem m = new Mensagem();
                                        m = mDB.carregarPorId(idMensagem);
                                        mDB.desconectar();

                                        if (m.getIdMensagem() > 0) {
                                %>

                                <p>Titulo:<input type="text" name="titulo" value="Re: <%=m.getTitulo()%>"/></p>
                                <p><textarea cols="80" rows="10" name="descricao" >

                                    Rw:<%=m.getDescricao()%>
                                    </textarea></p>
                                <input type="hidden" name="Cliente_idCliente" value="<%=m.getCliente().getIdCliente()%>"/>
                                <input type="hidden" name="Funcionario_idFuncionario" value="<%=m.getFuncionario().getIdFuncionario()%>"/>
                                <input type="submit" value="Salvar" />  
                                <% }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                %>
                            </form>
                        </div>



                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
