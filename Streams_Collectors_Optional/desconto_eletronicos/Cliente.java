public class Cliente {

    private int codigo;
    private String nome;
    private boolean premium;


    /**
     * Construtor da classe Cliente.
     * @param codigo O código do cliente.
     * @param nome O nome do cliente.
     * @param premium Indica se o cliente é premium.
     */
    public Cliente(int codigo, String nome, boolean premium) {
        this.codigo = codigo;
        this.nome = nome;
        this.premium = premium;
    }

    // Métodos getters para os atributos
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Getter para o atributo premium.
     * Utiliza o prefixo 'is' conforme a convenção do JavaBeans para atributos booleanos.
     * @return O status premium do cliente.
     */
    public boolean isPremium() {
        return premium;
    }

    // Métodos setters (opcionais, mas boas práticas)
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Método toString para representação textual do objeto.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", premium=" + premium +
                '}';
    }


}
