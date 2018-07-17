/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.PerfilDAO;
import DAO.UsuarioDAO;
import classes.Perfil;
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
@WebServlet(name = "InserirUsuario", urlPatterns = {"/inserir_usuario.do"})
public class InserirUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inserir Usuario</title>");
            out.println("</head>");
            out.println("<body>");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String idperfil = request.getParameter("idperfil");
            if (!nome.trim().equals("") && (!login.trim().equals("")) && (!senha.trim().equals("")) && (!idperfil.trim().equals(""))) {

                try {
                    Usuario u = new Usuario();
                    u.setNome(nome);
                    u.setLogin(login);
                    u.setSenha(senha);
                    PerfilDAO pDB = new PerfilDAO();
                    Perfil p = new Perfil();
                    pDB.conectar();
                    p.setIdPerfil(Integer.parseInt(idperfil));
                    p = pDB.carregarPorId(p.getIdPerfil());
                    pDB.desconectar();
                    u.setPerfil(p);
                    UsuarioDAO uDB = new UsuarioDAO();
                    uDB.conectar();
                    uDB.inserir(u);
                    uDB.desconectar();

                    out.println("<script type='text/javascript' language='javascript'>");
                    out.println("alert('Usuario inserido com sucesso!');");
                    out.println("location.href='listar_usuario.jsp';");
                    out.println("</script>");

                } catch (Exception e) {
                    out.print(e);
                }
            } else {
                out.println("<script type='text/javascript' language='javascript'>");
                out.println("alert('O campo perfil deve ser informado!');");
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
