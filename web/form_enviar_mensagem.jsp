<%-- 
    Document   : form_enviar_mensagem
    Created on : 01/12/2012, 17:35:47
    Author     : Everton
--%>

<%@page import="classes.Cliente"%>
<%@page import="DAO.ClienteDAO"%>
<%@page import="classes.Funcionario"%>
<%@page import="DAO.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <%char flag = 0;%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Mensagem</title>
        <script type="text/javascript" language="javascript">
            function validaForm(){
                var formulario = document.form_mensagem;
                if(formulario.descricao.value == ""){
                    alert("O corpo da mensagem deve ser preenchido!");
                    return false;
                }
                if(formulario.titulo.value == ""){
                    alert("O titulo da mensagem deve ser preenchido!");
                    return false;
                }
                if(formulario.Funcionario_ifFuncionario.value == ""){
                    alert("Deve haver um fucionario ser preenchido!");
                    return false;
                }
                if(formulario.Cliente_idCliente.value == ""){
                    alert("Deve haver um cliente preenchido!");
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
                            <h2>Enviar Mensagem</h2>
                            <form name="form_mensagem" action="enviar_mensagem.do" method="post" onsubmit="return validaForm();">
                                <p>Titulo:<input type="text" name="titulo" value=""/></p>
                                    <%
                                        try {

                                            FuncionarioDAO uDB = new FuncionarioDAO();
                                            uDB.conectar();
                                            ArrayList<Funcionario> lista = uDB.listar();
                                            uDB.desconectar();
                                            for (Funcionario u : lista) {
                                                if (u.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                                    %>
                                <input type="hidden" name="Funcionario_idFuncionario" value="<%=u.getIdFuncionario()%>">
                                <%
                                                flag = 1;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                %>
                                <%
                                    if (flag == 0) {
                                %>
                                <select name="Funcionario_idFuncionario" size="1">
                                    <option value="">Selecione um funcionario</option>
                                    <%
                                        try {
                                            FuncionarioDAO uDB = new FuncionarioDAO();
                                            uDB.conectar();
                                            ArrayList<Funcionario> lista = uDB.listar();
                                            uDB.desconectar();
                                            for (Funcionario u : lista) {

                                                out.print("<option value='" + u.getIdFuncionario() + "'>" + u.getNome() + "</option>");
                                            }

                                        } catch (Exception e) {
                                            out.println(e);
                                        }


                                    %>
                                </select>
                                <%
                                    }
                                %>
                                <%
                                    try {
                                        flag = 0;
                                        ClienteDAO uDB = new ClienteDAO();
                                        uDB.conectar();
                                        ArrayList<Cliente> lista = uDB.listar();
                                        uDB.desconectar();
                                        for (Cliente u : lista) {
                                            if (u.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                                %>
                                <input type="hidden" name="Cliente_idCliente" value="<%=u.getIdCliente()%>">
                                <%
                                                flag = 1;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                %>
                                <%
                                    if (flag == 0) {
                                %>
                                <select name="Cliente_idCliente" size="1">
                                    <option value="">Selecione um cliente</option>
                                    <%
                                        try {
                                            ClienteDAO uDB = new ClienteDAO();
                                            uDB.conectar();
                                            ArrayList<Cliente> lista = uDB.listar();
                                            uDB.desconectar();
                                            for (Cliente u : lista) {
                                                out.print("<option value='" + u.getIdCliente() + "'>" + u.getNome() + "</option>");
                                            }

                                        } catch (Exception e) {
                                            out.println(e);
                                        }


                                    %>
                                </select>
                                <%
                                    }
                                %>
                                <p><textarea cols="80" rows="10" name="descricao" ></textarea></p>

                                <input type="submit" value="Enviar" />       
                            </form>
                        </div>



                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
