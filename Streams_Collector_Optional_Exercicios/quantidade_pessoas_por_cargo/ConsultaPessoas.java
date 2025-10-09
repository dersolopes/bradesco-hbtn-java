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

    // Retorna um Map contendo o nome do cargo como chave
    // e a quantidade de pessoas daquele cargo como valor.
    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // Agrupa pessoas pelo cargo.
                        Collectors.counting() // conta quantas há em cada grupo.
                ));
    }

}
