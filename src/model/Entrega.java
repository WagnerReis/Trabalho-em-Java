package model;

import java.util.Date;

public class Entrega {

    private Long id;
    private Date data;
    private String estado;
    private String cidade;
    private String rua;
    private Integer numero;
    private String bairro;
    private String referencia;
    private Venda venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Entrega(Long id, Date data, String estado, String cidade, String rua, Integer numero, String bairro, String referencia, Venda venda) {
        this.id = id;
        this.data = data;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
        this.venda = venda;
    }

    public Entrega() {
    }

    @Override
    public String toString() {
        return id + "-" + data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entrega) {
            Entrega a = (Entrega) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }
}
