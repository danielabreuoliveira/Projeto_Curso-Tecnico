package classes;

public class Empresa {

    private String cnpj;
    private String nomeEmpresa;
    private String endereco;
    private String cidade;
    private String uf;
    private String telefone;
    private int ddd;

    public Empresa(String cnpj, String nomeEmpresa, String endereco, String cidade, String uf, String telefone, int ddd) {
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.ddd = ddd;
    }

    public Empresa() {
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
}
