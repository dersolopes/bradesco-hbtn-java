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

    // Retorna um Map de Cargo contendo outro Map aninhado com
    // Idade e quantidade de pessoas com esta idade
    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // Agrupa pessoas pelo cargo.
                        Collectors.groupingBy(Pessoa::getIdade,Collectors.counting()) //  idade e quantidade de pessoas daquela idade.
                ));
    }

    //Retorna um Map<String, Double> que possua o Cargo e o salário médio daquele cargo.
    public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, // Agrupa pessoas pelo cargo.
                        Collectors.averagingDouble(Pessoa::getSalario) // salário médio daquele cargo.
                ));
    }

    // Retorna um Map contendo o nome do cargo como chave
    // e um TreeSet com todos os hobbies das pessoas daquele cargo.
    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> todasPessoas) {
        return todasPessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.flatMapping(
                                p -> p.getHobbies().stream(), // transforma a lista de hobbies em Stream
                                Collectors.toCollection(TreeSet::new) // Coleta em TreeSet para:
                                                                        // Ordenar os hobbies alfabeticamente
                                                                        // remover duplicatas
                        )
                ));
    }

}
