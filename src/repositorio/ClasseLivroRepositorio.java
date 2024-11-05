package repositorio;

import dominio.ClasseLivro;
import fakedb.ClasseLivroFakeDB;

public class ClasseLivroRepositorio extends BaseRepositorio<ClasseLivro>{

    private ClasseLivroFakeDB db;

    public ClasseLivroRepositorio(){
        this.db = new ClasseLivroFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public ClasseLivro Read(int chave) { // Ler
        for (ClasseLivro livro : dados) {
            if (livro.getCodigo() == chave){
                return livro;
            }
        }
        return null;
    }

    @Override
    public ClasseLivro Edit(ClasseLivro instancia) {
        ClasseLivro livro = this.Read(instancia.getCodigo());
        if (livro != null) {
            livro.setTitulo(instancia.getTitulo());
            return livro;
        }else{
            return null;
        }
    }

    @Override
    public ClasseLivro Add(ClasseLivro instancia) {
        ClasseLivro livro = this.dados.getLast(); // Pegando o ultimo Livro da lista
        int proxLivro = livro.getCodigo() + 1; // Adicionando mais um código para inserir um novo Livro
        instancia.setCodigo(proxLivro);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public ClasseLivro Delete(int chave) {
        ClasseLivro livro = this.Read(chave);
        if (livro != null) {
            this.dados.remove(livro);
            return livro;            
        }else{
            return null;
        }
    }    
}