package model;

public class Produto {

    private Long id;
    private String nome;
    private Float valor;
    private String descricao;

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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto(Long id, String nome, Float valor, String descricao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Produto() {
    }

    @Override
    public String toString() {
        return id + "-" + nome;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produto) {
            Produto a = (Produto) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
