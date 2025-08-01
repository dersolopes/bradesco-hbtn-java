public class Retangulo extends FormaGeometrica {
    protected double largura;
    protected double altura;


    //getters e setters conforme o exercicio pede
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        this.largura = largura;
        if (largura < 0){
            throw new IllegalArgumentException("Largura deve ser maior ou igual a 0");
        }
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
        if (altura <0) {
            throw new IllegalArgumentException("Altura deve ser maior ou igual a 0");
        }
    }

    @Override
    public double area(){
        return altura * largura;
    }

    public String toString(){
        return String.format("[Retangulo] %.2f / %.2f", largura , altura);
    }
}
