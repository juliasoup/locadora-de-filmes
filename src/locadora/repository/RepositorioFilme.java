package locadora.repository;

import locadora.model.Filme;
import java.util.List;
import java.util.ArrayList;

public class RepositorioFilme {
    private List<Filme> filmes = new ArrayList<>();

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }


}