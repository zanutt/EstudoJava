package EstudoEOOP;

public class Matriz {

    public static void main(String[] args) {
        int notas[][]= new int[2][3];

        notas [0][0]= 80;
        notas [0][1]= 90;
        notas [0][2]= 70;

        notas [1][0]= 40;
        notas [1][1]= 60;
        notas [1][2]= 30;


        for (int poslinha = 0; poslinha < notas.length; poslinha++){/*Percorre as linhas*/

            /*Percorre as colunas*/
            for (int poscoluna = 0; poscoluna < notas[poslinha].length; poscoluna++){
                System.out.println("Valor da matriz na linha " + (poslinha +1) + " Coluna "+ (poscoluna+1)+ " é de: "+ notas[poslinha][poscoluna]);
            }

        }

    }

}
