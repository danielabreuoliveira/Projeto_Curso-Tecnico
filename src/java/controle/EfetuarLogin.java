/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.UsuarioDAO;
import classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Everton
 */
@WebServlet(name = "EfetuarLogin3", urlPatterns = {"/efetuar_login2.do"})
public class EfetuarLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Efetuar Login</title>");
            out.println("</head>");
            out.println("<body>");

            HttpSession session = request.getSession();
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            try {
                UsuarioDAO uDB = new UsuarioDAO();
                uDB.conectar();
                Usuario u = new Usuario();
                u = uDB.logar(login, senha);
                uDB.desconectar();
                if (u.getIdUsuario() > 0) {
                    session.setAttribute("usuario", u);
                    response.sendRedirect("index.jsp");

                } else {
                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Usuario e senha inválidos!');");
                    out.println("location.href='login.jsp';");
                    out.println("</script>");
                }

            } catch (Exception e) {
                out.print(e);
            }

            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
