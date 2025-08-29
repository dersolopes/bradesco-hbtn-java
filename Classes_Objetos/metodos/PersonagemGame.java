public class PersonagemGame {

    private int saudeAtual;
    private String nome;



    //metodos
    public void tomarDano(int quantidadeDeDano){

        if (saudeAtual >= 0 && quantidadeDeDano <= saudeAtual) { // Caso o dano seja inferior a saude, o personagem tomara o dano
        this.saudeAtual -= quantidadeDeDano;
        } else if (saudeAtual >= 0 && quantidadeDeDano >= saudeAtual){ // Caso o dano seja superior a saude, a saude ira para zero
            this.saudeAtual = 0;
        }
    }

    public void receberCura (int quantidadeDeCura) {

        if ((saudeAtual + quantidadeDeCura) <= 100) {
            this.saudeAtual += quantidadeDeCura;
        } else if ((saudeAtual + quantidadeDeCura) >= 100) {
            this.saudeAtual = 100;
        }
    }

    // Getters and Setters
    public int getSaudeAtual() {
        return this.saudeAtual;
    }
    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }




}
