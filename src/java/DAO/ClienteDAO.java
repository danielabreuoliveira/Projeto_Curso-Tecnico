package DAO;

import classes.Cliente;
import classes.Empresa;
import classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO extends DataBaseDAO {
    
    public ClienteDAO() throws Exception {
    }
    
    public void inserir(Cliente c) throws Exception {
        
        String sql = "INSERT into cliente (nome,endereco,cidade,uf,telefone,ddd,Empresa_cnpj,Usuario_idUsuario) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEndereco());
        pst.setString(3, c.getCidade());
        pst.setString(4, c.getUf());
        pst.setString(5, c.getTelefone());
        pst.setInt(6, c.getDdd());
        pst.setString(7, c.getEmpresa().getCnpj());
        pst.setInt(8, c.getUsuario().getIdUsuario());
        pst.execute();
        
    }
    
    public ArrayList<Cliente> listar() throws Exception {
        
        ArrayList<Cliente> lista = new ArrayList();
        String sql = "SELECT * FROM cliente";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setEndereco(rs.getString("endereco"));
            c.setCidade(rs.getString("cidade"));
            c.setDdd(rs.getInt("ddd"));
            c.setNome(rs.getString("nome"));
            c.setUf(rs.getString("uf"));
            c.setTelefone(rs.getString("telefone"));
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
            c.setEmpresa(e);
            c.setUsuario(p);
            lista.add(c);
        }
        return lista;
    }

    //buscar todos os perfis
    public Cliente carregarPorId(int id) throws Exception {
        
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            c.setIdCliente(rs.getInt("idCliente"));
            c.setEndereco(rs.getString("endereco"));
            c.setCidade(rs.getString("cidade"));
            c.setDdd(rs.getInt("ddd"));
            c.setNome(rs.getString("nome"));
            c.setUf(rs.getString("uf"));
            c.setTelefone(rs.getString("telefone"));
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
            c.setEmpresa(e);
            c.setUsuario(p);
        }
        return c;
    }
    
    public void alterar(Cliente c) throws Exception {
        
        String sql = "UPDATE cliente SET nome=?,endereco=?,cidade=?,uf=?,telefone=?,ddd=?,Usuario_idUsuario=?,Empresa_cnpj=? WHERE idCliente = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEndereco());
        pst.setString(3, c.getCidade());
        pst.setString(4, c.getUf());
        pst.setString(5, c.getTelefone());
        pst.setInt(6, c.getDdd());
        pst.setInt(7, c.getUsuario().getIdUsuario());
        pst.setString(8, c.getEmpresa().getCnpj());
        pst.setInt(9, c.getIdCliente());
        pst.execute();
        
    }
    
    public void deletar(Cliente c) throws Exception {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, c.getIdCliente());
        pst.execute();
        
    }
}
