<%@page import="DAO.UsuarioDAO"%>
<%@page import="classes.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="classes.Perfil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link rel=stylesheet type="text/css" href="css/text.css">
        <script type="text/javascript" language="javascript">
            function deletarUsuario(idusuario){
                if (confirm('Deseja excluir o usuario' +idusuario+'?')) { 
                    window.location.href='deletar_usuario.do?idusuario='+idusuario;
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
                                    UsuarioDAO uDB = new UsuarioDAO();
                                    uDB.conectar();
                                    ArrayList<Usuario> lista = uDB.listar();


                            %>
                            <h2>Lista de Usuários</h2>
                            <%
                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            %>
                            <a href="form_inserir_usuario.jsp">
                                <img src="imagens/ico_novo.png" border="0"/>
                            </a> 
                            <%                                }

                            %>
                            <table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Login</th>
                                        <th>Perfil</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <%
                                            for (Usuario us : lista) {
                                        %>
                                        <td><%=us.getIdUsuario()%></td>
                                        <td><%=us.getNome()%></td>
                                        <td><%=us.getLogin()%></td>
                                        <td><%=us.getPerfil().getPrefil()%></td>
                                        <%
                                            if ((usuario.getPerfil().getIdPerfil() == 1) || (us.getIdUsuario() == usuario.getIdUsuario())) {
                                        %>
                                        <td><a href="form_alterar_usuario.jsp?idusuario=<%=us.getIdUsuario()%>"><img src="imagens/ico_alterar.gif"/></a>
                                                <%
                                                    if ((us.getPerfil().getIdPerfil() != 1)) {
                                                %>
                                            <a href="javascript: deletarUsuario(<%=us.getIdUsuario()%>); "><img src="imagens/ico_excluir.gif"/></a>
                                                <% }%>
                                                <%
                                                    }
                                                %>



                                        </td>
                                    </tr>
                                    <%

                                            }
                                            uDB.desconectar();


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
