package EstudoEOOP;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

    public static void main(String[] args) {

        String text = "Matheus, Java, 80, 70, 90, 89";

        String[] valoresArray = text.split(",");

        System.out.println("Nome: " + valoresArray[0]+
                "\nCurso: " + valoresArray[1] +
                "\nNota 1: " +valoresArray[2]+
                "\nNota 2: " +valoresArray[3]+
                "\nNota 3: " +valoresArray[4]+
                "\nNota 4: " +valoresArray[5]);

        List<String> list = Arrays.asList(valoresArray);

        for (String valorString : list){
            System.out.println(valorString);
        }

        String[] conversaoArray = list.toArray(new String[6]);

        System.out.println(conversaoArray);

    }

}
