package model;

public class ItemCompra {

    private Long id;
    private Integer quantidade;
    private Float valor;
    private Produto produto;
    private Compra compra;

    public ItemCompra() {
    }

    public ItemCompra(Long id, Integer quantidade, Float valor, Produto produto, Compra compra) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return id + "-" + produto.getNome();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemCompra) {
            ItemCompra a = (ItemCompra) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
