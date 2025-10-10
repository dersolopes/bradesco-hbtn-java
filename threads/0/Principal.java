public class Principal {

public static void main(String[] args) throws InterruptedException {

    Contador contador = new Contador(); // Cria uma instância do contador

    ThreadContador t1 = new ThreadContador(contador); // Cria a primeira thread, compartilhando o contador
    ThreadContador t2 = new ThreadContador(contador); // Cria a segunda thread, compartilhando o contador

    t1.start(); // Inicia a execução da primeira thread
    t2.start(); // Inicia a execução da segunda thread

    t1.join(); // Aguarda a primeira thread terminar
    t2.join(); // Aguarda a segunda thread terminar

    System.out.println("Valor final do contador: " + contador.getContagem());

    }
}