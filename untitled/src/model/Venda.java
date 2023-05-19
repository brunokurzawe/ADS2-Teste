package model;

import java.time.LocalDate;

public class Venda {

    private LocalDate dataVenda;
    private Produto produto;
    private Cliente cliente;

    public Venda(Produto produto, Cliente cliente, LocalDate dataVenda) {
        this.produto = produto;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
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

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", produto=" + produto +
                ", cliente=" + cliente +
                '}';
    }
}
