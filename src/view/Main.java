package view;

import locadora.model.*;
import locadora.repository.*;
import locadora.service.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criando repositórios e serviço
        RepositorioCliente repoCliente = RepositorioFactory.getRepositorioCliente();
        RepositorioFilme repoFilme = RepositorioFactory.getRepositorioFilme();
        RepositorioLocacao repoLocacao = RepositorioFactory.getRepositorioLocacao();

        LocadoraService locadora = new LocadoraService(repoLocacao, repoFilme, repoCliente);

        // Cadastrando filmes e cliente
        locadora.cadastararFilme("Harry Potter");
        locadora.cadastararFilme("Alice no País das Maravilhas");
        locadora.cadastararFilme("Carros");

        locadora.cadastrarCliente("Luciano", "123.456.789-00", "99999-9999");

        System.out.println("\n🎬 Bem-vindo à Locadora de Filmes!");
        System.out.println("--------------------------------");
        System.out.println("Filmes disponíveis:");
        System.out.println("1. Harry Potter");
        System.out.println("2. Alice no País das Maravilhas");
        System.out.println("3. Carros");

        System.out.print("\nDigite o número do filme que deseja alugar: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // limpar buffer

        String filmeEscolhido = "";

        // Versão compatível com Java 8/11
        switch (opcao) {
            case 1:
                filmeEscolhido = "Harry Potter";
                break;
            case 2:
                filmeEscolhido = "Alice no País das Maravilhas";
                break;
            case 3:
                filmeEscolhido = "Carros";
                break;
            default:
                System.out.println("Opção inválida! Encerrando o programa.");
                sc.close();
                return;
        }

        LocalDate dataLocacao = LocalDate.now();
        LocalDate dataDevolucao = dataLocacao.plusDays(5);

        locadora.alugarFilme("Luciano", filmeEscolhido, dataLocacao, dataDevolucao);

        System.out.println("\n📜 Recibo de locação:");
        System.out.println("Cliente: Luciano");
        System.out.println("Filme alugado: " + filmeEscolhido);
        System.out.println("Data da locação: " + dataLocacao);
        System.out.println("Data de devolução: " + dataDevolucao);
        System.out.println("--------------------------------");
        System.out.println("✅ Locação realizada com sucesso!");

        sc.close();
    }
}
