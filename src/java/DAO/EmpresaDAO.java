package DAO;

import classes.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO extends DataBaseDAO {

    public EmpresaDAO() throws Exception {
    }

    public void deletar(Empresa empresa) throws Exception {
        PreparedStatement pst;
        String sql = "DELETE FROM Empresa WHERE cnpj=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, empresa.getCnpj());
        pst.execute();
    }

    public ArrayList<Empresa> listar() throws Exception {
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Empresa";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            Empresa e = new Empresa();
            e.setCnpj(rs.getString("cnpj"));
            e.setNomeEmpresa(rs.getString("nomeEmpresa"));
            e.setEndereco(rs.getString("endereco"));
            e.setTelefone(rs.getString("telefone"));
            e.setDdd(rs.getInt("ddd"));
            e.setCidade(rs.getString("cidade"));
            e.setUf(rs.getString("uf"));
            lista.add(e);
        }

        return lista;
    }

    public void inserir(Empresa e) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO Empresa (cnpj,nomeEmpresa,endereco,cidade,uf,telefone,ddd) VALUES(?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, e.getCnpj());
        pst.setString(2, e.getNomeEmpresa());
        pst.setString(3, e.getEndereco());
        pst.setString(4, e.getCidade());
        pst.setString(5, e.getUf());
        pst.setString(6, e.getTelefone());
        pst.setInt(7, e.getDdd());
        pst.execute();
    }

    public Empresa carregarPorCnpj(String cnpj) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Empresa WHERE cnpj=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, cnpj);
        rs = pst.executeQuery();
        Empresa e = new Empresa();
        if (rs.next()) {
            e.setCnpj(rs.getString("cnpj"));
            e.setNomeEmpresa(rs.getString("nomeEmpresa"));
            e.setEndereco(rs.getString("endereco"));
            e.setCidade(rs.getString("cidade"));
            e.setTelefone(rs.getString("telefone"));
            e.setUf(rs.getString("uf"));
            e.setDdd(rs.getInt("ddd"));
        }
        return e;
    }

    public void alterar(Empresa e) throws Exception {
        PreparedStatement pst;
        String sql = "UPDATE Empresa SET nomeEmpresa=?, endereco=?, cidade=?,"
                + "uf=?,telefone=?,ddd=? WHERE cnpj=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, e.getNomeEmpresa());
        pst.setString(2, e.getEndereco());
        pst.setString(3, e.getCidade());
        pst.setString(4, e.getUf());
        pst.setString(5, e.getTelefone());
        pst.setInt(6, e.getDdd());
        pst.setString(7, e.getCnpj());
        pst.execute();
    }
}
