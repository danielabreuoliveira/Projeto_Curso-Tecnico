/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ClienteDAO;
import classes.Cliente;
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
@WebServlet(name = "DeletarCliente", urlPatterns = {"/deletar_cliente.do"})
public class DeletarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Deletar Cliente</title>");
            out.println("</head>");
            out.println("<body>");

            int idCliente = Integer.parseInt(request.getParameter("idCliente"));

            try {
                if (idCliente != 0) {
                    Cliente c = new Cliente();
                    c.setIdCliente(idCliente);
                    //setando o driver de conexão
                    ClienteDAO cDB = new ClienteDAO();
                    cDB.conectar();
                    cDB.deletar(c);
                    cDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Cliente excluido com sucesso!');");
                    out.println("location.href='listar_cliente.jsp';");
                    out.println("</script>");
                } else {
                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('ID inválido!');");
                    out.println("history.back();");
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
