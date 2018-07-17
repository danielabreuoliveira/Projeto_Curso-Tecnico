<%-- 
    Document   : form_inserir_empresa
    Created on : 01/12/2012, 08:35:31
    Author     : Everton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Empresa</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_inserir_empresa;
                if(formulario.cnpj.value == ""){
                    alert("O campo CNPJ deve ser preenchido!");
                    return false;
                }
                
                if(formulario.nomeEmpresa.value == ""){
                    alert("O campo nome da empresa deve ser preenchido!");
                    return false;
                }
                if(formulario.endereco.value == ""){
                    alert("O campo endereço deve ser preenchido!");
                    return false;
                }
                 
                if(formulario.cidade.value == ""){
                    alert("O campo cidade deve ser preenchido!");
                    return false;
                }
                if(formulario.uf.value == ""){
                    alert("O campo UF deve ser preenchido!");
                    return false;
                }
                if(formulario.ddd.value == ""){
                    alert("O campo ddd deve ser preenchido!");
                    return false;
                }
                if(formulario.telefone.value == ""){
                    alert("O campo telefone deve ser preenchido!");
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
                            <h2>Inserir Empresa</h2>
                            <form name="form_inserir_empresa" action="inserir_empresa.do" method="post" onsubmit="return validaForm();">
                                <p>CNPJ: <input type="text" name="cnpj"  value=""/></p>
                                <p>Nome: <input type="text" name="nomeEmpresa"  value=""/></p>
                                <p>Endereco: <input type="text" name="endereco"  value=""/></p>
                                <p>Cidade: <input type="text" name="cidade"  value=""/></p>
                                <p>UF: <input type="text" name="uf"  value=""/></p>
                                <p>DDD: <input type="text" name="ddd"  value=""/></p>
                                <p>Telefone: <input type="text" name="telefone"  value=""/></p>
                                <input type="submit" value="Salvar" />       
                            </form>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
