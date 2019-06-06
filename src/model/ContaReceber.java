package model;

import java.util.Date;

public class ContaReceber {

    private Long id;
    private Float valor;
    private Date data;
    private Venda venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ContaReceber(Long id, Float valor, Date data, Venda venda) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.venda = venda;
    }

    public ContaReceber() {
    }

    @Override
    public String toString() {
        return id + "-" + data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContaReceber) {
            ContaReceber a = (ContaReceber) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
