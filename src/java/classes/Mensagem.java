package classes;

import java.sql.*;
import java.util.ArrayList;

public class Mensagem {

    private int idMensagem;
    private String descricao;
    private String titulo;
    Funcionario funcionario;
    Cliente cliente;

    public Mensagem(int idMensagem, String descricao, String titulo, Funcionario funcionario, Cliente cliente) {
        this.idMensagem = idMensagem;
        this.descricao = descricao;
        this.titulo = titulo;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public Mensagem() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(int idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
