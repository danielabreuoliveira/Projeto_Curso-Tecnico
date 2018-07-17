/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.ClienteDAO;
import DAO.EmpresaDAO;
import DAO.UsuarioDAO;
import classes.Cliente;
import classes.Empresa;
import classes.Usuario;
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
@WebServlet(name = "AlterarCliente", urlPatterns = {"/alterar_cliente.do"})
public class AlterarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Usuario</title>");
            out.println("</head>");
            out.println("<body>");
            
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nome = request.getParameter("nome");
            String cidade = request.getParameter("cidade");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String uf = request.getParameter("uf");
            int idUsuario = 0;
            idUsuario = Integer.parseInt(request.getParameter("Usuario_idusuario"));
            int ddd = 0;
            ddd = Integer.parseInt(request.getParameter("ddd"));
            String cnpj = request.getParameter("Empresa_cnpj");
            if ((!nome.trim().equals("")) && (!cidade.trim().equals("")) && (!telefone.trim().equals(""))
                    && (idUsuario != 0) && (ddd != 0) && (!endereco.trim().equals("")) && (!cnpj.trim().equals(""))
                    && (!uf.trim().equals(""))) {
                try {
                    Cliente c = new Cliente();
                    c.setIdCliente(idCliente);
                    c.setCidade(cidade);
                    c.setDdd(ddd);
                    c.setNome(nome);
                    c.setTelefone(telefone);
                    c.setUf(uf);
                    c.setEndereco(endereco);
                    UsuarioDAO pDB = new UsuarioDAO();
                    Usuario p = new Usuario();
                    pDB.conectar();
                    p.setIdUsuario(idUsuario);
                    p = pDB.carregarPorId(p.getIdUsuario());
                    pDB.desconectar();
                    c.setUsuario(p);
                    EmpresaDAO eDB = new EmpresaDAO();
                    Empresa e = new Empresa();
                    eDB.conectar();
                    e.setCnpj(cnpj);
                    e = eDB.carregarPorCnpj(e.getCnpj());
                    eDB.desconectar();
                    c.setEmpresa(e);
                    
                    ClienteDAO cDB = new ClienteDAO();
                    cDB.conectar();
                    cDB.alterar(c);
                    cDB.desconectar();
                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Cliente alterado com sucesso!');");
                    out.println("location.href='listar_cliente.jsp';");
                    out.println("</script>");
                } catch (Exception e) {
                    out.print(e);
                }




            } else {


                out.println("<script type='text/javascript' language='javascript'>");
                out.println("alert('Todos os campos devem ser preenchidos!');");
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
