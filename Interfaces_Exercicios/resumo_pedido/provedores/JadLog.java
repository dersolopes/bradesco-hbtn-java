package provedores;

public class JadLog implements ProvedorFrete{

    //Classe JadLog: o valor do frete é 7% do valor total do pedido,
    //se peso passar de 2kg, senão o valor é 4,5% do valor do pedido.
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.tipoProvedorFrete = TipoProvedorFrete.JADLOG;

        if (peso > 2000) {
            frete.valor = valor * 0.07; }
        else
            frete.valor = valor * 0.045;

        return frete;
    }
}
