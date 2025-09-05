import java.util.*;

public class Blog {
    private List<Post> postagens = new ArrayList<>();


    /*   Modifique o metodo adicionarPostagem: deve verificar se postagem já foi adicionada,
         essa comparação deve ser feita da seguinte forma: mesmo autor com mesmo título,
         se já houver, deve lançar uma exceção com mensagem */
    public void adicionarPostagem(Post post) throws Exception {
        if (postagens.contains(post)) {
            throw new Exception("Postagem jah existente");
        }
        postagens.add(post);
    }

    // Modifique o mEtodo obterTodosAutores: deve retornar Set do tipo Autor
    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    //Modifique o metodo obterContagemPorCategoria: deve retornar Map, porém a chave deve ser um enum Categorias ao invés de String,
    // não é mais necessário retornar em ordem pelo nome da categoria
    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post post : postagens) {
            contagem.put(post.getCategoria(), contagem.getOrDefault(post.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    //Acrescente o metodo obterPostsPorAutor:
    // recebe um autor como parâmetro e retorna um Set de posts daquele autor,
    // deve-se retornar os posts ordenados pelo título
    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getAutor().equals(autor)) {
                posts.add(post);
            }
        }
        return posts;
    }

    // Acrescente o metodo obterPostsPorCategoria:
    // recebe uma categoria como parâmetro e retorna um Set de posts daquela categoria,
    // deve-se retornar os posts ordenados pelo título
    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post post : postagens) {
            if (post.getCategoria() == categoria) {
                posts.add(post);
            }
        }
        return posts;
    }

    // Acrescente o metodo obterTodosPostsPorCategorias:
    // retorne uma Map que a chave seja Categorias e o valor seja um Set com todos posts daquela categoria
    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Post post : postagens) {
            if (!map.containsKey(post.getCategoria())) {
                map.put(post.getCategoria(), new TreeSet<>());
            }
            map.get(post.getCategoria()).add(post);
        }
        return map;
    }

    //Acrescente o metodo obterTodosPostsPorAutor:
    // retorne uma Map que a chave seja Autor e o valor seja um Set com todos posts daquela categoria
    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new HashMap<>();
        for (Post post : postagens) {
            if (!map.containsKey(post.getAutor())) {
                map.put(post.getAutor(), new TreeSet<>());
            }
            map.get(post.getAutor()).add(post);
        }
        return map;
    }
}
