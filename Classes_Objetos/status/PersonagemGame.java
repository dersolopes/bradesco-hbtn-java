public class PersonagemGame {

    private int saudeAtual;
    private String nome;



    private String status;



    //metodos
    public void tomarDano(int quantidadeDeDano){

        if (saudeAtual >= 0 && quantidadeDeDano <= saudeAtual) { // Caso o dano seja inferior a saude, o personagem tomara o dano
            setSaudeAtual(quantidadeDeDano);
        } else if (saudeAtual >= 0 && quantidadeDeDano >= saudeAtual){ // Caso o dano seja superior a saude, a saude ira para zero
            setSaudeAtual(0);
        }
    }

    public void receberCura (int quantidadeDeCura) {

        if ((saudeAtual + quantidadeDeCura) <= 100) {
            setSaudeAtual(quantidadeDeCura);
        } else if ((saudeAtual + quantidadeDeCura) >= 100) {
            setSaudeAtual(100);
        }
    }

    // Getters and Setters
    public int getSaudeAtual() {
        return this.saudeAtual;
    }
    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if (saudeAtual > 0) { setStatus("vivo"); } // Define o status do personagem para vivo
        else { setStatus("morto"); }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
