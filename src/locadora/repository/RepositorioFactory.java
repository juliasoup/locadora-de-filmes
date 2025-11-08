package locadora.repository;

public class RepositorioFactory {

    private static RepositorioLocacao repositorioLocacao;
    private static RepositorioFilme repositorioFilme;
    private static RepositorioCliente repositorioCliente;

    public static RepositorioLocacao getRepositorioLocacao() {
        if (repositorioLocacao == null) {
            repositorioLocacao = new RepositorioLocacao();
        }
        return repositorioLocacao;
    }   

    public static RepositorioFilme getRepositorioFilme() {
        if (repositorioFilme == null) {
            repositorioFilme = new RepositorioFilme();
        }
        return repositorioFilme;
    }

    public static RepositorioCliente getRepositorioCliente() {
        if (repositorioCliente == null) {
            repositorioCliente = new RepositorioCliente();
        }
        return repositorioCliente;
    }
    
}
