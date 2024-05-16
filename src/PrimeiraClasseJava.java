package ConhecendoLinguagem.src;

import ConhecendoLinguagem.src.classes.Aluno;

public class PrimeiraClasseJava {

    /* Main é o metodo auto executavel do java */
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.setNota1(90);
        aluno1.setNota2(80.8);
        aluno1.setNota3(70.9);
        aluno1.setNota4(90.7);

        System.out.println("Nome é = "+ aluno1.getNome());
        System.out.println("A média do aluno é = "+ aluno1.getMediaNota());
        System.out.println("Resultado = "+(aluno1.getAlunoAprovado()? "Aprovado" : "Reprovado"));


        Aluno aluno2 = new Aluno();
    }
}
