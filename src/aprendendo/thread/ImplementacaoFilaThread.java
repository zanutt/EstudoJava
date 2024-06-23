package aprendendo.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread){
        pilha_fila.add(objetoFilaThread);
    }

    @Override
    public void run() {

        System.out.println("Fila rodando");



        while (true) {
            synchronized (pilha_fila) {
                while (!pilha_fila.isEmpty()) {
                    ObjetoFilaThread processar = pilha_fila.poll();

                    System.out.println("-----------------------------");
                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());

                    try {
                        Thread.sleep(1000); // dar tempo para descarga de memória
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted.");
                        // Break out of the loop if the thread is interrupted
                        return;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                // Break out of the loop if the thread is interrupted
                return;
            }
        }
    }
}
