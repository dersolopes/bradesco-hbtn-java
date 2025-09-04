package provedores;

public class Loggi implements ProvedorFrete{
    //Classe Loggi: o valor do frete é 12% do valor total do pedido,
    //se peso passar de 5kg, senão o valor é 4% do valor do pedido.
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.tipoProvedorFrete = TipoProvedorFrete.LOGGI;

        if (peso > 5000) {
            frete.valor = valor * 0.12; }
        else
            frete.valor = valor * 0.04;

        return frete;
    }
}
