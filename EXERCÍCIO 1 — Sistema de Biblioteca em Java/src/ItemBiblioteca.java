public abstract class ItemBiblioteca {
    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getCodigo() {return codigo;}
    public String getTitulo() {return titulo;}
    public boolean isDisponivel() {return disponivel;}

    void marcarEmprestado() {this.disponivel = false;}
    void marcarDevolvido() {this.disponivel = true;}

    public abstract int getPrazoEmprestimo();
    public abstract double getMultaPorDia();

    @Override
    public String toString() {
        return String.format("Item [codigo=%s, titulo=%s, disponivel=%s]",
                codigo, titulo, disponivel);
    }
}