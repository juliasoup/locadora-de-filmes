package src.locadora.repository;

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

    public void removerLocacao(Locacao locacao) {
        locacoes.remove(locacao);
    }

    public List<Locacao> listarLocacoes() {
        return new ArrayList<>(locacoes); 
    }
}
