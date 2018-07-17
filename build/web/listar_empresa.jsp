<%-- 
    Document   : listar_empresa
    Created on : 01/12/2012, 09:10:07
    Author     : Everton
--%>

<%@page import="DAO.EmpresaDAO"%>
<%@page import="classes.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresa</title>
        <script type="text/javascript" language="javascript">
            function deletarEmpresa(cnpj){
                if (confirm('Deseja excluir a empresa' +cnpj+'?')) { 
                    window.location.href='deletar_empresa.do?cnpj='+cnpj;
                }  
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



                            <%
                                try {
                                    EmpresaDAO eDB = new EmpresaDAO();
                                    eDB.conectar();
                                    ArrayList<Empresa> lista = eDB.listar();
                                    eDB.desconectar();
                            %>
                            <%
                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            %>
                            <h2>Empresa</h2>
                            <a href="form_inserir_empresa.jsp"><img src="imagens/ico_novo.png" border="0"/></a>  
                                <%                                }
                                %><table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>CNPJ</th>
                                        <th>Nome Empresa</th>
                                        <th>Endereço</th>
                                        <th>Cidade</th>
                                        <th>UF</th>
                                        <th>DDD</th>
                                        <th>Telefone</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        //enquanto tiver dados na lista ele vai atribuir para o objeto p de Perfil
                                        for (Empresa e : lista) {
                                            String cnpj = e.getCnpj();
                                            String nomeEmpresa = e.getNomeEmpresa();
                                            String endereco = e.getEndereco();
                                            String cidade = e.getCidade();
                                            String uf = e.getUf();
                                            int ddd = e.getDdd();
                                            String telefone = e.getTelefone();
                                    %>
                                    <tr>

                                        <td><%=cnpj%></td>
                                        <td><%=nomeEmpresa%></td>
                                        <td><%=endereco%></td>
                                        <td><%=cidade%></td>
                                        <td><%=uf%></td>
                                        <td>(<%=ddd%>)</td>
                                        <td><%=telefone%></td>
                                        <%
                                            if ((usuario.getPerfil().getIdPerfil() <= 1)) {
                                        %>
                                        <td align="center"><a href="form_alterar_empresa.jsp?cnpj=<%=e.getCnpj()%>"><img src="imagens/ico_alterar.gif" border="0"/></a>
                                            <a href="javascript: deletarEmpresa(<%=cnpj%>); "><img src="imagens/ico_excluir.gif" border="0"/></a>
                                           
                                        </td>
                                        <%
                                            }
                                        %>
                                    </tr>
                                    <%

                                            }


                                        } catch (Exception e) {
                                            out.print(e);
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
