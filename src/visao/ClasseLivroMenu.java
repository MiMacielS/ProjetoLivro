package visao;

import dominio.ClasseLivro;
import java.util.ArrayList;
import servico.ClasseLivroServico;

public class ClasseLivroMenu extends BaseMenu{

    private ClasseLivroServico srv;

    public ClasseLivroMenu(){
        super();
        this.srv = new ClasseLivroServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("Cadastro da Classe Livro");
            System.out.println("1 - Listar Livro(s)");
            System.out.println("2 - Localizar Livro");
            System.out.println("3 - Adicionar Livro");
            System.err.println("4 - Atualizar Livro");
            System.out.println("5 - Remover Livro");
            System.out.println("9 - Sair");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando");
        
        ArrayList<ClasseLivro> lista = this.srv.Navegar();
        for (ClasseLivro livro : lista) {
            this.ImprimirPorLinha(livro);
        }        

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("Localizando");

        System.out.println("Informe o código da Classe de Livro: ");
        int cod = this.scanner.nextInt();

        ClasseLivro livro = this.srv.Ler(cod);
        if (livro != null) {
            this.ImprimirPorLinha(livro);
        }else{
            System.out.println("Problema - Classe de Livro não encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando");

        System.out.println("Informe o Titulo: ");
        String titulo = this.scanner.next();
        System.out.println("Informe o Autor: ");
        String autor = this.scanner.next();
        System.out.println("Informe o isbn: ");
        String isbn = this.scanner.next();
        System.out.println("Informe o anoPublicacao: ");
        int anoPubli = this.scanner.nextInt();
        ClasseLivro livro = new ClasseLivro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setIsbn(isbn);
        livro.setAnoPublicacao(anoPubli);
        if (this.srv.Adicionar(livro) != null) {
            System.out.println("Classe de Livro adicionada com Sucesso");            
        }else{
            System.out.println("Não foi possível adicionar Classe Livro");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando");

        System.out.println("Informe o código da Classe de Livro: ");
        int cod = this.scanner.nextInt();

        ClasseLivro livro = this.srv.Ler(cod);
        if (livro != null) {
            System.out.println("Informe o novo Titulo: ");
            String titulo = this.scanner.next();
            livro.setTitulo(titulo);
            if (this.srv.Editar(livro) != null) {
                System.out.println("Alteração realizada com sucesso");
            }else{
                System.out.println("Não foi possível realizar a Alteração");
            }
        }else{
            System.out.println("Classe de Livro não encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo");

        System.out.println("Informe o código da Classe de Livro: ");
        int cod = this.scanner.nextInt();
        ClasseLivro livro = this.srv.Ler(cod);
        if (livro != null) {
            if (this.srv.Deletar(cod)!= null) {
                System.out.println("Classe de Livro excluída com sucesso");
            }else{
                System.out.println("Não foi possível excluir a Classe de Livro");
            }
        }else{
            System.out.println("Classe de Livro não encontrada");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirPorLinha(ClasseLivro livro){
        String mensagem = "";
        mensagem += "Classe Livro: ";
        mensagem += "Código: " + livro.getCodigo() + " | ";
        mensagem += "Titulo: " + livro.getTitulo() + " | ";
        mensagem += "Autor: " + livro.getAutor() + " | ";
        mensagem += "ISBN: " + livro.getIsbn() + " | ";
        mensagem += "Ano de Publicação: " + livro.getAnoPublicacao() + " | ";
        System.out.println(mensagem);
        System.out.println("----------------------------------------------------");
    }
}
