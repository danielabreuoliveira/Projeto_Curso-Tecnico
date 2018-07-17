/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.MensagemDAO;
import classes.Cliente;
import classes.Funcionario;
import classes.Mensagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everton
 */
@WebServlet(name = "EnviarMensagem", urlPatterns = {"/enviar_mensagem.do"})
public class EnviarMensagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Enviar Mensagem</title>");
            out.println("</head>");
            out.println("<body>");
            String descricao = request.getParameter("descricao");
            String titulo = request.getParameter("titulo");
            int idFuncionario = 0;
            idFuncionario = Integer.parseInt(request.getParameter("Funcionario_idFuncionario"));
            int idCliente = 0;
            idCliente = Integer.parseInt(request.getParameter("Cliente_idCliente"));
            if ((!descricao.trim().equals("")) && (!titulo.trim().equals("")) && (idFuncionario != 0)
                    && (idCliente != 0) && (idFuncionario != 0)) {
                try {
                    Mensagem m = new Mensagem();
                    m.setDescricao(descricao);
                    m.setTitulo(titulo);

                    ClienteDAO cDB = new ClienteDAO();
                    Cliente c = new Cliente();
                    cDB.conectar();
                    c.setIdCliente(idCliente);
                    c = cDB.carregarPorId(c.getIdCliente());
                    cDB.desconectar();
                    m.setCliente(c);
                    FuncionarioDAO fDB = new FuncionarioDAO();
                    Funcionario f = new Funcionario();
                    fDB.conectar();
                    f.setIdFuncionario(idFuncionario);
                    f = fDB.carregarPorId(f.getIdFuncionario());
                    m.setFuncionario(f);
                    fDB.desconectar();
                    MensagemDAO mDB = new MensagemDAO();
                    mDB.conectar();
                    mDB.inserir(m);
                    mDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Mensagem enviada com sucesso');");
                    out.println("location.href='listar_mensagem.jsp';");
                    out.println("</script>");

                } catch (Exception e) {
                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('" + e + "');");
                    out.println("history.back();");
                    out.println("</script>");
                }
            } else {
                out.println("<script type='text/javascript' language='javascript'>");
                out.println("alert('Todos os campos devem ser informados!');");
                out.println("history.back();");
                out.println("</script>");
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
