package classes;

public class Cliente {

    private int idCliente;
    private String nome;
    private String endereco;
    private String cidade;
    private String telefone;
    private String uf;
    private int ddd;
    Empresa empresa;
    Usuario usuario;

    public Cliente(int idCliente, String nome, String endereco, String cidade, String telefone, String uf, int ddd, Empresa empresa, Usuario usuario) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.uf = uf;
        this.ddd = ddd;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public Cliente() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }
}
