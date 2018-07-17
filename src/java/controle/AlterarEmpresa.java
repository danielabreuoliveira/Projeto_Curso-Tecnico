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
@WebServlet(name = "AlterarEmpresa", urlPatterns = {"/alterar_empresa.do"})
public class AlterarEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Empresa</title>");
            out.println("</head>");
            out.println("<body>");

            String cnpj = request.getParameter("cnpj");
            String nomeEmpresa = request.getParameter("nomeEmpresa");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String telefone = request.getParameter("telefone");
            String uf = request.getParameter("uf");
            int ddd = Integer.parseInt(request.getParameter("ddd"));
            if (cnpj.trim().equals("")) {
                out.print("<script type='text/javascript' language='javascript'>");
                out.print("alert('O cnpj não foi encontrado!!');");
                out.println("history.back();");
                out.print("</script>");
            } else if ((nomeEmpresa.trim().equals("")) || (cidade.trim().equals(""))
                    || (endereco.equals("")) && (ddd == 0) || (telefone.equals("")) || (uf.equals(""))) {
                out.print("<script type='text/javascript' language='javascript'>");
                out.print("alert('Algum campo obrigatório não foi preenchido!');");
                out.print("history.back();");
                out.print("</script>");
            } else {
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
                    eDB.alterar(e);
                    eDB.desconectar();

                    out.print("<script type='text/javascript' language='javascript'>");
                    out.print("alert('Empresa alterada com sucesso!!');");
                    out.print("location.href='listar_empresa.jsp';");
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
