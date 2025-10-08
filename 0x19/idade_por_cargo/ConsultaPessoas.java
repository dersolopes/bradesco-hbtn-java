import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> todasPessoas) {

        return todasPessoas.stream() // transforma a lista em um fluxo de objetos Pessoa.
                .collect(Collectors.groupingBy(Pessoa::getCargo)); // agrupa todas as pessoas que têm o mesmo valor retornado por getCargo() (ou seja, o nome do cargo).
                // O resultado é um Map<String, List<Pessoa>>:
                //  - chave: nome do cargo (String)
                //  - valor: lista de pessoas com aquele cargo (List<Pessoa>)
    }

    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> todasPessoas) {

        return todasPessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo, // agrupa os elementos pelo cargo
                        Collectors.mapping(Pessoa::getIdade, Collectors.toList()) // transforma cada Pessoa do grupo em sua idade
                ));
        //  O resultado é um Map<String, List<Integer>>:
        //      chave: nome do cargo
        //      valor: lista das idades das pessoas com aquele cargo
    }

}
