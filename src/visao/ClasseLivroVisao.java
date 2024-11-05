package visao;

import dominio.ClasseLivro;
import java.util.ArrayList;
import servico.ClasseLivroServico;

public class ClasseLivroVisao {

    private ClasseLivroServico srv;

    public ClasseLivroVisao() {
        this.srv = new ClasseLivroServico();
    }

    /*public void Criar(){
        ClasseLivro livro = new ClasseLivro();
        livro.setCodigo(0);
        livro.setTitulo("Teste");
        livro.setAutor("Teste Autor");
        livro.setIsbn("Teste ISBN");
        livro.setAnoPublicacao(2000);
        this.srv.Adicionar(livro);
    }*/

    public void Exibir() {
        ArrayList<ClasseLivro> lista = this.srv.Navegar();
        System.out.println("=======================================================================");
        for (ClasseLivro livro : lista) {
            this.Imprimir(livro);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<ClasseLivro> lista = this.srv.Navegar();
        System.out.println("=======================================================================");
        for (ClasseLivro livro : lista) {
            this.ImprimirPorLinha(livro);
        }
    }

    /*public void ExibirApenasUm(int chave){
        ClasseLivro livro = this.srv.Ler(chave);
        System.out.println("=======================================================================");
        this.ImprimirPorLinha(livro);
    }*/

    public void Imprimir(ClasseLivro livro){
            System.out.println("Classe Livro:");
            System.out.println("Código: " + livro.getCodigo());
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("ISBN: " + livro.getIsbn());
            System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
            System.out.println("----------------------------------------------------");
    }

    public void ImprimirPorLinha(ClasseLivro livro){

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

    public void Criar(ClasseLivro novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, ClasseLivro alt){
        ClasseLivro livro = this.srv.Ler(chave);
        if (livro != null) {
            livro.setTitulo(alt.getTitulo());            
        }else{
            System.out.println("Livro não encontrado");
        }
    }

    public void Remover(int chave){
        ClasseLivro livro = this.srv.Ler(chave);
        if (livro != null) {
            this.srv.Deletar(chave);
        }else{
            System.out.println("Livro não encontrado");
        }
    }
}