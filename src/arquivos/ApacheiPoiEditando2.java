package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ApacheiPoiEditando2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\arquivo_excel.xls");

        FileInputStream entrada = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()){
            Row linha = linhaIterator.next();

            int numCells = linha.getPhysicalNumberOfCells();

            String valorCelula = linha.getCell(0).getStringCellValue();
            linha.getCell(0).setCellValue(valorCelula + "s2");
        }
        entrada.close();
        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha Atualizada");
    }
}
