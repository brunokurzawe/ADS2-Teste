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

}
