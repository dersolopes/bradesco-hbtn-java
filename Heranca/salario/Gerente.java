package salario;

public class Gerente extends Empregado{

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }
    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusBase = salarioFixo * 0.20; // 20% para gerentes
            double bonusExtra = (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            return bonusBase + bonusExtra;
        }
        return 0.0;
    }

}
