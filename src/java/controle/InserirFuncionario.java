/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.EmpresaDAO;
import DAO.FuncionarioDAO;
import DAO.UsuarioDAO;
import classes.Empresa;
import classes.Funcionario;
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
@WebServlet(name = "InserirFuncionario", urlPatterns = {"/inserir_funcionario.do"})
public class InserirFuncionario extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inserir Funcionario</title>");
            out.println("</head>");
            out.println("<body>");
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
            if ((!nome.trim().equals("")) && (!cidade.trim().equals("")) && (!telefone.trim().equals("")) && 
                    (idUsuario!=0)&&(ddd!=0)&&(!endereco.trim().equals(""))&&(!cnpj.trim().equals(""))&&
                    (!uf.trim().equals(""))) {
                try {
                    Funcionario f = new Funcionario();
                    f.setCidade(cidade);
                    f.setDdd(ddd);
                    f.setNome(nome);
                    f.setTelefone(telefone);
                    f.setUf(uf);
                    f.setEndereco(endereco);
                    UsuarioDAO pDB = new UsuarioDAO();
                    Usuario p = new Usuario();
                    pDB.conectar();
                    p.setIdUsuario(idUsuario);
                    p = pDB.carregarPorId(p.getIdUsuario());
                    pDB.desconectar();
                    f.setUsuario(p);
                    EmpresaDAO eDB = new EmpresaDAO();
                    Empresa e = new Empresa();
                    eDB.conectar();
                    e.setCnpj(cnpj);
                    e = eDB.carregarPorCnpj(e.getCnpj());
                    f.setEmpresa(e);
                    eDB.desconectar();
                    FuncionarioDAO fDB = new FuncionarioDAO();
                    fDB.conectar();
                    fDB.inserir(f);
                    fDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Funcionario inserido com sucesso!');");
                    out.println("location.href='listar_funcionario.jsp';");
                    out.println("</script>");

                } catch (Exception e) {
                    out.print(e);
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
