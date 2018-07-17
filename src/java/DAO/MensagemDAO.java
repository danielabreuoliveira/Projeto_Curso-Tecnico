package DAO;

import classes.Cliente;
import classes.Funcionario;
import classes.Mensagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MensagemDAO extends DataBaseDAO {

    public MensagemDAO() throws Exception {
    }

    public void inserir(Mensagem m) throws Exception {
        String sql = "INSERT into mensagem (descricao,titulo,Funcionario_idFuncionario,Cliente_idCliente)"
                + " VALUES(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, m.getDescricao());
        pst.setString(2, m.getTitulo());
        pst.setInt(3, m.getFuncionario().getIdFuncionario());
        pst.setInt(4, m.getCliente().getIdCliente());
        pst.execute();

    }

    public ArrayList<Mensagem> listar() throws Exception {
        ArrayList<Mensagem> lista = new ArrayList<Mensagem>();
        String sql = "SELECT * FROM mensagem";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Mensagem m = new Mensagem();
            m.setIdMensagem(rs.getInt("idMensagem"));
            m.setDescricao(rs.getString("descricao"));
            m.setTitulo(rs.getString("titulo"));
            Funcionario f = new Funcionario();
            FuncionarioDAO fDB = new FuncionarioDAO();
            fDB.conectar();
            f.setIdFuncionario(rs.getInt("Funcionario_idFuncionario"));
            f = fDB.carregarPorId(f.getIdFuncionario());
            fDB.desconectar();
            m.setFuncionario(f);
            Cliente c = new Cliente();
            ClienteDAO cDB = new ClienteDAO();
            cDB.conectar();
            c.setIdCliente(rs.getInt("Cliente_idCliente"));
            c = cDB.carregarPorId(c.getIdCliente());
            cDB.desconectar();
            m.setCliente(c);
            lista.add(m);
        }
        return lista;
    }

    public void deletar(Mensagem m) throws Exception {

        String sql = "DELETE FROM mensagem WHERE idMensagem = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, m.getIdMensagem());
        pst.execute();

    }

    public Mensagem carregarPorId(int id) throws Exception {

        Mensagem m = new Mensagem();
        String sql = "SELECT * FROM mensagem WHERE idmensagem = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            m.setIdMensagem(rs.getInt("idMensagem"));
            m.setDescricao(rs.getString("descricao"));
            m.setTitulo(rs.getString("titulo"));
            Funcionario f = new Funcionario();
            FuncionarioDAO fDB = new FuncionarioDAO();
            fDB.conectar();
            f.setIdFuncionario(rs.getInt("Funcionario_idFuncionario"));
            f = fDB.carregarPorId(f.getIdFuncionario());
            fDB.desconectar();
            m.setFuncionario(f);
            Cliente c = new Cliente();
            ClienteDAO cDB = new ClienteDAO();
            cDB.conectar();
            c.setIdCliente(rs.getInt("Cliente_idCliente"));
            c = cDB.carregarPorId(c.getIdCliente());
            cDB.desconectar();
            m.setCliente(c);
        }
        return m;
    }
}
