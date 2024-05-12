package ConhecendoLinguagem.src;

public class EstruturaDeRepeticao {
    public static void main(String[] args){
/*        int numero = 0;
        while (numero <= 10){ *//*Verifica e depois executa o codigo*//*
            System.out.println("O numero atual é: " + numero );
            numero ++;
        }
        *//*-----------------------------------*//*
        int numero2 =0;
        do{ *//* primeiro executa depois verifica *//*
            System.out.println("O numero atual é: " + numero );
            numero2 ++;
        }   while(numero2 <= 10);*/
        /*--------------------------------------------------*/
        for (int numero=0; numero <=10; numero++){
            if (numero == 3 || numero ==6 || numero ==10) {
                System.out.println("Encontrei o numero: " + numero);
                continue;
            }
            System.out.println("Executando o laço de repetição");
        }
    }
}
