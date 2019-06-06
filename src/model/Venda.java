package model;

import java.util.Date;
import java.util.List;

public class Venda {

    private Long id;
    private Date data;
    private List<ContaReceber> contasReceber;
    private Cliente cliente;
    private Funcionario funcionario;
    private List<ItemVenda> itensVenda;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /*public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }*/
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ContaReceber> getContasReceber() {
        return contasReceber;
    }

    public void setContasReceber(List<ContaReceber> contasReceber) {
        this.contasReceber = contasReceber;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Venda(Long id, Date data, List<ContaReceber> contasReceber, Cliente cliente, Entrega entrega, Funcionario funcionario, List<ItemVenda> itensVenda) {
        this.id = id;
        this.data = data;
        this.contasReceber = contasReceber;
        this.cliente = cliente;
        //this.entrega = entrega;
        this.funcionario = funcionario;
        this.itensVenda = itensVenda;
    }

    public Venda() {
    }

    @Override
    public String toString() {
        return id + "-" + data;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Venda) {
            Venda a = (Venda) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
