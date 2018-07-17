package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("            function validaForm(){\r\n");
      out.write("                var formulario = document.form_login;\r\n");
      out.write("                if(formulario.login.value==\"\"){\r\n");
      out.write("                    alert(\"O campo login deve ser preenchido!\"); \r\n");
      out.write("                    formulario.login.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                if(formulario.senha.value==\"\"){\r\n");
      out.write("                    alert(\"O campo senha deve ser preenchido!\"); \r\n");
      out.write("                    formulario.senha.focus();\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }           \r\n");
      out.write("        </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("    @import url(\"css/text.css\");\r\n");
      out.write("    </style>\r\n");
      out.write("    </head>\r\n");
      out.write("<body>\r\n");
      out.write("        <p>&nbsp;</p>\r\n");
      out.write("        <p>&nbsp;</p>\r\n");
      out.write("        <p>&nbsp;</p>\r\n");
      out.write("        <p>&nbsp;</p>\r\n");
      out.write("        <p>&nbsp;</p>\r\n");
      out.write("        <div align=\"center\">\r\n");
      out.write("<table width=\"500\" border=\"0\" align=\"center\">\r\n");
      out.write("                <form name=\"form_login\" method=\"post\" action=\"efetuar_login2.do\" onsubmit=\"return validaForm();\">\r\n");
      out.write("                    <tr width=\"70\" colrows=\"3\">\r\n");
      out.write("                        <td><img src=\"imagens/SISP&S.gif\" border=\"0\" width=\"760\" height=\"150\"/></td>                        \r\n");
      out.write("                          <tr class=\"home\">\r\n");
      out.write("                                <td class=\"imgg\">\r\n");
      out.write("                                  Login: \r\n");
      out.write("                                  <input type=\"text\" name=\"login\"/>            \r\n");
      out.write("                                </td>\r\n");
      out.write("                            \r\n");
      out.write("                            </tr>\r\n");
      out.write("                             <tr>\r\n");
      out.write("                              <td class=\"imgg\">\r\n");
      out.write("                                  Senha: \r\n");
      out.write("                                  <input type=\"password\" name=\"senha\"/>            \r\n");
      out.write("                              </td>                            \r\n");
      out.write("                             </tr>\r\n");
      out.write("                              <tr>\r\n");
      out.write("                              <td>\r\n");
      out.write("                                      <input name=\"entrar\" type=\"submit\" class=\"grid_3\" value=\"Entrar\"/>\r\n");
      out.write("                                </td>\r\n");
      out.write("                              </tr>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                 </form>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
