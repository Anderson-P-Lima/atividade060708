public class Livro extends ItemBiblioteca {
    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {return 14;}

    @Override
    public double getMultaPorDia() {return 0.50;}

    @Override
    public String toString() {
        return String.format("Livro [codigo=%s, titulo=%s, disponivel=%s, prazo=%d, multa=%.2f]",
                getCodigo(), getTitulo(), isDisponivel(), getPrazoEmprestimo(), getMultaPorDia());
    }
}