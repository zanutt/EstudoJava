package ConhecendoLinguagem.src;

import ConhecendoLinguagem.src.classes.Aluno;

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
        String nota1 = JOptionPane.showInputDialog("Qual a primeira nota?");
        String nota2 = JOptionPane.showInputDialog("Qual a segunda nota?");
        String nota3 = JOptionPane.showInputDialog("Qual a terceira nota?");
        String nota4 = JOptionPane.showInputDialog("Qual a quarta nota?");

        Aluno aluno1 = new Aluno();
        aluno1.setNome(nome);
        aluno1.setIdade(Integer.valueOf(idade));
        aluno1.setDataNascimento(dataNascimento);
        aluno1.setRegistroGeral(rg);
        aluno1.setNumeroCpf(cpf);
        aluno1.setNomeMae(mae);
        aluno1.setNomePai(pai);
        aluno1.setDataMatricula(matricula);
        aluno1.setNota1(Double.parseDouble(nota1));
        aluno1.setNota2(Double.parseDouble(nota2));
        aluno1.setNota3(Double.parseDouble(nota3));
        aluno1.setNota4(Double.parseDouble(nota4));

        System.out.println(aluno1.toString()); /*Descriçao do objeto na memoria*/
        System.out.println("A média do aluno é = "+ aluno1.getMediaNota());
        System.out.println("Resultado = "+(aluno1.getAlunoAprovado()? "Aprovado" : "Reprovado"));


    }
}
