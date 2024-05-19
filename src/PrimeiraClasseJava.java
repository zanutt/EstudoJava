package ConhecendoLinguagem.src;

import ConhecendoLinguagem.src.classes.Aluno;
import ConhecendoLinguagem.src.classes.Disciplina;

import javax.swing.*;

public class PrimeiraClasseJava {

    /* Main é o metodo auto executavel do java */
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
        String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
        String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
        String rg = JOptionPane.showInputDialog("Qual o RG?");
        String cpf = JOptionPane.showInputDialog("Qual o CPF?");
        String mae = JOptionPane.showInputDialog("Nome da mãe?");
        String pai = JOptionPane.showInputDialog("Nome do pai?");
        String matricula = JOptionPane.showInputDialog("Data da matricula");

        Aluno aluno1 = new Aluno();
        aluno1.setNome(nome);
        aluno1.setIdade(Integer.valueOf(idade));
        aluno1.setDataNascimento(dataNascimento);
        aluno1.setRegistroGeral(rg);
        aluno1.setNumeroCpf(cpf);
        aluno1.setNomeMae(mae);
        aluno1.setNomePai(pai);
        aluno1.setDataMatricula(matricula);

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("Banco de dados");
        disciplina1.setNota(90);

        aluno1.getDisciplinas().add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setDisciplina("Matematica");
        disciplina2.setNota(80);

        aluno1.getDisciplinas().add(disciplina2);

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setDisciplina("JavaScript");
        disciplina3.setNota(97);

        aluno1.getDisciplinas().add(disciplina3);

        Disciplina disciplina4 = new Disciplina();
        disciplina4.setDisciplina("HTML");
        disciplina4.setNota(70);

        aluno1.getDisciplinas().add(disciplina4);

        System.out.println(aluno1); /*Descriçao do objeto na memoria*/
        System.out.println("A média do aluno é = "+ aluno1.getMediaNota());
        System.out.println("Resultado = "+(aluno1.getAlunoAprovado()? "Aprovado" : "Reprovado"));


    }
}
