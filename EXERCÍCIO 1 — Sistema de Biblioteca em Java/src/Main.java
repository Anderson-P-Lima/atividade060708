public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10, 10);

        biblioteca.cadastrarItem(new Livro("L1", "Java Como Programar"));
        biblioteca.cadastrarItem(new Livro("L2", "Estruturas de Dados"));
        biblioteca.cadastrarItem(new Revista("R1", "Ciência Hoje"));
        biblioteca.cadastrarItem(new Revista("R2", "Superinteressante"));

        Aluno aluno = new Aluno("João");
        biblioteca.cadastrarUsuario(aluno);

        System.out.println("\n--- Acervo inicial ---");
        biblioteca.listarAcervo();

        System.out.println("\n--- Empréstimos bem-sucedidos (limite do aluno = 3) ---");
        biblioteca.emprestar("L1", "João");
        biblioteca.emprestar("R1", "João");
        biblioteca.emprestar("L2", "João");

        System.out.println("\n--- Tentativa de empréstimo recusado por limite ---");
        biblioteca.emprestar("R2", "João");

        System.out.println("\n--- Acervo final ---");
        biblioteca.listarAcervo();j
    }
}