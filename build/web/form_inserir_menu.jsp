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
        <title>Inserir Menu</title>
        <script type="text/javascript" language="javascript">
             function validaForm(){
                 var formulario = document.form_inserir_menu;
                 if(formulario.menu.value == ""){
                     alert("O campo menu deve ser preenchido!");
                     return false;
                 }
                 if(formulario.link.value == ""){
                     alert("O campo link deve ser preenchido!");
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
                     <h2>Inserir Novo Menu</h2>
                     <form name="form_inserir_menu" action="inserir_menu.do" method="post" onsubmit="return validaForm();">
                         <p> Menu: <input type="text" name="nome"  value=""/></p>
                         <p>Link: <input type="text" name="link"  value=""/></p>
                         <input type="submit" value="Salvar" />       
                     </form>
                     </div>
                    
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
