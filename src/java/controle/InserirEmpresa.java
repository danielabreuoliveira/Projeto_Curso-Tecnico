/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.EmpresaDAO;
import classes.Empresa;
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
@WebServlet(name = "InserirEmpresa", urlPatterns = {"/inserir_empresa.do"})
public class InserirEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inserir Empresa</title>");
            out.println("</head>");
            out.println("<body>");

            String cnpj = request.getParameter("cnpj");
            String nomeEmpresa = request.getParameter("nomeEmpresa");
            String cidade = request.getParameter("cidade");
            String endereco = request.getParameter("endereco");
            int ddd = 0;
            ddd = Integer.parseInt(request.getParameter("ddd"));
            String telefone = request.getParameter("telefone");
            String uf = request.getParameter("uf");
            if ((!cnpj.trim().equals("")) && (!nomeEmpresa.trim().equals("")) && (!cidade.trim().equals(""))
                    && (!endereco.equals("")) && (ddd != 0) && (!telefone.equals("")) && (!uf.equals(""))) {

                try {
                    Empresa e = new Empresa();
                    e.setCnpj(cnpj);
                    e.setNomeEmpresa(nomeEmpresa);
                    e.setCidade(cidade);
                    e.setEndereco(endereco);
                    e.setDdd(ddd);
                    e.setTelefone(telefone);
                    e.setUf(uf);
                    EmpresaDAO eDB = new EmpresaDAO();
                    eDB.conectar();
                    eDB.inserir(e);
                    eDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Empresa inserida com sucesso!');");
                    out.println("location.href='listar_empresa.jsp';");
                    out.println("</script>");

                } catch (Exception e) {
                    out.print(e);
                }
            } else {
                out.println("<script type='text/javascript' language='javascript'>");
                out.println("alert('Algum campo obrigatório não foi preenchido!');");
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
