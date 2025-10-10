/**
 * Classe responsável por manter um contador inteiro.
 * Oferece métodos sincronizados para incrementar e obter o valor do contador.
 */
public class Contador {
    private int count = 0;

    // Metodo sincronizado para garantir que o contador seja atualizado de maneira segura
    public synchronized void incrementar() {
        count++;
    }

    // Metodo para obter o valor atual do contador
    public int getContagem() {
        return count;
    }
}