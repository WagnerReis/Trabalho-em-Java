package model;

public class ItemVenda {

    private Long id;
    private Integer quantidade;
    private Float valor;
    private Produto produto;
    private Venda venda;

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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItemVenda(Long id, Integer quantidade, Float valor, Produto produto, Venda venda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
        this.venda = venda;
    }

    public ItemVenda() {
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ",, quantidade=" + quantidade + ", valor=" + valor + ", produto=" + produto + ", venda=" + venda + '}';
    }

}
