package arquivos;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {
    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setCpf("898.565.646-56");
        usuario1.setLogin("znt");
        usuario1.setSenha("ababa");

        Usuario usuario2 = new Usuario();
        usuario2.setCpf("785.568.652-56");
        usuario2.setLogin("daib");
        usuario2.setSenha("ababa");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\filejson.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();


        /*================================ LENDO JSON ==============================*/

        FileReader fileReader = new FileReader("C:\\Users\\Zanutto\\Desktop\\Java\\ConhecendoLinguagem\\src\\arquivos\\filejson.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> usuarioList = new ArrayList<Usuario>();

        for (JsonElement jsonElement : jsonArray){
            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            usuarioList.add(usuario);
        }

        System.out.println("Leitura do arquivo JSON: " + usuarioList);



    }
}
