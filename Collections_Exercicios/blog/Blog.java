import java.util.*;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    // Adiciona um post à lista
    public void adicionarPostagem(Post post) {
        postagens.add(post);
    }

    // Retorna um Set com todos os autores ordenados usando o TreeSet
    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    // Retorna um Map com a contagem de posts por categoria
    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post post : postagens) {
            String categoria = post.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }
}
