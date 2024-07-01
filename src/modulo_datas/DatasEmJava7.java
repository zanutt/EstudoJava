package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatasEmJava7 {
    public static void main(String[] args) throws ParseException, InterruptedException {
        LocalDate dataBase = LocalDate.parse("2019-10-05");

        System.out.println("Mais 5 Dias : " +  (dataBase = dataBase.plusDays(5)));
        System.out.println("Mais 5 Semanas : " + (dataBase = dataBase.plusWeeks(5)));
        System.out.println("Mais 5 Anos : " + (dataBase = dataBase.plusYears(5)));
        System.out.println("Mais 2 Meses : " + (dataBase = dataBase.plusMonths(2)));

        System.out.println("Menos 1 Ano : " + (dataBase = dataBase.minusYears(1)));

        for (int data = 1; data <= 12; data++){
            dataBase = dataBase.plusMonths(1);
            System.out.println("Data de vencimento do boleto: " + dataBase.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" Do mes: "+ data);
        }

    }
}
