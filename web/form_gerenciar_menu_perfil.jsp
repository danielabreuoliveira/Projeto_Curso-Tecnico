<%@page import="classes.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.Perfil"%>
<%@page import="DAO.PerfilDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_gerenciar;
                if(formulario.idmenu.value == ""){
                    alert("O campo Menu deve ser selecionado!");
                    return false;
                }
                if(formulario.idperfil.value == ""){
                    alert("O campo Perfil está inválido!");
                    return false;
                }
                return true;
                 
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
                            <form name="form_gerenciar" method="post" action="gerenciar_menu_perfil.do" onsubmit="return validaForm();">
                                <%
                                    int idperfil = Integer.parseInt(request.getParameter("idperfil"));
                                    Perfil p = new Perfil();
                                    ArrayList<Menu> listaVinculados = new ArrayList<Menu>();
                                    ArrayList<Menu> listaDesVinculados = new ArrayList<Menu>();
                                    try {
                                        PerfilDAO pDB = new PerfilDAO();
                                        pDB.conectar();
                                        p = pDB.carregarPorId(idperfil);
                                        listaVinculados = pDB.menusVinculados(idperfil);
                                        listaDesVinculados = pDB.menusDesvinculados(idperfil);
                                        pDB.desconectar();

                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                %>                     
                                <input type="hidden" name="idperfil" value="<%=p.getIdPerfil()%>"/>
                                <input type="hidden" name="op" value="vincular"/>                                 
                                <table width="500" border="0" >
                                    <tr>
                                        <td align="left">
                                            ID:<%=p.getIdPerfil()%>
                                        </td>
                                        <td align="left">
                                            Perfil:<%=p.getPrefil()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td  colspan="2" align="left">
                                            Menu:
                                            <select name="idmenu" size="1">
                                                <option value="">Selecione um menu</option>
                                                <%
                                                    for (Menu m : listaDesVinculados) {
                                                        out.print("<option value='" + m.getIdMenu() + "'>" + m.getNome() + "</option>");
                                                    }
                                                %>
                                            </select>
                                            <input type="submit" value="Vincular"/>
                                        </td>
                                    </tr>
                                </table>
                                <br /><br />
                            </form>           

                            <table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Menu</th>
                                        <th>Desvincular</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (Menu m : listaVinculados) {
                                    %>
                                    <tr>
                                        <td><%=m.getIdMenu()%></td>
                                        <td><%=m.getNome()%></td>
                                        <td align="center"><a href="gerenciar_menu_perfil.do?idmenu=<%=m.getIdMenu()%>&idperfil=<%=idperfil%>&op=desvincular"><img src="imagens/ico_excluir.gif" border="0"/></a>
                                        </td>
                                    </tr>
                                    <%  }%>
                                </tbody>
                            </table>
                        </div>                 
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
