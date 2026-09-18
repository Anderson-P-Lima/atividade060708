public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;

    public Biblioteca(int maxItens, int maxUsuarios) {
        acervo = new ItemBiblioteca[maxItens];
        usuarios = new Usuario[maxUsuarios];
    }

    public void cadastrarItem(ItemBiblioteca item) {
        for (int i = 0; i < acervo.length; i++) {
            if (acervo[i] == null) {
                acervo[i] = item;
                System.out.println("Item cadastrado: " + item.getTitulo());
                return;
            }
        }
        System.out.println("Acervo cheio! Não foi possível cadastrar.");
    }

    public void cadastrarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                System.out.println("Usuário cadastrado: " + usuario.getNome());
                return;
            }
        }
        System.out.println("Limite de usuários atingido!");
    }

    public void emprestar(String codigoItem, String nomeUsuario) {
        ItemBiblioteca item = buscarItem(codigoItem);
        if (item == null) {
            System.out.println("Erro: item não encontrado.");
            return;
        }
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario == null) {
            System.out.println("Erro: usuário não encontrado.");
            return;
        }
        if (!item.isDisponivel()) {
            System.out.println("Erro: item '" + item.getTitulo() + "' já está emprestado.");
            return;
        }
        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) {
            System.out.println("Empréstimo recusado: " + usuario.getNome() +
                    " já atingiu o limite de " + usuario.getLimiteItens() + " itens.");
            return;
        }

        item.marcarEmprestado();
        usuario.incrementarEmprestimo();

        System.out.println("Empréstimo realizado: " + usuario.getNome() +
                " pegou '" + item.getTitulo() + "' por " +
                item.getPrazoEmprestimo() + " dias (multa R$ " +
                String.format("%.2f", item.getMultaPorDia()) + "/dia).");
    }

    public void devolver(String codigoItem, String nomeUsuario) {
        ItemBiblioteca item = buscarItem(codigoItem);
        if (item == null) {
            System.out.println("Erro: item não encontrado.");
            return;
        }
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario == null) {
            System.out.println("Erro: usuário não encontrado.");
            return;
        }
        if (item.isDisponivel()) {
            System.out.println("Erro: este item já está disponível.");
            return;
        }

        item.marcarDevolvido();
        usuario.decrementarEmprestimo();

        System.out.println("Devolução realizada: " + usuario.getNome() +
                " devolveu '" + item.getTitulo() + "'.");
    }

    public void listarAcervo() {
        System.out.println("=== Acervo da Biblioteca ===");
        for (ItemBiblioteca item : acervo) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }

    private ItemBiblioteca buscarItem(String codigo) {
        for (ItemBiblioteca item : acervo) {
            if (item != null && item.getCodigo().equals(codigo)) {
                return item;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }
}