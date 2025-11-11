package src.locadora.repository;
import src.locadora.model.Filme;
import java.util.List;
import java.util.ArrayList;

public class RepositorioFilme {

    private static RepositorioFilme instancia = new RepositorioFilme();

    private List<Filme> filmes = new ArrayList<>();

    public static RepositorioFilme getRepositorioFilme() {
        return instancia;
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes); 
    }

    public Filme buscarFilmePorTitulo(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme;
            }
        }
        return null;
    }
}
