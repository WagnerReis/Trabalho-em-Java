package model;

import java.util.Date;

public class ContaPagar {

    private Long id;
    private Float valor;
    private Date data;
    private Compra compra;

    public ContaPagar() {
    }

    public ContaPagar(Long id, Float valor, Date data, Compra compra) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.compra = compra;
    }

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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return id + "-" + data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContaPagar) {
            ContaPagar a = (ContaPagar) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
