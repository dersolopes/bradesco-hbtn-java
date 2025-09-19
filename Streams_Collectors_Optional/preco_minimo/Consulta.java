import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Consulta {

    // Metodo estático que retorna todos os produtos do tipo LIVRO de um Pedido
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos() // obtém a lista de produtos do pedido
                .stream()           // cria um stream
                .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO) // filtra apenas LIVRO
                .collect(Collectors.toList()); // coleta em uma lista
    }

    // Metodo estático que retorna o produto com maior preço da lista
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        // Usa Stream API e compara pelo preço
        Optional<Produto> produtoMaior = produtos.stream()
                .max((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));

        // Retorna o produto encontrado ou null se a lista estiver vazia
        return produtoMaior.orElse(null);
    }

    // Retorna os produtos com preço maior ou igual ao preço mínimo
    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

}
