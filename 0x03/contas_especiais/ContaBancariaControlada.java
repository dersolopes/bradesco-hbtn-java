public class ContaBancariaControlada extends ContaBancariaBasica{

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }
    private double saldoMinimo;
    private double valorPenalidade;

    @Override
    public void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal(); // aplica tarifa e juros
        if (getSaldo() < saldoMinimo) {
            // desconta penalidade
            try {
                // usamos saque para gerar validação de saldo
                super.sacar(valorPenalidade);
            } catch (Exception e) {
                // nunca deve lançar exceção aqui porque saldo pode ficar negativo
                // então podemos subtrair diretamente:
                double novoSaldo = getSaldo() - valorPenalidade;

            }
        }
    }
}
//saldoMinimo do tipo double, é o saldo mínimo que conta deve ter para não ser taxada.
//valorPenalidade do tipo double, é o valor de penalidade a aplicar à conta em que o saldo esteja abaixo do saldo