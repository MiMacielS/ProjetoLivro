package servico;

import dominio.ClasseLivro;
import java.util.ArrayList;
import repositorio.ClasseLivroRepositorio;

public class ClasseLivroServico extends BaseServico<ClasseLivro> {

    private ClasseLivroRepositorio repo;

    public ClasseLivroServico(){
        this.repo = new ClasseLivroRepositorio();
    }

    @Override
    public ArrayList<ClasseLivro> Navegar() {
        return this.repo.Browse();
    }

    @Override
    public ClasseLivro Ler(int chave) {
        return this.repo.Read(chave);
    }

    @Override
    public ClasseLivro Editar(ClasseLivro obj) {
        return this.repo.Edit(obj);
    }

    @Override
    public ClasseLivro Adicionar(ClasseLivro obj) {
        return this.repo.Add(obj);
    }

    @Override
    public ClasseLivro Deletar(int chave) {
        return this.repo.Delete(chave);
    }
}