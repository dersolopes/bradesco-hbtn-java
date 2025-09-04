
import provedores.Frete;

public class Pedido {
    private int codigo;
    private int peso;
    private double total;
    private Frete frete;

    public Pedido(int codigo, int peso, double total) {
        this.codigo = codigo;
        this.peso = peso;
        this.total = total;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

}
