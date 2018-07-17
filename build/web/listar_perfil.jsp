<%-- 
    Document   : index
    Created on : 13/08/2012, 20:03:39
    Author     : Hpti
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="classes.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <script type="text/javascript" language="javascript">
            function deletarPerfil(idperfil){
                if (confirm('Deseja excluir o perfil' +idperfil+'?')) { 
                    window.location.href='deletar_perfil.do?idperfil='+idperfil;
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
                                    PerfilDAO pDB = new PerfilDAO();
                                    pDB.conectar();
                                    ArrayList<Perfil> lista = pDB.listar();
                                    pDB.desconectar();
                            %>
                            <%
                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            %>
                            <h2>Perfil</h2>
                            <a href="form_inserir_perfil.jsp"><img src="imagens/ico_novo.png" border="0"/></a>  
                                <%                                }
                                %><table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Perfil</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        //enquanto tiver dados na lista ele vai atribuir para o objeto p de Perfil
                                        for (Perfil p : lista) {
                                            int idperfil = p.getIdPerfil();
                                            String perfil = p.getPrefil();
                                    %>
                                    <tr>

                                        <td><%=idperfil%></td>
                                        <td><%=perfil%></td>
                                        <%
                                            if ((p.getIdPerfil() != 1) && (usuario.getPerfil().getIdPerfil() <= 1)) {
                                        %>
                                        <td align="center"><a href="form_alterar_perfil.jsp?idperfil=<%=idperfil%>"><img src="imagens/ico_alterar.gif" border="0"/></a>
                                            <a href="javascript: deletarPerfil(<%=idperfil%>); "><img src="imagens/ico_excluir.gif" border="0"/></a>
                                            <a href="form_gerenciar_menu_perfil.jsp?idperfil=<%=idperfil%>"><img src="imagens/ico_ger.jpg" border="0"/></a>

                                        </td>
                                        <%
                                            }
                                        %>
                                    </tr>
                                    <%

                                            }


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
