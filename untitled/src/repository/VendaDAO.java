package repository;

import model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    static List<Venda> vendas = new ArrayList<>();

    public static void salvar(Venda venda) {
        vendas.add(venda);
    }

    public static List<Venda> buscaTodos() {
        return vendas;
    }

//    public static List<Venda> buscarPorNome(String nome) {
//        List<Venda> VendasFiltradas = new ArrayList<>();
//        for (Venda pessoa : vendas) {
//            if (pessoa.getNome().contains(nome)) {
//                VendasFiltradas.add(pessoa);
//            }
//        }
//        return VendasFiltradas;
//    }
//
//    public static Object[] findVendasInArray() {
//        List<Venda> Vendas = buscaTodos();
//        List<String> VendaNomes = new ArrayList<>();
//
//        for (Venda Venda : Vendas) {
//            VendaNomes.add(Venda.getNome());
//        }
//
//        return VendaNomes.toArray();
//    }

}
