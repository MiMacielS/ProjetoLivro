package fakedb;

import dominio.ClasseLivro;
import java.util.ArrayList;

public class ClasseLivroFakeDB extends BaseFakeDB<ClasseLivro> {

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new ClasseLivro(1, "A Bela e a Fera", "Gabrielle-Suzanne",
        "123456", 1740));
        this.tabela.add(new ClasseLivro(2, "Cinderela", "Charles Perrault",
        "212121", 1697));
        this.tabela.add(new ClasseLivro(3, "A Pequena Sereia", "Hans Christian Andersen",
        "454545", 1837));
        this.tabela.add(new ClasseLivro(4, "Branca de Neve", "Irmãos Grimm",
        "999999", 1812));
        this.tabela.add(new ClasseLivro(5, "A Princesa e o Sapo", "E.D. Baker",
        "878787", 2002));
        this.tabela.add(new ClasseLivro(6, "Rapunzel", "Irmãos Grimm",
        "555555", 1812));
    }
    
    public ClasseLivroFakeDB(){
        super();
    }
}
