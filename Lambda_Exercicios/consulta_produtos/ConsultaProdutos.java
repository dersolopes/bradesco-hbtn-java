import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    // metodo filtrar que recebe uma lista de produtos e um critério de filtro
    // e retorna uma lista de produtos que atendem ao critério

    static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (criterio.testar(produto)) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }



}
