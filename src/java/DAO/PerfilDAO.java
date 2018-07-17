package DAO;

import classes.Menu;
import classes.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PerfilDAO extends DataBaseDAO {

    public PerfilDAO() throws Exception {
    }

    public void inserir(Perfil p) throws Exception {

        String sql = "INSERT into perfil (perfil) VALUES(?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, p.getPrefil());
        pst.execute();

    }

    public ArrayList<Perfil> listar() throws Exception {

        ArrayList<Perfil> lista = new ArrayList();
        String sql = "SELECT * FROM perfil";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Perfil p = new Perfil();
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setPrefil(rs.getString("perfil"));
            lista.add(p);
        }
        return lista;
    }

    public ArrayList<Menu> menusVinculados(int idPerfil) throws Exception {

        ArrayList<Menu> lista = new ArrayList();
        String sql = "SELECT * FROM menu as m WHERE m.idMenu IN(SELECT mp.Menu_idMenu FROM Perfil_Menu mp WHERE mp.Perfil_idPerfil=? )";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idPerfil);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdMenu(rs.getInt("m.idMenu"));
            m.setNome(rs.getString("m.nome"));
            m.setLink(rs.getString("m.link"));
            lista.add(m);
        }
        return lista;
    }

    public ArrayList<Menu> menusDesvinculados(int idPerfil) throws Exception {

        ArrayList<Menu> lista = new ArrayList();
        String sql = "SELECT * FROM menu as m WHERE m.idMenu NOT IN(SELECT mp.Menu_idMenu FROM Perfil_Menu mp WHERE mp.Perfil_idPerfil=?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idPerfil);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdMenu(rs.getInt("m.idMenu"));
            m.setNome(rs.getString("m.nome"));
            m.setLink(rs.getString("m.link"));
            lista.add(m);
        }
        return lista;
    }

    public void deletar(Perfil p) throws Exception {

        String sql = "DELETE FROM perfil WHERE idPerfil = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, p.getIdPerfil());
        pst.execute();

    }

    //buscar todos os perfis
    public Perfil carregarPorId(int id) throws Exception {

        Perfil p = new Perfil();
        String sql = "SELECT * FROM perfil WHERE idPerfil = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            p.setIdPerfil(rs.getInt("idPerfil"));
            p.setPrefil(rs.getString("perfil"));
        }
        return p;
    }

    public void alterar(Perfil p) throws Exception {

        String sql = "UPDATE perfil SET perfil=? WHERE idPerfil = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, p.getPrefil());
        pst.setInt(2, p.getIdPerfil());
        pst.execute();

    }

    //Utilizando PreparedStatement
    public void vincularMenus(int idMenu, int idPerfil) throws Exception {

        String sql = "INSERT into Perfil_Menu (Menu_idMenu, Perfil_idPerfil) VALUES(?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idMenu);
        pst.setInt(2, idPerfil);
        pst.execute();

    }
    //Utilizando PreparedStatement

    public void desVincularMenus(int idMenu, int idPerfil) throws Exception {

        String sql = "DELETE FROM Perfil_Menu WHERE Menu_idMenu= ? AND Perfil_idPerfil= ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idMenu);
        pst.setInt(2, idPerfil);
        pst.execute();

    }
}
