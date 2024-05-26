package EstudoEOOP;

import javax.swing.*;

public class CalcularMedia {
    public static void main(String[] args){
        String nota1 = JOptionPane.showInputDialog("Informe a nota 1: ");
        String nota2 = JOptionPane.showInputDialog("Informe a nota 2: ");
        String nota3 = JOptionPane.showInputDialog("Informe a nota 3: ");
        String nota4 = JOptionPane.showInputDialog("Informe a nota 4: ");

        double dNota1 = Double.parseDouble(nota1);
        double dNota2 = Double.parseDouble(nota2);
        double dNota3 = Double.parseDouble(nota3);
        double dNota4 = Double.parseDouble(nota4);

        double media = (dNota1 + dNota2 + dNota3 + dNota4) / 4;

        /*Média de aprovaçao é 70*/
        if (media >= 50){
            if (media >= 70){
                JOptionPane.showMessageDialog(null, "Aluno esta aprovado com a média: " + media);
            }else{
                JOptionPane.showMessageDialog(null, "Aluno esta de recuperação com a média: " + media);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aluno esta reprovado com a média: " + media);
        }
    }
}
