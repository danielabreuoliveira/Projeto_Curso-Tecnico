<%-- 
    Document   : form_inserir_funcionario
    Created on : 01/12/2012, 14:46:21
    Author     : Everton
--%>

<%@page import="classes.Empresa"%>
<%@page import="DAO.EmpresaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Funcionario</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_funcionario;
                if(formulario.nome.value == ""){
                    alert("O campo nome deve ser preenchido!");
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
                    alert("O campo uf deve ser preenchido!");
                    return false;
                }
                if(formulario.telefone.value == ""){
                    alert("O campo telefone deve ser preenchido!");
                    return false;
                }
                if(formulario.ddd.value == ""){
                    alert("O campo ddd deve ser preenchido!");
                    return false;
                }
                if(formulario.Empresa_cnpj.value == ""){
                    alert("Tem que escolher uma empresa!");
                    return false;
                }
                if(formulario.Usuario_idUsuario.value == ""){
                    alert("Tem que escolher um usuario!");
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
                            <h2>Inserir Novo Funcionario</h2>
                            <form name="form_funcionario" action="inserir_funcionario.do" method="post" onsubmit="return validaForm();">
                                <p>Nome:<input type="text" name="nome" value=""/></p>
                                <p>Endereco:<input type="text" name="endereco" value=""/></p>
                                <p>Cidade:<input type="text" name="cidade" value=""/></p>
                                <p>UF:<input type="text" name="uf" value=""/></p>
                                <p>DDD:<input type="text" name="ddd" value=""/></p>
                                <p>Telefone:<input type="text" name="telefone" value=""/></p>

                                <p>
                                    <select name="Usuario_idusuario" size="1">
                                        <option value="">Selecione um usuario</option>
                                        <%
                                            try {
                                                UsuarioDAO uDB = new UsuarioDAO();
                                                uDB.conectar();
                                                ArrayList<Usuario> lista = uDB.listar();
                                                uDB.desconectar();
                                                for (Usuario u : lista) {
                                                    out.print("<option value='" + u.getIdUsuario() + "'>" + u.getNome() + "</option>");
                                                }

                                            } catch (Exception e) {
                                                out.println(e);
                                            }


                                        %>
                                    </select>
                                </p>
                                <p>
                                    <select name="Empresa_cnpj" size="1">
                                        <option value="">Selecione uma empresa</option>
                                        <%
                                            try {
                                                EmpresaDAO eDB = new EmpresaDAO();
                                                eDB.conectar();
                                                ArrayList<Empresa> lista = eDB.listar();
                                                eDB.desconectar();
                                                for (Empresa e : lista) {
                                                    out.print("<option value='" + e.getCnpj() + "'>" + e.getNomeEmpresa() + "</option>");
                                                }

                                            } catch (Exception e) {
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
