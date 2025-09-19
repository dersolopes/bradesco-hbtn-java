import java.util.List;

public class Pedido {

    private int codigo;
    private List<Produto> produtos;
    private Cliente cliente;

    // Construtor recebendo código, lista de produtos e cliente
    public Pedido(int codigo, List<Produto> produtos, Cliente cliente) {
        setCodigo(codigo);
        setProdutos(produtos);
        setCliente(cliente);
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + cliente.getNome();
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
