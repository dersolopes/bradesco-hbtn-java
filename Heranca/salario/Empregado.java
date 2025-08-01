package salario;

public class Empregado {

    double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }


    public double calcularBonus(Departamento departamento){
        if (departamento.alcancouMeta()) {
            return salarioFixo * 0.10; // 10% para não-gerentes
        }
        return 0.0;
    }
    public double calcularSalarioTotal(Departamento departamento){
        return salarioFixo + calcularBonus(departamento);
    }
}
