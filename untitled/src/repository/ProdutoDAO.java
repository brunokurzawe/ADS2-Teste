package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    static List<Produto> produtos = new ArrayList<>();

    public static void salvar(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> buscaTodos() {
        return produtos;
    }

    public static List<Produto> buscarPorNome(String nome) {
        List<Produto> produtosFiltradas = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().contains(nome)) {
                produtosFiltradas.add(produto);
            }
        }
        return produtosFiltradas;
    }

    public static Object[] findprodutosInArray() {
        List<Produto> produtos = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (Produto produto : produtos) {
            clienteNomes.add(produto.getNome());
        }

        return clienteNomes.toArray();
    }

}
