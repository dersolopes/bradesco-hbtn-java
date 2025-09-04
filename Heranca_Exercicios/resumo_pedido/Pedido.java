import produtos.Produto;

public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] items) {
        this.percentualDesconto = percentualDesconto;
        this.itens = items;
    }


    public double calcularTotal(){
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        // aplica desconto
        total -= total * percentualDesconto / 100.0;
        return total;
    }

    public void apresentarResumoPedido() {
        double totalProdutos = 0.0;

        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();

            // Produto já tem um metodo obterPrecoLiquido() que aplica acréscimo:
            double precoUnitario = produto.obterPrecoLiquido();
            double totalItem = precoUnitario * quantidade;
            totalProdutos += totalItem;

            // Tipo: Nome simples da classe ("Livro" ou "Dvd")
            String tipo = produto.getClass().getSimpleName();

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo,
                    produto.getTitulo(),
                    precoUnitario,
                    quantidade,
                    totalItem);
        }

        System.out.println("----------------------------");

        double desconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - desconto;

        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }

        /*

            ------- RESUMO PEDIDO -------
            Tipo: Livro  Titulo: Um de nos esta mentindo  Preco: 40,17  Quant: 1  Total: 40,17
            Tipo: Livro  Titulo: Mindset Milionario  Preco: 36,46  Quant: 2  Total: 72,91
            Tipo: Dvd  Titulo: Anjos da Noite 5 - Guerras de Sangue  Preco: 20,28  Quant: 1  Total: 20,28
            ----------------------------
            DESCONTO: 6,67
            TOTAL PRODUTOS: 133,36
            ----------------------------
            TOTAL PEDIDO: 126,69
            ----------------------------

         */
}
