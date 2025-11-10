package src.locadora.service;

import src.locadora.repository.*;
import src.locadora.model.*;
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

    public void cadastrarFilme(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título do filme não pode ser vazio.");
        }
        repositorioFilme.adicionarFilme(new Filme(titulo));
    }

    public void cadastrarCliente(String nome, String cpf, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        repositorioCliente.adicionarCliente(new Cliente(nome, cpf, telefone));
    }

    public boolean alugarFilme(String nomeCliente, String tituloFilme,
                               LocalDate dataLocacao, LocalDate dataDevolucao) {
        Cliente cliente = repositorioCliente.buscarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado: " + nomeCliente);
            return false;
        }

        Filme filme = repositorioFilme.buscarFilmePorTitulo(tituloFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado: " + tituloFilme);
            return false;
        }

        Locacao locacao = new Locacao(cliente, filme, dataLocacao, dataDevolucao);
        repositorioLocacao.adicionarLocacao(locacao);
        return true;
    }
}
