package DAO;

import classes.Perfil;
import classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO extends DataBaseDAO {

    public UsuarioDAO() throws Exception {
    }

    public void inserir(Usuario u) throws Exception {

        String sql = "INSERT into usuario (nome,login,senha,Perfil_idPerfil) VALUES(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, u.getNome());
        pst.setString(2, u.getLogin());
        pst.setString(3, u.getSenha());
        pst.setInt(4, u.getPerfil().getIdPerfil());
        pst.execute();

    }

    public ArrayList<Usuario> listar() throws Exception {

        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            Perfil p = new Perfil();
            PerfilDAO pDB = new PerfilDAO();
            pDB.conectar();
            p.setIdPerfil(rs.getInt("Perfil_idPerfil"));
            p = pDB.carregarPorId(p.getIdPerfil());
            pDB.desconectar();
            u.setPerfil(p);
            lista.add(u);
        }
        return lista;
    }

    public void deletar(Usuario u) throws Exception {

        String sql = "DELETE FROM usuario WHERE idusuario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, u.getIdUsuario());
        pst.execute();

    }

    public Usuario carregarPorId(int id) throws Exception {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE idusuario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            u.setIdUsuario(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            PerfilDAO pDB = new PerfilDAO();
            Perfil p = new Perfil();
            pDB.conectar();
            p.setIdPerfil(rs.getInt("Perfil_idPerfil"));
            p = pDB.carregarPorId(p.getIdPerfil());
            pDB.desconectar();
            u.setPerfil(p);
        }
        return u;
    }

    public Usuario logar(String login, String senha) throws Exception {

        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE login = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, login);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (senha.equals(rs.getString("senha"))) {
                u.setIdUsuario(rs.getInt("idusuario"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                PerfilDAO pDB = new PerfilDAO();
                Perfil p = new Perfil();
                pDB.conectar();
                p.setIdPerfil(rs.getInt("Perfil_idPerfil"));
                p = pDB.carregarPorId(p.getIdPerfil());
                pDB.desconectar();
                u.setPerfil(p);
            }
        }
        return u;
    }

    public void alterar(Usuario u) throws Exception {
        String sql = "UPDATE usuario SET nome=?, login =?, senha=?, perfil_idperfil=? WHERE idusuario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, u.getNome());
        pst.setString(2, u.getLogin());
        pst.setString(3, u.getSenha());
        pst.setInt(4, u.getPerfil().getIdPerfil());
        pst.setInt(5, u.getIdUsuario());
        pst.execute();

    }
}
