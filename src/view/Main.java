package src.view;
import src.locadora.repository.*;
import src.locadora.service.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RepositorioCliente repoCliente = RepositorioFactory.getRepositorioCliente();
        RepositorioFilme repoFilme = RepositorioFactory.getRepositorioFilme();
        RepositorioLocacao repoLocacao = RepositorioFactory.getRepositorioLocacao();

        LocadoraService locadora = new LocadoraService(repoLocacao, repoFilme, repoCliente);
        
        List<String> filmesDisponiveis = Arrays.asList("Harry Potter", "Alice no País das Maravilhas", "Carros");
        locadora.cadastrarFilme(filmesDisponiveis.get(0));
        locadora.cadastrarFilme(filmesDisponiveis.get(1));
        locadora.cadastrarFilme(filmesDisponiveis.get(2));
        locadora.cadastrarCliente("Luciano", "123.456.789-00", "99999-9999");

        System.out.println("\nBem-vindo à Locadora de Filmes!");
        System.out.println("--------------------------------");

        while (true) {
            System.out.println("\n--- Menu de Opções ---");
            System.out.println("1. Alugar Filme");
            System.out.println("2. Devolver Filme");
            System.out.println("3. Sair"); 
            System.out.print("Escolha uma opção (1-3): ");

            String opcaoPrincipal = sc.nextLine();

            if (opcaoPrincipal.equals("3")) {
                System.out.println("\nObrigado por usar a Locadora! Até mais.");
                break;
            }

            if (opcaoPrincipal.equals("1") || opcaoPrincipal.equals("2")) {
                System.out.print("Digite o NOME que deseja usar para o cadastro/registro: ");
                String nomeCliente = sc.nextLine();
                
                if (opcaoPrincipal.equals("1")) {
                    System.out.println("\nFilmes disponíveis para aluguel:");
                    for (int i = 0; i < filmesDisponiveis.size(); i++) {
                        System.out.println((i + 1) + ". " + filmesDisponiveis.get(i));
                    }
                    System.out.print("Digite o NÚMERO do filme que deseja alugar: ");
                    
                    try {
                        int opcaoFilme = Integer.parseInt(sc.nextLine());
                        if (opcaoFilme > 0 && opcaoFilme <= filmesDisponiveis.size()) {
                            String filmeEscolhido = filmesDisponiveis.get(opcaoFilme - 1);
                            LocalDate dataLocacao = LocalDate.now();
                            LocalDate dataDevolucao = dataLocacao.plusDays(5);
                            
                            locadora.alugarFilme(nomeCliente, filmeEscolhido, dataLocacao, dataDevolucao);
                        } else {
                            System.out.println("Opção de filme inválida.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ERRO: Entrada inválida. Digite um número.");
                    }

                } else if (opcaoPrincipal.equals("2")) {
    
                    System.out.print("Digite o TÍTULO do filme a ser devolvido: ");
                    String tituloDevolucao = sc.nextLine();
                    
                    locadora.devolverFilme(nomeCliente, tituloDevolucao);
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}