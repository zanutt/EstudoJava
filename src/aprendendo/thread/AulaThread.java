package aprendendo.thread;

import javax.swing.*;

public class AulaThread {

    public static void main(String[] args) throws InterruptedException {

        Thread threadEmail = new Thread(thread1);
        threadEmail.start();

        /*****************************************DIVISAO DAS THREADS**************************************/


        Thread threadNFE = new Thread(thread2);
        threadNFE.start();


        System.out.println("Chegou ao Fim do Codigo teste");
        JOptionPane.showMessageDialog(null, "Sistema continua executando");

    }


    private static Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            for (int pos = 0; pos < 10; pos++){

                System.out.println("Executando rotina...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    };


    private static Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            /*Executa o codigo*/
            for (int pos = 0; pos < 10; pos++){

                System.out.println("Executando rotina...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    };

}
