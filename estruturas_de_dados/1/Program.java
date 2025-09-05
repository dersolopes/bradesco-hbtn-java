public class Program {

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        gestao.adicionarAluno("Maria", 20);
        gestao.adicionarAluno("João", 22);
        gestao.adicionarAluno("Ana", 19);

        gestao.listarAlunos();

        gestao.buscarAluno("João");

        gestao.excluirAluno("Carlos"); // não existe
        gestao.excluirAluno("Maria");

        gestao.listarAlunos();
    }

}
