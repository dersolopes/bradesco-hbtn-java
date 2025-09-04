package provedores;

public class Sedex implements ProvedorFrete{

    // Classe Sedex: o valor do frete é 10% do valor total do pedido,
    // se peso passar de 1kg, senão o valor é 5% do valor do pedido.
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.tipoProvedorFrete = TipoProvedorFrete.SEDEX;

        if (peso > 1000) {
            frete.valor = valor * 0.10; }
        else
            frete.valor = valor * 0.05;

        frete.setTipoProvedorFrete(obterTipoProvedorFrete());

        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}
