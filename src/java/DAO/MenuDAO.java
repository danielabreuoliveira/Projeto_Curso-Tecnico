package DAO;

import classes.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuDAO extends DataBaseDAO {

    public MenuDAO() throws Exception {
    }

    public void deletar(Menu m) throws Exception {
        PreparedStatement pst;
        String sql = "DELETE FROM Menu WHERE idMenu=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, m.getIdMenu());
        pst.execute();
    }

    public ArrayList<Menu> listar() throws Exception {
        ArrayList<Menu> lista = new ArrayList<Menu>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Menu";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdMenu(rs.getInt("idMenu"));
            m.setNome(rs.getString("nome"));
            m.setLink(rs.getString("link"));
            lista.add(m);
        }

        return lista;
    }

    public void inserir(Menu m) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO Menu (nome,link) VALUES(?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, m.getNome());
        pst.setString(2, m.getLink());
        pst.execute();
    }

    public Menu carregarPorId(int idMenu) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Menu WHERE idMenu=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, idMenu);
        rs = pst.executeQuery();
        Menu m = new Menu();
        if (rs.next()) {
            m.setIdMenu(rs.getInt("idMenu"));
            m.setNome(rs.getString("nome"));
            m.setLink(rs.getString("link"));
        }
        return m;
    }

    public void alterar(Menu m) throws Exception {
        PreparedStatement pst;
        String sql = "UPDATE Menu SET nome=?, link=? WHERE idMenu=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, m.getNome());
        pst.setString(2, m.getLink());
        pst.setInt(3, m.getIdMenu());
        pst.execute();
    }
}
