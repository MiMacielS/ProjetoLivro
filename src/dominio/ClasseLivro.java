package dominio;

public class ClasseLivro {
    private int codigo;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;

    // GETs e SETs dos atributos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // Método Contrutor Vazio
    public ClasseLivro() {

    }

    // Método Construtor Completo
    public ClasseLivro(int codigo, String titulo, String autor, String isbn, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }
}