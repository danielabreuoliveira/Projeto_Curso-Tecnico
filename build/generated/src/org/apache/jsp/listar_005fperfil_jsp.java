package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import DAO.PerfilDAO;
import classes.Perfil;
import java.sql.SQLException;
import classes.Perfil;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import DAO.PerfilDAO;
import classes.Menu;
import classes.Usuario;

public final class listar_005fperfil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("            function deletarPerfil(idperfil){\n");
      out.write("                if (confirm('Deseja excluir o perfil' +idperfil+'?')) { \n");
      out.write("                    window.location.href='deletar_perfil.do?idperfil='+idperfil;\n");
      out.write("                }  \n");
      out.write("            }\n");
      out.write("                                   \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table border=\"1\" width=\"760\">\n");
      out.write("                <tr><td height=\"150\">\n");
      out.write("                        ");
      out.write("<img src=\"imagens/banner2.jpg\" alt=\"\" title=\"\" width=\"760\" height=\"150\"/>\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                                try {
                                    PerfilDAO pDB = new PerfilDAO();
                                    pDB.conectar();
                                    ArrayList<Perfil> lista = pDB.listar();
                                    pDB.desconectar();
                            
      out.write("\n");
      out.write("                            ");

                                if (usuario.getPerfil().getIdPerfil() == 1) {
                            
      out.write("\n");
      out.write("                            <h2>Lista de Perfis</h2>\n");
      out.write("                            <a href=\"form_inserir_perfil.jsp\"><img src=\"imagens/ico_novo.png\" border=\"0\"/></a>  \n");
      out.write("                                ");
                                }
                                
      out.write("<table border=\"1\" width=\"500\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>ID</th>\n");
      out.write("                                        <th>Perfil</th>\n");
      out.write("                                        <th>Opções</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        //enquanto tiver dados na lista ele vai atribuir para o objeto p de Perfil
                                        for (Perfil p : lista) {
                                            int idperfil = p.getIdPerfil();
                                            String perfil = p.getPrefil();
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("\n");
      out.write("                                        <td>");
      out.print(idperfil);
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(perfil);
      out.write("</td>\n");
      out.write("                                        ");

                                            if ((p.getIdPerfil() != 1) && (usuario.getPerfil().getIdPerfil() <= 1)) {
                                        
      out.write("\n");
      out.write("                                        <td align=\"center\"><a href=\"form_alterar_perfil.jsp?idperfil=");
      out.print(idperfil);
      out.write("\"><img src=\"imagens/ico_alterar.gif\" border=\"0\"/></a>\n");
      out.write("                                            <a href=\"javascript: deletarPerfil(");
      out.print(idperfil);
      out.write("); \"><img src=\"imagens/ico_excluir.gif\" border=\"0\"/></a>\n");
      out.write("                                            <a href=\"form_gerenciar_menu_perfil.jsp?idperfil=");
      out.print(idperfil);
      out.write("\"><img src=\"imagens/ico_ger.jpg\" border=\"0\"/></a>\n");
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");


                                            }


                                        } catch (Exception e) {
                                            out.print(e);
                                        }
                                    
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
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
