public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {return nome;}
    public int getQuantidadeEmprestada() {return quantidadeEmprestada;}
    public abstract int getLimiteItens();
    void incrementarEmprestimo() {quantidadeEmprestada++;}

    void decrementarEmprestimo() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }
}