public class VariChar {
    public static void main(String[] args){
        /*CHAR representa uma letra ou caracter*/
        char letra = 'F';
        if (letra == 'F'){
            System.out.println("Feminino");
        }else{
            System.out.println("Masculino");
        }
        /* String no java sempre sera um texto de tamanho qualquer */
        String texto = "Bom dia o Sol já nasceu na fazendinha";
                System.out.println(texto);
                /* Concatenando variaveis */
        System.out.println(letra+ " " + texto);
    }
}
