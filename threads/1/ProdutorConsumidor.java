public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();


        // Criar e iniciar as threads do produtor e consumidor
        Produtor produtor = new Produtor(buffer); //Criando a thread do produtor
        Consumidor consumidor = new Consumidor(buffer); //Criando a thread do consumidor

        produtor.start(); //Iniciando a thread do produtor
        consumidor.start(); //Iniciando a thread do consumidor
    }
}