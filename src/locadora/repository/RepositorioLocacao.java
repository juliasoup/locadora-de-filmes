package src.locadora.repository;

import src.locadora.model.Cliente;
import src.locadora.model.Filme;
import src.locadora.model.Locacao;
import java.util.List;
import java.util.ArrayList;

public class RepositorioLocacao {
    private static RepositorioLocacao instancia = new RepositorioLocacao();
    private List<Locacao> locacoes = new ArrayList<>();

    public static RepositorioLocacao getRepositorioLocacao() {
        return instancia;
    }

    public void adicionarLocacao(Locacao locacao) {
        locacoes.add(locacao);
    }

    public boolean removerLocacao(Cliente cliente, Filme filme) {
        for (int i = 0; i < locacoes.size(); i++) {
            Locacao locacao = locacoes.get(i);
            if (locacao.getCliente().equals(cliente) && locacao.getFilme().equals(filme)) {
                locacoes.remove(i);
                return true; 
            }
        }
        return false; 
    }

    public List<Locacao> listarLocacoes() {
        return new ArrayList<>(locacoes); 
    }
}
