package arquivos;

import java.io.File;
import java.io.IOException;

public class ApachePoi {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\arquivo_excel.xsl");

        if (!file.exists()){
            file.createNewFile();
        }

    }
}
