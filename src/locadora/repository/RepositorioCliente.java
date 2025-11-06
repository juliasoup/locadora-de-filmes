package locadora.repository;

import locadora.model.Cliente;
import java.util.List;
import java.util.ArrayList;


public class RepositorioCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente bucarPorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null; 
    }
}
