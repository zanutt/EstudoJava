public class Variaveis {

    /* Variavel global acessivel a todos */
    static int idadeGlobal = 35;

    public static void main(String[] args){
        /* Variaveis Local pois estao declaradas dentro do método */
        /* Variaveis inteiras */
        int maiorIdade = 18;
        int idosoIdade= 60;

        /* Variavel em texto */
        String cpf = "452.234.145-54";
    System.out.println("Seu Cpf é "+ cpf + " e a maior idade é "+ maiorIdade);
    /* Chamando o metodo para executar sua função */
    metodo2();
    }

    public static void metodo2(){
        /* Utilizando a variavel Global */
        System.out.println("Variavel Global de idade é "+ idadeGlobal);
    }
}
