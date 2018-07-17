<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_login;
                if(formulario.login.value==""){
                    alert("O campo login deve ser preenchido!"); 
                    formulario.login.focus();
                    return false;
                }
                if(formulario.senha.value==""){
                    alert("O campo senha deve ser preenchido!"); 
                    formulario.senha.focus();
                    return false;
                }
                return true;
            }           
        </script>
    <style type="text/css">
    @import url("css/text.css");
    </style>
    </head>
<body>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <div align="center">
<table width="500" border="0" align="center">
                <form name="form_login" method="post" action="efetuar_login2.do" onsubmit="return validaForm();">
                    <tr width="70" colrows="3">
                        <td><img src="imagens/SISP&S.gif" border="0" width="760" height="150"/></td>                        
                          <tr class="home">
                                <td class="imgg">
                                  Login: 
                                  <input type="text" name="login"/>            
                                </td>
                            
                            </tr>
                             <tr>
                              <td class="imgg">
                                  Senha: 
                                  <input type="password" name="senha"/>            
                              </td>                            
                             </tr>
                              <tr>
                              <td>
                                      <input name="entrar" type="submit" class="grid_3" value="Entrar"/>
                                </td>
                              </tr>
                    </tr>
                 </form>
            </table>
        </div>
    </body>
</html>