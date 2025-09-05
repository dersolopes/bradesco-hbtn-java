import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;


    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.00;
    }

    // metodos
    void depositar(double valor) throws OperacaoInvalidaException {
        if (valor >0) {
            this.saldo += valor;
        }
        else
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");

    }
    void sacar(double valor) throws OperacaoInvalidaException {
        if (valor > 0) {
            if (valor <= this.saldo) {
                this.saldo -= valor;
            } else
                throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");

        }else
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
    }

    public double calcularTarifaMensal(){

        double tarifaPadrao = 10.00;
        double tarifa = this.saldo * 0.1;

        //Math.min retorna a menor tarifa
        return Math.min(tarifa, tarifaPadrao);
    }
    public double calcularJurosMensal() {
        if (saldo <= 0) {
            return 0.0;
        }
        else {
        double taxaMensal = taxaJurosAnual / 12 / 100;
        return saldo * taxaMensal;
        }
    }

    public void aplicarAtualizacaoMensal() {
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }


    // getters
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }


}
