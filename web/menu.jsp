<%@page import="java.sql.SQLException"%>
<%@page import="classes.Perfil"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="classes.Menu"%>
<%@page import="classes.Usuario"%>
<script>
            // Copyright 2006-2007 javascript-array.com

            var timeout	= 500;
            var closetimer	= 0;
            var ddmenuitem	= 0;


              function mopen(id)
            {	
	
                mcancelclosetime();

                if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

                ddmenuitem = document.getElementById(id);
                ddmenuitem.style.visibility = 'visible';

            }
            function mclose()
            {
                if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
            }


            function mclosetime()
            {
                closetimer = window.setTimeout(mclose, timeout);
            }


            function mcancelclosetime()
            {
                if(closetimer)
                {
                    window.clearTimeout(closetimer);
                    closetimer = null;
                }
            }

            document.onclick = mclose; </script> 
<link rel=stylesheet type="text/css" href="css/text.css">
<link rel=stylesheet type="text/css" href="css/style.css"> 
<%

    Usuario usuario = new Usuario();
    usuario = (Usuario) session.getAttribute("usuario");
    try {

        out.print("<div align='right'>Seja Bem Vindo " + usuario.getNome() + "<a href='sair.jsp'>(Sair)</a></div>");
%>

<ul id="menu">
        <%

            PerfilDAO pDB = new PerfilDAO();
            UsuarioDAO uDB = new UsuarioDAO();
            pDB.conectar();
            ArrayList<Menu> listaMenu = pDB.menusVinculados(usuario.getPerfil().getIdPerfil());
            for (Menu m : listaMenu) {
        %>
        <li><a href="<%=m.getLink()%>"><%=m.getNome()%></a></li>
        <% }
            pDB.desconectar();
        %>
   </ul>
<%

    } catch (SQLException e) {

        out.print(e);
        response.sendRedirect("login.jsp");
    } catch (RuntimeException e) {
        out.print(e);
        response.sendRedirect("login.jsp");
    } catch (Exception e) {
        out.print(e);
        response.sendRedirect("login.jsp");
    }
%>
