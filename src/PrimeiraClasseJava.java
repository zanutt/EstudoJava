package ConhecendoLinguagem.src;

import ConhecendoLinguagem.src.classes.Aluno;
import ConhecendoLinguagem.src.classes.Disciplina;

import javax.swing.*;

public class PrimeiraClasseJava {

    /* Main é o metodo auto executavel do java */
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
        /*String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
        String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
        String rg = JOptionPane.showInputDialog("Qual o RG?");
        String cpf = JOptionPane.showInputDialog("Qual o CPF?");
        String mae = JOptionPane.showInputDialog("Nome da mãe?");
        String pai = JOptionPane.showInputDialog("Nome do pai?");
        String matricula = JOptionPane.showInputDialog("Data da matricula");*/

        Aluno aluno1 = new Aluno();
        aluno1.setNome(nome);
        /*aluno1.setIdade(Integer.valueOf(idade));
        aluno1.setDataNascimento(dataNascimento);
        aluno1.setRegistroGeral(rg);
        aluno1.setNumeroCpf(cpf);
        aluno1.setNomeMae(mae);
        aluno1.setNomePai(pai);
        aluno1.setDataMatricula(matricula);*/

        for (int pos = 1; pos <= 4; pos++){
            String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+" ?");
            String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina "+pos+" ?");
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplina(nomeDisciplina);
            disciplina.setNota(Double.valueOf(notaDisciplina));
            aluno1.getDisciplinas().add(disciplina);
        }

        int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");

        if(escolha == 0){
            String disciplinaRemover = JOptionPane.showInputDialog("Qual Disciplina 1, 2, 3, ou 4?");
            aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() -1);
        }

        System.out.println(aluno1); /*Descriçao do objeto na memoria*/
        System.out.println("A média do aluno é = "+ aluno1.getMediaNota());
        System.out.println("Resultado = "+(aluno1.getAlunoAprovado2()));


    }
}
