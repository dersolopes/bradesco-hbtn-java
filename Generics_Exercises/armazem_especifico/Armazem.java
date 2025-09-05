import java.util.*;

public abstract class Armazem<T> implements Armazenavel<T> {
    protected Map<String, T> inventario;

    public Armazem() {
        inventario = new HashMap<>();
    }

    @Override
    public void adicionarAoInventario(String nome, T item) {
        inventario.put(nome, item);
    }

    @Override
    public T obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}
