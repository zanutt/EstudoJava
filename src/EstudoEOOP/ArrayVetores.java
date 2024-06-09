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


        System.out.println("Nome do Aluno = " + aluno.getNome() + " cpf: " + aluno.getNumeroCpf());
        System.out.println("--------------------Disciplinas do Aluno--------------------");
        for (Disciplina d : aluno.getDisciplinas()){

            System.out.println("Disciplina: "+ d.getDisciplina());
            System.out.println("As notas da disciplina são: ");

            double notaMin = 0.0;
            double notaMax = 0.0;
            for (int pos =0; pos < d.getNota().length; pos++){
                System.out.println("Nota " + (pos+1) + ": "+ d.getNota()[pos]);
                if (pos == 0){
                    notaMax = d.getNota()[pos];
                }else{
                    if (d.getNota()[pos]> notaMax){
                        notaMax = d.getNota()[pos];
                    }
                }
                if (pos == 0){
                    notaMin = d.getNota()[pos];
                }else{
                    if (d.getNota()[pos]< notaMin){
                        notaMin = d.getNota()[pos];
                    }
                }
            }

            System.out.println("A maior nota da Disciplina " + d.getDisciplina() + " é: " + notaMax);
            System.out.println("A menor nota da Disciplina " + d.getDisciplina() + " é: " + notaMin);
        }

    }
}
