<%-- 
    Document   : form_alterar_usuario
    Created on : 20/08/2011, 15:31:09
    Author     : Jota
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="classes.Perfil"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="classes.Usuario"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" >
            function validaForm(){
                formulario = document.form_usuario;
                if(formulario.idperfil.value==""){
                    alert("O Campo Perfil deve ser selecionado!!");
                    formulario.idperfil.focus();
                    return false;
                }
                if(formulario.nome.value==""){
                    alert("O Campo Nome deve ser preenchido!!");
                    formulario.nome.focus();
                    return false;
                }
                if(formulario.login.value==""){
                    alert("O Campo Login deve ser preenchido!!");
                    formulario.login.focus();
                    return false;
                }
                if(formulario.senha.value==""){
                    alert("O Campo Senha deve ser preenchido!!");
                    formulario.senha.focus();
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
                            <h2>Alterando Usuario</h2>
                            <form name="form_usuario" action="alterar_usuario.do" method="post" onsubmit="return validaForm();">
                            <table width="300" border="0">
                                <%
                                            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
                                            try {
                                                UsuarioDAO uDB = new UsuarioDAO();
                                                uDB.conectar();
                                                Usuario us = uDB.carregarPorId(idusuario);
                                                uDB.desconectar();
                                                if (us.getIdUsuario()>0){
                                                    %>
                                                    <tr>
                                                        <td>ID:</td>
                                                        <td><%=us.getIdUsuario() %> <input type="hidden" name="idusuario" value="<%=us.getIdUsuario() %>"> </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Perfil:</td>
                                                        <td>
                                                            <select name="idperfil" size="1">
                                                                <option value="">Selecione um Perfil</option>
                                                                <%
                                                                try {
                                                                    PerfilDAO pDB = new PerfilDAO();
                                                                    ArrayList<Perfil> lista;
                                                                    pDB.conectar();
                                                                    lista = pDB.listar();
                                                                    for(Perfil p:lista){
                                                                        if(p.getIdPerfil() == us.getPerfil().getIdPerfil()){
                                                                            %>
                                                                            <option value="<%=p.getIdPerfil() %>" selected><%=p.getPrefil() %></option>
                                                                            <%
                                                                        }else{
                                                                            %>
                                                                            <option value="<%=p.getIdPerfil() %>"><%=p.getPrefil() %></option>
                                                                            <%
                                                                        }
                                                                    }
                                                                    pDB.desconectar();
                                                                } catch (Exception erro) {
                                                                    out.print(erro);
                                                                }
                                                                %>
                                                            </select>
                                                                                              </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nome:</td>
                                                        <td>
                                                            <input type="text" name="nome" value="<%=us.getNome() %>" size="60">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Login:</td>
                                                        <td><input type="text" name="login" value="<%=us.getLogin() %>"  size="30" /> </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Senha:</td>
                                                        <td><input type="password" name="senha" value="<%=us.getSenha() %>"  size="30" /> </td>
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
