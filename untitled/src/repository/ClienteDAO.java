package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    static List<Cliente> clientes = new ArrayList<>();

    public static void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> buscaTodos() {
        return clientes;
    }

    public static List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientesFiltradas = new ArrayList<>();
        for (Cliente pessoa : clientes) {
            if (pessoa.getNome().contains(nome)) {
                clientesFiltradas.add(pessoa);
            }
        }
        return clientesFiltradas;
    }

    public static Object[] findClientesInArray() {
        List<Cliente> clientes = buscaTodos();
        List<String> clienteNomes = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clienteNomes.add(cliente.getNome());
        }

        return clienteNomes.toArray();
    }

}
