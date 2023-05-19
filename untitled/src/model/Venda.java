package model;

import java.time.LocalDate;

public class Venda {

    private LocalDate dataVenda;
    private Produto produto;
    private Cliente cliente;
    private FormaPagamento formaPagamento;

    public Venda(LocalDate dataVenda, Produto produto, Cliente cliente, FormaPagamento formaPagamento) {
        this.dataVenda = dataVenda;
        this.produto = produto;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", produto=" + produto +
                ", cliente=" + cliente +
                ", formaPagamento=" + formaPagamento +
                '}';
    }
}
