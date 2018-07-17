<%-- 
    Document   : index
    Created on : 13/08/2012, 20:03:39
    Author     : Hpti
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Perfil</title>
        <script type="text/javascript" language="javascript">
             function validaForm(){
                 var formulario = document.form_perfil;
                 if(formulario.perfil.value == ""){
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
                     <h2>Inserir Novo Perfil</h2>
                     <form name="form_perfil" action="inserir_perfil.do" method="post" onsubmit="return validaForm();">
                         Perfil:<input type="text" name="perfil" value=""/>
                         <input type="submit" value="Salvar" />       
                     </form>
                     </div>
                    
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
