package ConhecendoLinguagem.src;

import ConhecendoLinguagem.src.classes.Aluno;
import ConhecendoLinguagem.src.classes.Disciplina;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrimeiraClasseJava {
    /* Main é o metodo auto executavel do java */
    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<Aluno>();

        for (int qtd = 1; qtd <= 2; qtd++){

            String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+qtd+" ?");
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

        for (int pos = 1; pos <= 4; pos++) {
            String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
            String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplina(nomeDisciplina);
            disciplina.setNota(Double.valueOf(notaDisciplina));
            aluno1.getDisciplinas().add(disciplina);
        }

        int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");

        if (escolha == 0) {
            int posicao = 1;
            int continuarRemover = 0;
            while (continuarRemover == 0) {
                String disciplinaRemover = JOptionPane.showInputDialog("Qual Disciplina 1, 2, 3, ou 4?");
                aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                posicao++;
                continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover outra disciplina?");
            }
        }
    alunos.add(aluno1);
    }
/*Listando alunos e removendo por nomes*/
//        for (Aluno aluno : alunos) {
//            if (aluno.getNome().equalsIgnoreCase("zanutt")) {
//                alunos.remove(aluno);
//                break;
//            }else{
//                System.out.println(aluno); /*Descriçao do objeto na memoria*/
//                System.out.println("A média do aluno é = "+ aluno.getMediaNota());
//                System.out.println("Resultado = "+(aluno.getAlunoAprovado2()));
//                System.out.println("--------------------------------------------------------------");
//            }
//        }
//        for (Aluno aluno : alunos){
//            System.out.println("Alunos na lista");
//            System.out.println(aluno.getNome());
//            System.out.println("Suas materias são: ");
//            for (Disciplina disciplina : aluno.getDisciplinas()){
//                System.out.println(disciplina.getDisciplina());
//            }
//        }
        for (int pos = 0; pos < alunos.size(); pos++){
            Aluno aluno = alunos.get(pos);
            if (aluno.getNome().equalsIgnoreCase("zanutt")){
                Aluno trocar = new Aluno();
                trocar.setNome("Aluno Foi trocado");

                Disciplina disciplina = new Disciplina();
                disciplina.setDisciplina("Math");
                disciplina.setNota(90);

                trocar.getDisciplinas().add(disciplina);
                alunos.set(pos, trocar);
                aluno = alunos.get(pos);
            }
            System.out.println("Aluno= " +aluno.getNome());
            System.out.println("Media do aluno = "+ aluno.getMediaNota());
            System.out.println("Resultado = "+ aluno.getAlunoAprovado2());
            System.out.println("--------------------------------------------------------------------");
            for (Disciplina disc : aluno.getDisciplinas()){
                System.out.println("Materia = " + disc.getDisciplina() + " Nota = " + disc.getNota());
            }
        }
    }
}
