package model;

import java.util.Date;

public class Compra {

    private Long id;
    private Date data;
    private Fornecedor fornecedor;
    private ContaPagar contasPagar;
    private ItemCompra itemCompra;
    private Funcionario funcionario;

    public Compra() {
    }

    public Compra(Long id, Date data, Fornecedor fornecedor, ContaPagar contasPagar, ItemCompra itemCompra, Funcionario funcionario) {
        this.id = id;
        this.data = data;
        this.fornecedor = fornecedor;
        this.contasPagar = contasPagar;
        this.itemCompra = itemCompra;
        this.funcionario = funcionario;
    }

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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ContaPagar getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(ContaPagar contasPagar) {
        this.contasPagar = contasPagar;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return id + "-" + data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Compra) {
            Compra a = (Compra) obj;
            return a.getId().equals(this.getId());
        }
        return false;
    }

}
