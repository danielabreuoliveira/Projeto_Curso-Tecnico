package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import classes.Perfil;
import DAO.PerfilDAO;
import classes.Usuario;
import DAO.UsuarioDAO;
import java.sql.*;
import java.sql.SQLException;
import classes.Perfil;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import DAO.PerfilDAO;
import classes.Menu;
import classes.Usuario;

public final class form_005falterar_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script language=\"javascript\" >\n");
      out.write("            function validaForm(){\n");
      out.write("                formulario = document.form_usuario;\n");
      out.write("                if(formulario.idperfil.value==\"\"){\n");
      out.write("                    alert(\"O Campo Perfil deve ser selecionado!!\");\n");
      out.write("                    formulario.idperfil.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.nome.value==\"\"){\n");
      out.write("                    alert(\"O Campo Nome deve ser preenchido!!\");\n");
      out.write("                    formulario.nome.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.login.value==\"\"){\n");
      out.write("                    alert(\"O Campo Login deve ser preenchido!!\");\n");
      out.write("                    formulario.login.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(formulario.senha.value==\"\"){\n");
      out.write("                    alert(\"O Campo Senha deve ser preenchido!!\");\n");
      out.write("                    formulario.senha.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table width=\"760\" border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td width=\"760\" height=\"150\">\n");
      out.write("                        ");
      out.write("<img src=\"imagens/SISP&S.gif\" alt=\"\" title=\"\" width=\"760\" height=\"150\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td width=\"760\" height=\"20\" valign=\"top\">\n");
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
      out.write("                <tr>\n");
      out.write("                    <td width=\"760\" height=\"330\">\n");
      out.write("                        <div align=\"center\">\n");
      out.write("                            <h2>Alterando Usuario</h2>\n");
      out.write("                            <form name=\"form_usuario\" action=\"alterar_usuario.do\" method=\"post\" onsubmit=\"return validaForm();\">\n");
      out.write("                            <table width=\"300\" border=\"0\">\n");
      out.write("                                ");

                                            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
                                            try {
                                                UsuarioDAO uDB = new UsuarioDAO();
                                                uDB.conectar();
                                                Usuario us = uDB.carregarPorId(idusuario);
                                                uDB.desconectar();
                                                if (us.getIdUsuario()>0){
                                                    
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>ID:</td>\n");
      out.write("                                                        <td>");
      out.print(us.getIdUsuario() );
      out.write(" <input type=\"hidden\" name=\"idusuario\" value=\"");
      out.print(us.getIdUsuario() );
      out.write("\"> </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        ");
 if(usuario.getIdUsuario()==1){
      out.write("\n");
      out.write("                                                        <td>Perfil:</td>\n");
      out.write("                                                        <td>\n");
      out.write("                                                            <select name=\"idperfil\" size=\"1\">\n");
      out.write("                                                                <option value=\"\">Selecione um Perfil</option>\n");
      out.write("                                                                ");

                                                                try {
                                                                    PerfilDAO pDB = new PerfilDAO();
                                                                    ArrayList<Perfil> lista;
                                                                    pDB.conectar();
                                                                    lista = pDB.listar();
                                                                    for(Perfil p:lista){
                                                                        if(p.getIdPerfil() == us.getPerfil().getIdPerfil()){
                                                                            
      out.write("\n");
      out.write("                                                                            <option value=\"");
      out.print(p.getIdPerfil() );
      out.write("\" selected>");
      out.print(p.getPrefil() );
      out.write("</option>\n");
      out.write("                                                                            ");

                                                                        }else{
                                                                            
      out.write("\n");
      out.write("                                                                            <option value=\"");
      out.print(p.getIdPerfil() );
      out.write('"');
      out.write('>');
      out.print(p.getPrefil() );
      out.write("</option>\n");
      out.write("                                                                            ");

                                                                        }
                                                                    }
                                                                    pDB.desconectar();
                                                                } catch (Exception erro) {
                                                                    out.print(erro);
                                                                }
                                                                
      out.write("\n");
      out.write("                                                            </select>\n");
      out.write("                                                           ");
 }else{
      out.write("\n");
      out.write("                                                                    <input type=\"hidden\" name=\"idperfil\" value=\"");
      out.print(usuario.getPerfil().getIdPerfil() );
      out.write(" \">\n");
      out.write("                                                                    ");
}
      out.write("\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Nome:</td>\n");
      out.write("                                                        <td>\n");
      out.write("                                                            <input type=\"text\" name=\"nome\" value=\"");
      out.print(us.getNome() );
      out.write("\" size=\"60\">\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Login:</td>\n");
      out.write("                                                        <td><input type=\"text\" name=\"login\" value=\"");
      out.print(us.getLogin() );
      out.write("\"  size=\"30\" /> </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>Senha:</td>\n");
      out.write("                                                        <td><input type=\"password\" name=\"senha\" value=\"");
      out.print(us.getSenha() );
      out.write("\"  size=\"30\" /> </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td><input type=\"submit\" value=\"Alterar\"></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    ");

                                                }
                                            } catch (Exception erro) {
                                                out.print(erro);
                                            }
                                
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            </form>\n");
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
