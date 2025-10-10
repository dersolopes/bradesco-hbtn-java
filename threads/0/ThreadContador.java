//Thread responsável por incrementar o contador múltiplas vezes.
public class ThreadContador extends Thread {
    private Contador contador;

    //Construtor que recebe o contador a ser incrementado.
    public ThreadContador(Contador contador) {
        this.contador = contador;
    }

    //Executa a thread, incrementando o contador 1000 vezes.
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}