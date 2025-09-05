import java.util.ArrayList;

public class GestaoAlunos {

    ArrayList<Aluno> alunos = new ArrayList<>();


    public void adicionarAluno(String nome , int idade){
        Aluno aluno = new Aluno(nome,idade);
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + nome);

    }
    public void excluirAluno(String nome) {
        Aluno alunoParaRemover = null;
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                alunoParaRemover = a;
                break;
            }
        }
        if (alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + a);
                return;
            }
        }
        System.out.println("Aluno não encontrado");
    }
    public void listarAlunos() {
        System.out.println("Lista de alunos:");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }


//    O metodo adicionarAluno() cria um novo objeto Aluno e o adiciona à lista.
//    O metodo excluirAluno() remove um aluno da lista, caso seu nome seja encontrado.
//    O metodo buscarAluno() exibe as informações do aluno caso seu nome seja encontrado.
//    O metodo listarAlunos() imprime todos os alunos cadastrados.

}
