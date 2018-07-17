package classes;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String endereco;
    private String cidade;
    private String telefone;
    private int ddd;
    private String uf;
    private Usuario usuario;
    private Empresa empresa;

    public Funcionario(int idFuncionario, String nome, String endereco, String cidade, String telefone, int ddd, String uf, Usuario usuario, Empresa empresa) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.ddd = ddd;
        this.uf = uf;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
