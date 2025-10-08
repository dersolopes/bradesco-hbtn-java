import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {

    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    // Construtor padrão > sobrecarregado com this(...) > this (...) deve ser a primeira linha do construtor
    public Pessoa() {
        this(0, "Desconhecido", "Sem cargo", 0, 0.0);
    }

    // Construtor com código e nome
    public Pessoa(int codigo, String nome) {
        this(codigo, nome, "Sem cargo", 0, 0.0);
    }

    // Construtor com código, nome e cargo
    public Pessoa(int codigo, String nome, String cargo) {
        this(codigo, nome, cargo, 0, 0.0);
    }

    // Construtor com código, nome, cargo e idade
    public Pessoa(int codigo, String nome, String cargo, int idade) {
        this(codigo, nome, cargo, idade, 0.0);
    }

    // Construtor completo
    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    // Sobrescrevendo toString
    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pt-BR"),"[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario);
    }

    // Implementa do Comparable, permitindo armazenar objetos em TreeSet (ordenados pelo codigo).
    @Override
    public int compareTo(Pessoa pessoa) {
        return Integer.compare(this.codigo, pessoa.codigo);
    }

}