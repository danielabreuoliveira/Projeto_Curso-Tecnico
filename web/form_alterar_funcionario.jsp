<%-- 
    Document   : form_alterar_funcionario
    Created on : 01/12/2012, 14:48:21
    Author     : Everton
--%>

<%@page import="classes.Empresa"%>
<%@page import="DAO.EmpresaDAO"%>
<%@page import="classes.Funcionario"%>
<%@page import="DAO.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Funcionario</title>
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
                            <table width="300" border="0">
                                <%
                                    int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
                                    try {
                                        FuncionarioDAO cDB = new FuncionarioDAO();
                                        cDB.conectar();
                                        Funcionario c = cDB.carregarPorId(idFuncionario);
                                        cDB.desconectar();
                                        if (c.getIdFuncionario() > 0) {
                                %>
                                <tr>

                                </tr>
                                <h2>Alterando Funcionario</h2>
                                </tables>

                                <form name="form_funcionario" action="alterar_funcionario.do" method="post" onsubmit="return validaForm();">
                                    <p>ID:
                                        <%=c.getIdFuncionario()%> <input type="hidden" name="idFuncionario" value="<%=c.getIdFuncionario()%>"> </p>
                                    <p>Nome:<input type="text" name="nome" value="<%=c.getNome()%>"/></p>
                                    <p>Endereco:<input type="text" name="endereco" value="<%=c.getEndereco()%>"/></p>
                                    <p>Cidade:<input type="text" name="cidade" value="<%=c.getCidade()%>"/></p>
                                    <p>UF:<input type="text" name="uf" value="<%=c.getUf()%>"/></p>
                                    <p>DDD:<input type="text" name="ddd" value="<%=c.getDdd()%>"/></p>
                                    <p>Telefone:<input type="text" name="telefone" value="<%=c.getTelefone()%>"/></p>

                                    <p>
                                    <tr>
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
                                    <input type="submit" value="Alterar" />  
                                    <%
                                            }
                                        } catch (Exception erro) {
                                            out.print(erro);
                                        }
                                    %>
                                </form>
                        </div>

                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
