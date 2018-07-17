<%@page import="classes.Cliente"%>
<%@page import="DAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
        <script type="text/javascript" language="javascript">
            function deletarCliente(idCliete){
                if (confirm('Deseja excluir o cliente' +idCliete+'?')) { 
                    window.location.href='deletar_cliente.do?idCliente='+idCliete;
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
                                    ClienteDAO cDB = new ClienteDAO();
                                    cDB.conectar();
                                    ArrayList<Cliente> lista = cDB.listar();


                            %>
                            <h2>Lista de Clientes</h2>
                            <%
                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            %>
                            <a href="form_inserir_cliente.jsp">
                                <img src="imagens/ico_novo.png" border="0"/>
                            </a> 
                            <%                                }

                            %>
                            <table border="1" width="500">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Endereco</th>
                                        <th>Cidade</th>
                                        <th>UF</th>
                                        <th>DDD</th>
                                        <th>Telefone</th>
                                        <th>Empresa</th>
                                        <th>Usuario</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <%
                                            for (Cliente cs : lista) {
                                        %>
                                        <td><%=cs.getIdCliente()%></td>
                                        <td><%=cs.getNome()%></td>
                                        <td><%=cs.getEndereco()%></td>
                                        <td><%=cs.getCidade()%></td>
                                        <td><%=cs.getUf()%></td>
                                        <td><%=cs.getDdd()%></td>
                                        <td><%=cs.getTelefone()%></td>
                                        
                                        <td><%=cs.getEmpresa().getNomeEmpresa()%></td>
                                        <td><%=cs.getUsuario().getNome()%></td>
                                        <%
                                            if ((usuario.getPerfil().getIdPerfil() == 1) ||(usuario.getIdUsuario()==cs.getUsuario().getIdUsuario())) {
                                        %>
                                        <td><a href="form_alterar_cliente.jsp?idCliente=<%=cs.getIdCliente()%>"><img src="imagens/ico_alterar.gif"/></a>
                                            <a href="javascript: deletarCliente(<%=cs.getIdCliente()%>); "><img src="imagens/ico_excluir.gif"/></a>
                                                <%
                                                    }
                                                %>



                                        </td>
                                    </tr>
                                    <%

                                            }
                                            cDB.desconectar();


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
