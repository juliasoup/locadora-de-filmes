package locadora.service;

import locadora.repository.*;


public class LocadoraFactory {

    public static LocadoraService criarLocadoraService() {
        return new LocadoraService(
            RepositorioFactory.getRepositorioLocacao(),
            RepositorioFactory.getRepositorioFilme(),
            RepositorioFactory.getRepositorioCliente()
        
        
        );
    }
    
}
