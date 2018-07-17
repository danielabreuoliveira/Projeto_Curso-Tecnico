package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import classes.Cliente;
import DAO.ClienteDAO;
import classes.Funcionario;
import DAO.FuncionarioDAO;
import java.sql.SQLException;
import classes.Perfil;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import DAO.PerfilDAO;
import classes.Menu;
import classes.Usuario;

public final class form_005fenviar_005fmensagem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/banner.jsp");
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">\n");
      out.write("<html>\n");
      out.write("    ");
char flag = 0;
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Enviar Mensagem</title>\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("            function validaForm(){\n");
      out.write("                var formulario = document.form_mensagem;\n");
      out.write("                if(formulario.descricao.value == \"\"){\n");
      out.write("                    alert(\"O corpo da mensagem deve ser preenchido!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.titulo.value == \"\"){\n");
      out.write("                    alert(\"O titulo da mensagem deve ser preenchido!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.Funcionario_ifFuncionario.value == \"\"){\n");
      out.write("                    alert(\"Deve haver um fucionario ser preenchido!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.Cliente_idCliente.value == \"\"){\n");
      out.write("                    alert(\"Deve haver um cliente preenchido!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("                 \n");
      out.write("            }            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table border=\"1\" width=\"760\">\n");
      out.write("                <tr><td height=\"150\">\n");
      out.write("                        ");
      out.write("<img src=\"imagens/SISP&S.gif\" alt=\"\" title=\"\" width=\"760\" height=\"150\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td height=\"20\">\n");
      out.write("                        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


    Usuario usuario = new Usuario();
    usuario = (Usuario) session.getAttribute("usuario");
    try {

        out.print("<div align='right'>Seja Bem Vindo " + usuario.getNome() + "<a href='sair.jsp'>(Sair)</a></div>");

      out.write("\n");
      out.write("<table border=\"1\"  width=\"760\">\n");
      out.write("    <tr>\n");
      out.write("        ");


            PerfilDAO pDB = new PerfilDAO();
            UsuarioDAO uDB = new UsuarioDAO();
            pDB.conectar();
            ArrayList<Menu> listaMenu = pDB.menusVinculados(usuario.getPerfil().getIdPerfil());
            for (Menu m : listaMenu) {
        
      out.write("\n");
      out.write("        <td><a href=\"");
      out.print(m.getLink());
      out.write('"');
      out.write('>');
      out.print(m.getNome());
      out.write("</a></td>\n");
      out.write("        ");
 }
            pDB.desconectar();
        
      out.write("\n");
      out.write("    </tr>     \n");
      out.write("</table>\n");


    } catch (SQLException e) {

        out.print(e);
        response.sendRedirect("login.jsp");
    } catch (RuntimeException e) {
        out.print(e);
        response.sendRedirect("login.jsp");
    } catch (Exception e) {
        out.print(e);
        response.sendRedirect("login.jsp");
    }

      out.write('\n');
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr><td height=\"370\">\n");
      out.write("                        <div align=\"center\">\n");
      out.write("                            <h2>Enviar Mensagem</h2>\n");
      out.write("                            <form name=\"form_mensagem\" action=\"enviar_mensagem.do\" method=\"post\" onsubmit=\"return validaForm();\">\n");
      out.write("                                <p>Titulo:<input type=\"text\" name=\"titulo\" value=\"\"/></p>\n");
      out.write("                                    ");

                                        try {

                                            FuncionarioDAO uDB = new FuncionarioDAO();
                                            uDB.conectar();
                                            ArrayList<Funcionario> lista = uDB.listar();
                                            uDB.desconectar();
                                            for (Funcionario u : lista) {
                                                if (u.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                                    
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"Funcionario_idFuncionario\" value=\"");
      out.print(u.getIdFuncionario());
      out.write("\">\n");
      out.write("                                ");

                                                flag = 1;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                
      out.write("\n");
      out.write("                                ");

                                    if (flag == 0) {
                                
      out.write("\n");
      out.write("                                <select name=\"Funcionario_idFuncionario\" size=\"1\">\n");
      out.write("                                    <option value=\"\">Selecione um funcionario</option>\n");
      out.write("                                    ");

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


                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                                ");

                                    try {
                                        flag = 0;
                                        ClienteDAO uDB = new ClienteDAO();
                                        uDB.conectar();
                                        ArrayList<Cliente> lista = uDB.listar();
                                        uDB.desconectar();
                                        for (Cliente u : lista) {
                                            if (u.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                                
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"Cliente_idCliente\" value=\"");
      out.print(u.getIdCliente());
      out.write("\">\n");
      out.write("                                ");

                                                flag = 1;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        out.print(e);
                                    }

                                
      out.write("\n");
      out.write("                                ");

                                    if (flag == 0) {
                                
      out.write("\n");
      out.write("                                <select name=\"Cliente_idCliente\" size=\"1\">\n");
      out.write("                                    <option value=\"\">Selecione um cliente</option>\n");
      out.write("                                    ");

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


                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("                                <p><textarea cols=\"80\" rows=\"10\" name=\"descricao\" ></textarea></p>\n");
      out.write("\n");
      out.write("                                <input type=\"submit\" value=\"Enviar\" />       \n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
