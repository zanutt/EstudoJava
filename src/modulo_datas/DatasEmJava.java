package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasEmJava {

    public static void main(String[] args) throws ParseException {

       Calendar calendar = Calendar.getInstance();

       calendar.setTime(new SimpleDateFormat("dd-MM-yyy").parse("10-03-2024"));

       calendar.add(Calendar.DAY_OF_MONTH, 5);

        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));


    }

}
