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

    // Retorna todos os autores do blog ordenados pelo nome e sobrenome
    public Set<Autor> obterTodosAutores() {
        // TreeSet ordena automaticamente pelo Comparable implementado na classe Autor
        Set<Autor> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    //Modifique o metodo obterContagemPorCategoria: deve retornar Map, porém a chave deve ser um enum Categorias ao invés de String,
    // não é mais necessário retornar em ordem pelo nome da categoria
    public Map<Categorias, Integer> obterContagemPorCategoria() {
        // USAR LinkedHashMap para manter a ordem de inserção das categorias
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        contagem.put(Categorias.DEVOPS, 0);
        contagem.put(Categorias.DESENVOLVIMENTO, 0);
        contagem.put(Categorias.DATA_SCIENCE, 0);

        for (Post post : postagens) {
            // Incrementa a contagem de cada categoria
            contagem.put(post.getCategoria(), contagem.get(post.getCategoria()) + 1);
        }
        // obs: Substituí HashMap por LinkedHashMap e inicializei as categorias na ordem desejada para que a saída seja consistente
        // e bata com o teste automático. Assim, DEVOPS sempre vem antes de DESENVOLVIMENTO e DATA_SCIENCE.
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
        Map<Categorias, Set<Post>> map = new LinkedHashMap<>(); // mantém a ordem de inserção DEVOPS → DESENVOLVIMENTO → DATA_SCIENCE:
        map.put(Categorias.DEVOPS, new TreeSet<>());
        map.put(Categorias.DESENVOLVIMENTO, new TreeSet<>());
        map.put(Categorias.DATA_SCIENCE, new TreeSet<>());

        for (Post post : postagens) {
            map.get(post.getCategoria()).add(post);
        }

        return map;
    }

    // Acrescente o metodo obterTodosPostsPorAutor:
    // Retorne um Map que a chave seja Autor e o valor seja um Set com todos posts daquele autor
    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        // USAR TreeMap para que os autores fiquem ordenados pelo Comparable implementado na classe Autor
        Map<Autor, Set<Post>> map = new TreeMap<>();

        for (Post post : postagens) {
            // Se o autor ainda não estiver no mapa, cria um TreeSet vazio
            if (!map.containsKey(post.getAutor())) {
                map.put(post.getAutor(), new TreeSet<>());
            }
            // Adiciona o post no Set do autor (TreeSet garante que os posts fiquem ordenados pelo título)
            map.get(post.getAutor()).add(post);
        }

        // Obs: Substituí HashMap por TreeMap para que os autores fiquem ordenados automaticamente pelo Comparable implementado na classe Autor,
        // garantindo que a saída bata com o esperado: Jane Doe, John Bannons, Peter Dirkly.

        return map;
    }


//    List<Post>
//      → adiciona
//    Set<Post>
//      → remove duplicidade e ordena
//    Map<Autor, Set<Post>> e Map<Categorias, Set<Post>>
//      → agrupamento

}
