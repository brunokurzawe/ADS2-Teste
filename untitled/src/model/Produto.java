package model;

public class Produto {

    private String nome;
    private Double valorUnitario;

    public Produto(String nome, Double valorUnitario) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
