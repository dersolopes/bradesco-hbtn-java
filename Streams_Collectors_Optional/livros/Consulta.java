import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    // Metodo estático que retorna todos os produtos do tipo LIVRO de um Pedido
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos() // obtém a lista de produtos do pedido
                .stream()           // cria um stream
                .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO) // filtra apenas LIVRO
                .collect(Collectors.toList()); // coleta em uma lista
    }
}
