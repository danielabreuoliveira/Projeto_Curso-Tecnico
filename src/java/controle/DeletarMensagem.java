/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.MensagemDAO;
import classes.Mensagem;
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
@WebServlet(name = "DeletarMensagem", urlPatterns = {"/deletar_mensagem.do"})
public class DeletarMensagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Deletar Mensagem</title>");
            out.println("</head>");
            out.println("<body>");

            int idMensagem = Integer.parseInt(request.getParameter("idMensagem"));

            try {
                if (idMensagem != 0) {
                    Mensagem m = new Mensagem();
                    m.setIdMensagem(idMensagem);
                    //setando o driver de conexão
                    MensagemDAO mDB = new MensagemDAO();
                    mDB.conectar();
                    mDB.deletar(m);
                    mDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Mensagem excluida com sucesso!');");
                    out.println("location.href='listar_mensagem.jsp';");
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
