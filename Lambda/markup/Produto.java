import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    String nome;
    Double preco;
    Double percentualMarkup = 10.0;

    // Supplier que calcula o preço com markup
    public Supplier<Double> precoComMarkup = () -> preco + (preco * (percentualMarkup / 100));

    // Consumer que atualiza o percentual de markup
    public Consumer<Double> atualizarMarkup = novoMarkup -> this.percentualMarkup = novoMarkup;

    // Construtor1
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    // Construtor2
    public Produto(Double preco, String nome) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters para mostrar os dados
    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPercentualMarkup() {
        return percentualMarkup;
    }
}
