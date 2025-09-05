import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {

    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        super.sacar(0.10); // tarifa de 0,10
        quantidadeTransacoes++;
    }

    @Override
    void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        super.sacar(0.10); // tarifa de 0,10
        quantidadeTransacoes++;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
