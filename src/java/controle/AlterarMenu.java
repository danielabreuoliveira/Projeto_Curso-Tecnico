/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.MenuDAO;
import classes.Menu;
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
@WebServlet(name = "AlterarMenu", urlPatterns = {"/alterar_menu.do"})
public class AlterarMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Menu</title>");
            out.println("</head>");
            out.println("<body>");

            int idmenu = Integer.parseInt(request.getParameter("idmenu"));
            String menu = request.getParameter("nome");
            String link = request.getParameter("link");
            if (idmenu <= 0) {
                out.print("<script type='text/javascript' language='javascript'>");
                out.print("alert('O ID do Menu nãoo foi encontrado!!');");
                out.println("history.back();");
                out.print("</script>");
            } else if (menu.equals("") || link.equals("")) {
                out.print("<script type='text/javascript' language='javascript'>");
                out.print("alert('Algum campo obrigatório não foi preenchido!');");
                out.print("history.back();");
                out.print("</script>");
            } else {
                try {
                    Menu m = new Menu();
                    m.setIdMenu(idmenu);
                    m.setNome(menu);
                    m.setLink(link);

                    MenuDAO mDB = new MenuDAO();
                    mDB.conectar();
                    mDB.alterar(m);
                    mDB.desconectar();

                    out.print("<script type='text/javascript' language='javascript'>");
                    out.print("alert('Menu alterado com sucesso!!');");
                    out.print("location.href='listar_menu.jsp';");
                    out.print("</script>");

                } catch (Exception erro) {
                    out.print(erro);
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
