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
                .max((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco())); // encontra o produto com maior preço.

        return produtoMaior.orElse(null); // Retorna o produto encontrado ou null se a lista estiver vazia
    }

    // Retorna os produtos com preço maior ou igual ao preço mínimo
    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream() // cria um fluxo da lista de produtos.
                .filter(p -> p.getPreco() >= precoMinimo) // mantém apenas produtos cujo preço é maior ou igual ao valor passado.
                .collect(Collectors.toList()); // retorna os pedidos filtrados em uma lista.
    }

    // Retorna os pedidos que possuem produtos da categoria ELETRONICO
    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream() // cria um fluxo de pedidos.
                .filter(pedido -> pedido.getProdutos()// mantém apenas os pedidos que possuem pelo menos um produto eletrônico.
                        .stream()
                        .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO)) // verifica se algum produto do pedido é da categoria ELETRONICO
                .collect(Collectors.toList()); // retorna os pedidos filtrados em uma lista.
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream() // 1. Cria um stream da lista de produtos
                .map(produto -> { // 2. Mapeia (transforma) cada produto
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        // 3. Se for ELETRONICO, calcula o novo preço com 15% de desconto
                        double novoPreco = produto.getPreco() * 0.85; // 100% - 15% = 85%

                        // 4. Retorna uma NOVA instância de Produto com o preço atualizado
                        // Assumindo que Produto tem um construtor de cópia ou um metodo para
                        // criar uma nova instância com o preço alterado)

                        // Foi utilizado um construtor que recebe todos os campos
                        // ou um "setter" para simplificar e garantir que um NOVO produto
                        // com o preço ajustado seja retornado.

                        // Criando uma cópia do produto e ajustando o preço
                        Produto produtoComDesconto = new Produto(produto.getCodigo(),
                                produto.getNome(),
                                produto.getCategoria(),
                                novoPreco
                        );

                        // Se for permitido e Produto tiver um 'setter'
                        // produto.setPreco(novoPreco);
                        // return produto; // Retorna a instância modificada (menos recomendado em streams)

                        return produtoComDesconto;
                    }
                    // 5. Se não for ELETRONICO, retorna o produto original sem alteração
                    return produto;
                })
                .collect(Collectors.toList()); // 6. Coleta os novos produtos em uma nova lista
    }
}
