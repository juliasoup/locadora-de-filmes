package src.locadora.service;
import src.locadora.repository.*;


public class LocadoraFactory {

    public static LocadoraService criarLocadoraService() {
        return new LocadoraService(
            RepositorioLocacao.getRepositorioLocacao(),
            RepositorioFilme.getRepositorioFilme(),
            RepositorioCliente.getRepositorioCliente()
        
        
        );
    }
    
}
