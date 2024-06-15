package EstudoEOOP;

import classes.Aluno;
import classes.Disciplina;

import javax.swing.*;

public class ArrayVetores {
    public static void main(String[] args) {

        double[] notas = {8.8,7.9,9.7,8.6};
        double[] notasLogica = {8.8,7.9,9.7,8.6};
        double[] notasC = {8.8,7.9,9.7,8.6};
        double[] notasPython = {8.8,7.9,9.7,8.6};

        Aluno aluno = new Aluno();
        aluno.setNome("Matheus Z");
        aluno.setNumeroCpf("32132142560");

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("Java");
        disciplina1.setNota(notas);
        aluno.getDisciplinas().add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setDisciplina("Logica de programação");
        disciplina2.setNota(notasLogica);
        aluno.getDisciplinas().add(disciplina2);

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setDisciplina("C");
        disciplina3.setNota(notasC);
        aluno.getDisciplinas().add(disciplina3);

        Disciplina disciplina4 = new Disciplina();
        disciplina4.setDisciplina("Python");
        disciplina4.setNota(notasPython);
        aluno.getDisciplinas().add(disciplina4);

        //---------------------------------------------------------------------------

        Aluno[] arrayAluno = new Aluno[1];

        arrayAluno[0] = aluno;

        for (int pos = 0; pos < arrayAluno.length; pos++){

            System.out.println("O nome do aluno é: " + arrayAluno[pos].getNome());

            for (Disciplina d : arrayAluno[pos].getDisciplinas()){
                System.out.println("Nome da Disciplina: " + d.getDisciplina());

                for (int posnota = 0; posnota < d.getNota().length; posnota++){
                    System.out.println("Nota " + (posnota+1) + ": " + d.getNota()[posnota]);
                }
            }

        }

    }
}
