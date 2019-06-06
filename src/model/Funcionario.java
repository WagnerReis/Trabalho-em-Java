package model;

public class Funcionario {

    private Long id;
    private String nome;
    private Integer tipo;
    private String cpf;
    private String telefone;
    private String celular;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario(Long id, String nome, Integer tipo, String cpf, String telefone, String celular, String estado, String cidade, String bairro, String rua, Integer numero, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.usuario = usuario;
    }

    public Funcionario() {
    }

    @Override
    public String toString() {
        return id + "-" + nome;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Funcionario) {
            Funcionario a = (Funcionario) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
