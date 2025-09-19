import java.util.Locale;

public class Produto {

    String nome;
    double preco;
    double peso;
    int quantidadeEmEstoque;
    TiposProduto tipo;

    public Produto(String nome, double preco, double peso, int quantidadeEmEstoque, TiposProduto tipo) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.tipo = tipo;
    }


    // getters
    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public TiposProduto getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("%s %.6f %.6f %d %s", nome, preco, peso, quantidadeEmEstoque, tipo);
    }
}
