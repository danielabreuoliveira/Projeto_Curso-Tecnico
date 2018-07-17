<%-- 
    Document   : index
    Created on : 20/08/2011, 15:31:09
    Author     : Jota
--%>

<%@page import="classes.Menu"%>
<%@page import="DAO.MenuDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lita Menu</title>
        <script type="text/javascript" language="javascript">
            function deletarMenu(idmenu){
                if (confirm('Deseja excluir o menu' +idmenu+'?')) { 
                    window.location.href='deletar_menu.do?idmenu='+idmenu;
                }  
            }            
                        
        </script>
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

                            <%
                                try {
                                    MenuDAO mDB = new MenuDAO();
                                    ArrayList<Menu> lista;
                                    mDB.conectar();
                                    lista = mDB.listar();
                            %>
                            <%
                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            %>

                            <h2>Lista de Menus (<a href="form_inserir_menu.jsp">Novo</a>)</h2>

                            <%                                        }
                            %>
                            <table width="550" border="1">
                                <tr>
                                    <td>ID</td>
                                    <td>Menu</td>
                                    <td>Link</td>
                                    <td>Opções</td>

                                </tr> 

                                <%
                                    for (Menu m : lista) {
                                %>
                                <tr>
                                    <td><%=m.getIdMenu()%></td>
                                    <td><%=m.getNome()%></td>
                                    <td><%=m.getLink()%></td>
                                    <%
                                        if ((usuario.getPerfil().getIdPerfil() <= 1)) {
                                    %>
                                    <td><a href="form_alterar_menu.jsp?idmenu=<%=m.getIdMenu()%>"><img src="imagens/ico_alterar.gif"/></a>
                                        <a href="javascript: deletarMenu(<%=m.getIdMenu()%>); "><img src="imagens/ico_excluir.gif"/></a></td>
                                </tr>
                                <%
                                    }
                                %>
                                <%
                                        }
                                        mDB.desconectar();
                                    } catch (Exception erro) {
                                        out.print(erro);
                                    }
                                %>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
