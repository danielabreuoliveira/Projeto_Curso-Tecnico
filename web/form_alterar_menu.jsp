<%-- 
    Document   : form_alterar_menu
    Created on : 20/08/2011, 15:31:09
    Author     : Jota
--%>


<%@page import="classes.Menu"%>
<%@page import="DAO.MenuDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" >
            function validaForm(){
                formulario = document.form_menu;
                if(formulario.menu.value==""){
                    alert("O Campo menu deve ser preenchido!!");
                    formulario.menu.focus();
                    return false;
                }
                if(formulario.link.value==""){
                    alert("O Campo link deve ser preenchido!!");
                    formulario.link.focus();
                    return false;
                }
                return true;
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <table width="760" border="1">
                <tr>
                    <td width="760" height="150">
                        <%@include file="banner.jsp" %>
                    </td>
                </tr>
                <tr>
                    <td width="760" height="20" valign="top">
                        <%@include file="menu.jsp" %>
                    </td>
                </tr>
                <tr>
                    <td width="760" height="330">
                        <div align="center">
                            <h2>Alterando Menu</h2>
                            <form name="form_menu" action="alterar_menu.do" method="post" onsubmit="return validaForm();">
                                <table width="300" border="0">
                                    <%
                                        int idmenu = Integer.parseInt(request.getParameter("idmenu"));
                                        try {
                                            MenuDAO mDB = new MenuDAO();
                                            mDB.conectar();
                                            Menu m = mDB.carregarPorId(idmenu);
                                            mDB.desconectar();
                                            if (m.getIdMenu() > 0) {
                                    %>
                                    <tr>
                                        <td>ID:</td>
                                        <td><%=m.getIdMenu()%> <input type="hidden" name="idmenu" value="<%=m.getIdMenu()%>"> </td>
                                    </tr>
                                    <tr>
                                        <td>Menu:</td>
                                        <td>
                                            <input type="text" name="nome" value="<%=m.getNome()%>" size="60">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Link:</td>
                                        <td>
                                            <input type="text" name="link" value="<%=m.getLink()%>" size="60">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="Alterar"></td>
                                    </tr>
                                    <%
                                            }
                                        } catch (Exception erro) {
                                            out.print(erro);
                                        }
                                    %>
                                </table>
                            </form>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
