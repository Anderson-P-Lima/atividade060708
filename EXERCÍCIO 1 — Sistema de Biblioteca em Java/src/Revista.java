public class Revista extends ItemBiblioteca {
    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {return 7;}

    @Override
    public double getMultaPorDia() {return 1.00;}

    @Override
    public String toString() {
        return String.format("Revista [codigo=%s, titulo=%s, disponivel=%s, prazo=%d, multa=%.2f]",
                getCodigo(), getTitulo(), isDisponivel(), getPrazoEmprestimo(), getMultaPorDia());
    }
}