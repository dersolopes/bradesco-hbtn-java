public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o metodo de buscaBinaria
    public void buscaBinaria(String nome){
        System.out.println("Procurando o nome: \"" + nome + "\"");
        int inicio = 0;
        int fim = nomes.length - 1;
        boolean encontrado = false;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            System.out.println("Passando pelo indice: " + meio);
            int cmp = nomes[meio].compareTo(nome);

            if (cmp == 0) {
                System.out.println("Nome " + nomes[meio] + " encontrado na posição " + meio);
                encontrado = true;
                break;
            } else if (cmp < 0) {
                inicio = meio + 1; // procurar na metade direita
            } else {
                fim = meio - 1; // procurar na metade esquerda
            }
        }

        if (!encontrado) {
            throw new IllegalArgumentException(
                    "O nome " + nome + " não se encontra no array de nomes"
            );
        }

    }
}
