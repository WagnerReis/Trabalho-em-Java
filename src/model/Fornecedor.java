package model;

public class Fornecedor {

    private Long id;
    private String telefone;
    private String celular;
    private String razaoSocial;
    private String cnpj;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String telefone, String celular, String razaoSocial, String cnpj, String estado, String cidade, String bairro, String rua, Integer numero) {
        this.id = id;
        this.telefone = telefone;
        this.celular = celular;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return id + "-" + razaoSocial;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fornecedor) {
            Fornecedor a = (Fornecedor) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
