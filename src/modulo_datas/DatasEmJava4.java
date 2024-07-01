package modulo_datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatasEmJava4 {
    public static void main(String[] args) {
        /*nova API a partir do java 8*/
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Data atual: "+ dataAtual);

        LocalTime horaAtual = LocalTime.now();
        System.out.println("Hora Atual: "+ horaAtual);

        LocalDateTime dataAtualHoraAtual = LocalDateTime.now();
        System.out.println("Horario e Data atual: "+ dataAtualHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }
}
