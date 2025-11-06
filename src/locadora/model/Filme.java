package locadora.model;
public class Filme {
    private String titulo;
    private boolean disponivel;

    public Filme(String titulo) {
        this.titulo = titulo;
        this.disponivel = true; 
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}