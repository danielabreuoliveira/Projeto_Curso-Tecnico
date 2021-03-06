/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PerfilDAO;
import classes.Perfil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everton
 */
@WebServlet(name = "AlterarPerfil", urlPatterns = {"/alterar_perfil.do"})
public class AlterarPerfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Perfil</title>");
            out.println("</head>");
            out.println("<body>");
            String idperfil = request.getParameter("idperfil");
            String perfil = request.getParameter("perfil");
            if ((idperfil.trim().equals("")) || (perfil.trim().equals(""))) {
                out.println("<script type='text/javascript' language='javascript'>");
                out.println("alert('Algum campo obrigatório não foi preenchido!');");
                out.println("history.back();");
                out.println("</script>");

            } else {

                try {
                    Perfil p = new Perfil();
                    p.setIdPerfil(Integer.parseInt(idperfil));
                    p.setPrefil(perfil);
                    //setando o driver de conexão
                    PerfilDAO pDB = new PerfilDAO();
                    pDB.conectar();
                    pDB.alterar(p);
                    pDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Perfil alterado com sucesso!');");
                    out.println("location.href='listar_perfil.jsp';");
                    out.println("</script>");
                } catch (Exception e) {
                    out.print(e);
                }
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
