<%-- 
    Document   : index
    Created on : 13/08/2012, 20:03:39
    Author     : Hpti
--%>

<%@page import="classes.Perfil"%>
<%@page import="DAO.PerfilDAO"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Usuario</title>
        <script type="text/javascript" language="javascript">
             function validaForm(){
                 var formulario = document.form_usuario;
                 if(formulario.nome.value == ""){
                     alert("O campo nome deve ser preenchido!");
                     return false;
                 }
                 if(formulario.login.value == ""){
                     alert("O campo login deve ser preenchido!");
                     return false;
                 }
                 if(formulario.senha.value == ""){
                     alert("O campo senha deve ser preenchido!");
                     return false;
                 }
                 if(formulario.idperfil.value == ""){
                     alert("O campo perfil deve ser preenchido!");
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
                     <h2>Inserir Novo Usuario</h2>
                     <form name="form_usuario" action="inserir_usuario.do" method="post" onsubmit="return validaForm();">
                         <p>Nome:<input type="text" name="nome" value=""/></p>
                         <p>Login:<input type="text" name="login" value=""/></p>
                         <p>Senha:<input type="password" name="senha" value=""/></p>
                         <p>
                         <select name="idperfil" size="1">
                             <option value="">Selecione um perfil</option>
                             <%
                             try{                                 
                                 PerfilDAO pDB= new PerfilDAO();
                                 pDB.conectar();
                                 ArrayList<Perfil> lista = pDB.listar();
                                 pDB.desconectar();
                                 for(Perfil p:lista){
                                     out.print("<option value='"+p.getIdPerfil()+"'>"+p.getPrefil()+"</option>");
                                 }
                             
                             }catch(Exception e){
                                 out.println(e);                             
                             }


                             %>
                         </select>
                         </p>
                         <input type="submit" value="Salvar" />       
                     </form>
                     </div>
                    
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
