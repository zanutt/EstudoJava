public class OperacaoLogica {
    public static void main(String[] args) {
//        int mediaAluno = 70;
//        String nome = "Teste";
//
//        if (mediaAluno >= 70 && nome.equals("Matheus")) {
//            System.out.println("Parabens voce está aprovado");
//        } else if (mediaAluno < 70) {
//            System.out.println("Parabens voce está reprovado");
//        } else{
//            System.out.println("Aluno não encontrado");
//        }
        int nota1 = 90;
        int nota2 = 60;
        int nota3 = 70;
        int nota4 = 80;
        int media = 0;
        media = (nota1 + nota2 + nota3 + nota4) / 4;
        /* Condiçoes Logicas com IF e ELSE*/
        /*if (media >= 70){
            System.out.println("Aluno Aprovado: " +media);
        }else{
            System.out.println("Aluno reprovado"+ media);
        }*/

        /*Operadores ternários são utilizidaos para micro validaçoes*/
        String saidaResultado = media >= 70? "Aluno Aprovado" : (media >= 40 && media <=69)?"Aluno em recuperação" : "Aluno reprovado";
        System.out.println(saidaResultado);
    }
}
