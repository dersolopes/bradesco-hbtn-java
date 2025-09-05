import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) throws LivroInvalidoException, AutorInvalidoException {
        setTitulo(titulo);
        setAutor(autor);
        setPreco(preco);
    }

    // este metodo verifica se o nome possui menos que 2 palavras (1 espaco no minimo)
    // recebe String
    // retorna true or false
    public static boolean validacaoQtdeSpaces(String nome){
        return (nome != null) && (!nome.isEmpty()) && (nome.trim().indexOf(" ") >= 1);
    }

    // este metodo verifica se o titulo do livro possui menos 3 caracteres
    // recebe String
    // retorna true or false
    public static boolean validacaoQtdeCarac(String titulo){
        return (titulo != null) && (titulo.trim().length() >= 3);
    }

    //getters and setters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPreco() { return preco; }

    public void setTitulo(String titulo) throws LivroInvalidoException {
        if (validacaoQtdeCarac(titulo)) {
            this.titulo = titulo;
        }
        else {
            throw new LivroInvalidoException("Titulo de livro invalido");
        }

    }
    public void setAutor(String autor) throws AutorInvalidoException {

        if (validacaoQtdeSpaces(autor)) {
            this.autor = autor;
        }
        else {
            throw new AutorInvalidoException("Nome de autor invalido");
        }
    }
    public void setPreco(double preco) throws LivroInvalidoException {
        if (preco > 0) {
            this.preco = preco;
        }
        else {
            throw new LivroInvalidoException("Preco de livro invalido");
        }
    }
}
