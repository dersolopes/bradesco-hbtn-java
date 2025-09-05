import java.util.*;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;

    // Construtor
    public GerenciamentoDeContatos() {
        // LinkedHashMap preserva a ordem de inserção
        contatos = new LinkedHashMap<>();
    }

    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        if (contatos.containsKey(nome)) {
            System.out.println("Erro: Contato com nome " + nome + " já existe!");
            return;
        }

        // Verifica se o email já foi usado por outro contato
        for (Contato c : contatos.values()) {
            if (c.getEmails().contains(email)) {
                System.out.println("Erro: Email " + email + " já utilizado!");
                return;
            }
        }

        Contato novoContato = new Contato();
        novoContato.adicionarTelefone(telefone);
        if (novoContato.adicionarEmail(email)) {
            contatos.put(nome, novoContato);
            System.out.println("Contato " + nome + " adicionado com sucesso!");
        } else {
            System.out.println("Erro: Email " + email + " já utilizado!");
        }
    }

    // Exibe todos os contatos na ordem inversa da inserção (novo -> antigo)
    public void exibirContatos() {
        List<Map.Entry<String, Contato>> entries = new ArrayList<>(contatos.entrySet());
        Collections.reverse(entries); // inverte a ordem de inserção
        for (Map.Entry<String, Contato> entry : entries) {
            System.out.println("Nome: " + entry.getKey());
            System.out.println("Telefones: " + entry.getValue().getTelefones());
            System.out.println("Emails: " + entry.getValue().getEmails());
            System.out.println("-------------------------------");
        }
    }

    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + nome);
            System.out.println("Telefones: " + contato.getTelefones());
            System.out.println("Emails: " + contato.getEmails());
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }

    // Remove um contato pelo nome
    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato " + nome + " removido com sucesso!");
        } else {
            System.out.println("Contato " + nome + " não encontrado.");
        }
    }
    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}