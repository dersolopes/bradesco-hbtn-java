import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // Agrupa pessoas pelo cargo.
                        () -> new TreeMap<>(Comparator.reverseOrder()), // TreeMap com ordem reversa das chaves
                        Collectors.toCollection(TreeSet::new)          // Cada grupo é armazenado em TreeSet, garantindo ordenação natural (Comparable) das pessoas.
                ));
    }

}
