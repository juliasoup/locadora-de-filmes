package src.locadora.repository;

import src.locadora.model.Cliente;
import java.util.List;
import java.util.ArrayList;

public class RepositorioCliente {
    private static RepositorioCliente instancia = new RepositorioCliente();
    private List<Cliente> clientes = new ArrayList<>();

    public static RepositorioCliente getRepositorioCliente() {
        return instancia;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes); 
    }
}