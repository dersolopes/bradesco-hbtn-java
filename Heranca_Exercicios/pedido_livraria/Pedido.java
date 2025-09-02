public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] items;

    public Pedido(double percentualDesconto, ItemPedido[] items) {
        this.percentualDesconto = percentualDesconto;
        this.items = items;
    }


    public double calcularTotal(){
        double total = 0.0;
        for (ItemPedido item : items) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        // aplica desconto
        total -= total * percentualDesconto / 100.0;
        return total;
    }
}
