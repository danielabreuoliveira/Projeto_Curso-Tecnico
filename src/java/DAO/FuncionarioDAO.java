package DAO;

import classes.Empresa;
import classes.Funcionario;
import classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO extends DataBaseDAO {

    public FuncionarioDAO() throws Exception {
    }

    public void inserir(Funcionario f) throws Exception {

        String sql = "INSERT into funcionario (nome,endereco,cidade,uf,telefone,ddd,Empresa_cnpj,Usuario_idUsuario) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, f.getNome());
        pst.setString(2, f.getEndereco());
        pst.setString(3, f.getCidade());
        pst.setString(4, f.getUf());
        pst.setString(5, f.getTelefone());
        pst.setInt(6, f.getDdd());
        pst.setString(7, f.getEmpresa().getCnpj());
        pst.setInt(8, f.getUsuario().getIdUsuario());
        pst.execute();

    }

    public ArrayList<Funcionario> listar() throws Exception {

        ArrayList<Funcionario> lista = new ArrayList();
        String sql = "SELECT * FROM funcionario";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setEndereco(rs.getString("endereco"));
            f.setCidade(rs.getString("cidade"));
            f.setDdd(rs.getInt("ddd"));
            f.setNome(rs.getString("nome"));
            f.setUf(rs.getString("uf"));
            f.setTelefone(rs.getString("telefone"));
            Empresa e = new Empresa();
            EmpresaDAO ePB = new EmpresaDAO();
            ePB.conectar();
            e = ePB.carregarPorCnpj(rs.getString("Empresa_cnpj"));
            ePB.desconectar();
            Usuario p = new Usuario();
            UsuarioDAO pPB = new UsuarioDAO();
            pPB.conectar();
            p = pPB.carregarPorId(rs.getInt("Usuario_idUsuario"));
            pPB.desconectar();
            f.setEmpresa(e);
            f.setUsuario(p);
            lista.add(f);
        }
        return lista;
    }

    //buscar todos os perfis
    public Funcionario carregarPorId(int id) throws Exception {

        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setEndereco(rs.getString("endereco"));
            f.setCidade(rs.getString("cidade"));
            f.setDdd(rs.getInt("ddd"));
            f.setNome(rs.getString("nome"));
            f.setUf(rs.getString("uf"));
            f.setTelefone(rs.getString("telefone"));
            Empresa e = new Empresa();
            EmpresaDAO ePB = new EmpresaDAO();
            ePB.conectar();
            e = ePB.carregarPorCnpj(rs.getString("Empresa_cnpj"));
            ePB.desconectar();
            Usuario p = new Usuario();
            UsuarioDAO pPB = new UsuarioDAO();
            pPB.conectar();
            p = pPB.carregarPorId(rs.getInt("Usuario_idUsuario"));
            pPB.desconectar();
            f.setEmpresa(e);
            f.setUsuario(p);
        }
        return f;
    }

    public void alterar(Funcionario f) throws Exception {

        String sql = "UPDATE funcionario SET nome=?,endereco=?,cidade=?,uf=?,telefone=?,ddd=?,Usuario_idUsuario=?,Empresa_cnpj=? WHERE idFuncionario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, f.getNome());
        pst.setString(2, f.getEndereco());
        pst.setString(3, f.getCidade());
        pst.setString(4, f.getUf());
        pst.setString(5, f.getTelefone());
        pst.setInt(6, f.getDdd());
        pst.setInt(7, f.getUsuario().getIdUsuario());
        pst.setString(8, f.getEmpresa().getCnpj());
        pst.setInt(9, f.getIdFuncionario());
        pst.execute();

    }

    public void deletar(Funcionario f) throws Exception {
        String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, f.getIdFuncionario());
        pst.execute();

    }
}
