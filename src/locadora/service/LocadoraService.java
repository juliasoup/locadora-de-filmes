package locadora.service;

import locadora.repository.*;
import locadora.model.*;
import java.time.LocalDate;

public class LocadoraService {

    private RepositorioLocacao repositorioLocacao;
    private RepositorioFilme repositorioFilme;
    private RepositorioCliente repositorioCliente;

    public LocadoraService(RepositorioLocacao repositorioLocacao,
                           RepositorioFilme repositorioFilme,
                           RepositorioCliente repositorioCliente) {
        this.repositorioLocacao = repositorioLocacao;
        this.repositorioFilme = repositorioFilme;
        this.repositorioCliente = repositorioCliente;
    }

    public void cadastararFilme(String titulo) {
        repositorioFilme.adicionarFilme(new Filme(titulo));
    }
    public void cadastrarCliente(String nome, String cpf, String telefone) {
        repositorioCliente.adicionarCliente(new Cliente(nome, cpf, telefone));
    }

    public void alugarFilme(String nomeCliente, String tituloFilme, LocalDate dataLocacao, LocalDate dataDevolucao) {
        Cliente cliente = repositorioCliente.buscarClientePorNome(nomeCliente);
        Filme filme = repositorioFilme.buscarFilmePorTitulo(tituloFilme);
        if (cliente != null && filme != null) {
            Locacao locacao = new Locacao(cliente, filme, dataLocacao, dataDevolucao);
            repositorioLocacao.adicionarLocacao(locacao);
        }
    }
   
    
}
