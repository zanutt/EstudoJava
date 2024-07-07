package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivosCsv {
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

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);


        File arquivo = new File("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\arquivo.csv");

        if (!arquivo.exists()){
            arquivo.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        for (Pessoa p : pessoas){
            escrever_no_arquivo.write(p.getNome()+ ";" + p.getEmail()+ ";" + p.getIdade()+ "\n");
        }

        escrever_no_arquivo.flush();

        escrever_no_arquivo.close();


    }
}
