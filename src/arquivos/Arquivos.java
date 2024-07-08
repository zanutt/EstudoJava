package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@hotmail.com");
        pessoa1.setIdade(50);
        pessoa1.setNome("znt");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@hotmail.com");
        pessoa2.setIdade(30);
        pessoa2.setNome("ceara");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@hotmail.com");
        pessoa3.setIdade(70);
        pessoa3.setNome("daibo");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de Pessoas");

        int numeroLinha = 0;
        for (Pessoa p : pessoas) {
            Row linha = linhasPessoa.createRow(numeroLinha++);

            int celula = 0;

            Cell celNome = linha.createCell(celula++);
            celNome.setCellValue(p.getNome());

            Cell celEmail = linha.createCell(celula++);
            celEmail.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++);
            celIdade.setCellValue(p.getIdade());
        }

        File file = new File("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\arquivo_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha foi criada.");
    }
}
