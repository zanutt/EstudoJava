package EstudoEOOP;

import ConhecendoLinguagem.src.constantes.StatusAluno;
import classes.Aluno;
import classes.Disciplina;
import classes.Secretario;
import classesAuxiliares.FuncaoAutenticacao;
import interfaces.PermitirAcesso;
import classes.Diretor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimeiraClasseJava {
    /* Main é o metodo auto executavel do java */
    public static void main(String[] args) {

        try {

            String login = JOptionPane.showInputDialog("Informe o login");
            String senha = JOptionPane.showInputDialog("Informe a senha");


            if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) {


                List<Aluno> alunos = new ArrayList<Aluno>();

                HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

                for (int qtd = 1; qtd <= 2; qtd++) {

                    String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + " ?");
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
                        //disciplina.setNota(Double.valueOf(notaDisciplina));
                        aluno1.getDisciplinas().add(disciplina);
                    }

//        int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");

//        if (escolha == 0) {
//            int posicao = 1;
//            int continuarRemover = 0;
//            while (continuarRemover == 0) {
//                String disciplinaRemover = JOptionPane.showInputDialog("Qual Disciplina 1, 2, 3, ou 4?");
//                aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
//                posicao++;
//                continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover outra disciplina?");
//            }
//        }
                    alunos.add(aluno1);
                }

                maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
                maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
                maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

                for (Aluno aluno : alunos) {/*Separando em listas*/
                    if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                        maps.get(StatusAluno.APROVADO).add(aluno);
                    } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                        maps.get(StatusAluno.RECUPERACAO).add(aluno);
                    } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                        maps.get(StatusAluno.REPROVADO).add(aluno);
                    }
                }

                System.out.println("---------------------------Lista dos aprovados------------------------");
                for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                    System.out.println("Aluno" + aluno.getNome() + " Resultado =" + aluno.getAlunoAprovado2() + " com media de " + aluno.getMediaNota());
                }

                System.out.println("---------------------------Lista recuperaçao------------------------");
                for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                    System.out.println("Aluno" + aluno.getNome() + " Resultado =" + aluno.getAlunoAprovado2() + " com media de " + aluno.getMediaNota());
                }
                System.out.println("---------------------------Lista Reprovados------------------------");
                for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                    System.out.println("Aluno " + aluno.getNome() + " Resultado = " + aluno.getAlunoAprovado2() + " com media de " + aluno.getMediaNota());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Acesso não permitido");
            }

            /*aqui*/
        }catch(NumberFormatException e){

            StringBuilder saida = new StringBuilder();

            e.printStackTrace();/*Imprime o erro no console*/

            System.out.println(" Mensagem: "+ e.getMessage());

            for (int pos = 0; pos < e.getStackTrace().length; pos++){

                saida.append("\n Classe de erro: " + e.getStackTrace()[pos].getClassName());
                saida.append("\n Método de erro: " + e.getStackTrace()[pos].getMethodName());
                saida.append("\n Linha de erro: " + e.getStackTrace()[pos].getLineNumber());
                saida.append("\n Class: " + e.getClass().getName());

                JOptionPane.showMessageDialog(null, "Erro de Conversao de numero" + saida.toString());
            }

            JOptionPane.showMessageDialog(null,"Erro ao processar notas.");
        }
}
}