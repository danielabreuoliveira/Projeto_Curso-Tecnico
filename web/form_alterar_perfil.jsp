<%-- 
    Document   : index
    Created on : 13/08/2012, 20:03:39
    Author     : Hpti
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="classes.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Perfil</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_alterar_perfil;
                if(formulario.perfil.value == ""){
                    alert("O campo perfil deve ser preenchido!");
                    formulario.perfil.focus();
                    return false;
                }
                if(formulario.idperfil.value == ""){
                    alert("O campo idperfil deve ser preenchido!");
                    formulario.idperfil.focus();
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

                            <%
                                int idperfil = Integer.parseInt(request.getParameter("idperfil"));
                                Perfil p = new Perfil();
                                try {
                                    PerfilDAO pDB = new PerfilDAO();
                                    pDB.conectar();
                                    p = pDB.carregarPorId(idperfil);
                                    pDB.desconectar();
                                } catch (Exception e) {
                                    out.print(e);
                                }
                                if (p.getIdPerfil() > 0) {
                            %>
                            <form name="form_alterar_perfil" action="alterar_perfil.do" method="post" onsubmit="return validaForm();">
                                <input type="hidden" name="idperfil" value="<%=p.getIdPerfil()%>"/>
                                <table width="500">
                                    <tr>
                                        <td>ID PERFIL:</td>
                                        <td><%=p.getIdPerfil()%></td>
                                    </tr>
                                    <tr>
                                        <td>Perfil</td>
                                        <td><input type="text" name="perfil" value="<%=p.getPrefil()%>"/></td>
                                    </tr>
                                </table>
                                <input type="submit" name="enviar" value="enviar"/>
                            </form>
                            <%
                            } else {%>

                            <script type="text/javascript" language="javascript">
                                alert("Perfil não foi encontrado!");
                                location.href='listar_perfil.jsp';
                            </script>

                            <%                                }
                            %>
                            </tbody>
 
            </table>
        </div>

    </body>
</html>
