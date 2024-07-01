package modulo_datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

public class DataEmJava6 {
    public static void main(String[] args) throws ParseException, InterruptedException {
        LocalDate dataAntiga = LocalDate.of(2020,2,7);

        LocalDate dataNova = LocalDate.of(2024,6,22);

        System.out.println("Data antiga é maior que data nova? "+ dataAntiga.isAfter(dataNova));

        Period periodo = Period.between(dataAntiga, dataNova);

        System.out.println("Quantos dias: " +periodo.getDays());
        System.out.println("Quantos meses: " +periodo.getMonths());
        System.out.println("Quantos anos: " +periodo.getYears());
        System.out.println("Periodo de " + periodo.getYears()+ " Anos "+periodo.getMonths()+ " Meses e "+periodo.getDays()+" dias");

    }
}
