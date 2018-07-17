<%-- 
    Document   : form_alterar_empresa
    Created on : 01/12/2012, 08:48:55
    Author     : Everton
--%>

<%@page import="DAO.EmpresaDAO"%>
<%@page import="classes.Empresa"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Empresa</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_alterar_empresa;
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
                         <%
                                String cnpj = request.getParameter("cnpj");
                                Empresa e = new Empresa();
                                try {
                                    EmpresaDAO eDB = new EmpresaDAO();
                                    eDB.conectar();
                                    e = eDB.carregarPorCnpj(cnpj);
                                    eDB.desconectar();
                                } catch (Exception ex) {
                                    out.print(ex);
                                }
                                if (!e.getCnpj().trim().equals("")) {
                            %>
                        <div align="center">
                            <h2>Alterar Empresa</h2>
                            <form name="form_alterar_empresa" action="alterar_empresa.do" method="post" onsubmit="return validaForm();">
                                <input type="hidden" name="cnpj" value="<%=cnpj%>"/>
                                <p>CNPJ: <%=e.getCnpj()%></p>
                                <p>Nome: <input type="text" name="nomeEmpresa"  value="<%=e.getNomeEmpresa()%>"/></p>
                                <p>Endereco: <input type="text" name="endereco"  value="<%=e.getEndereco()%>"/></p>
                                <p>Cidade: <input type="text" name="cidade"  value="<%=e.getCidade()%>"/></p>
                                <p>UF: <input type="text" name="uf"  value="<%=e.getUf()%>"/></p>
                                <p>DDD: <input type="text" name="ddd"  value="<%=e.getDdd()%>"/></p>
                                <p>Telefone: <input type="text" name="telefone"  value="<%=e.getTelefone()%>"/></p>
                                <input type="submit" value="Salvar" />       
                            </form>
                                <%
                            } else {%>

                            <script type="text/javascript" language="javascript">
                                alert("Empresa não foi encontrada!");
                                location.href='listar_empresa.jsp';
                            </script>

                            <%                                }
                            %>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
