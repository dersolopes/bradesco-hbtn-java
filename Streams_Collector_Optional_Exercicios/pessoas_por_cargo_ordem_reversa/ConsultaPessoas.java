import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // Agrupa pessoas pelo cargo.
                        () -> new TreeMap<>(Comparator.reverseOrder()), // ordem reversa dos cargos
                        Collectors.toCollection(TreeSet::new) //// Cada grupo é armazenado em TreeSet, 'pessoas' ordenadas pelo compareTo
                ));
    }

}
