package aprendendo.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog {

    private volatile boolean running = true;

    public TelaTimeThread() {
        JPanel jPanel = new JPanel(new GridBagLayout());/*Painel de componentes*/

        JLabel descricaoHora = new JLabel("Time Thread 1");
        JTextField mostraTempo = new JTextField();

        JLabel descricaoHora2 = new JLabel("Time Thread 2");
        JTextField mostraTempo2 = new JTextField();

        JButton jButton = new JButton("Start");
        JButton jButton2 = new JButton("Stop");

        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                while (running) {
                    mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").
                            format(Calendar.getInstance().getTime()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // Thread interrompida
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread está parando.");
            }
        };

        final Thread[] thread1Time = new Thread[1];

        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                while (running) {
                    mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").
                            format(Calendar.getInstance().getTime()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // Thread interrompida
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread está parando.");
            }
        };

        final Thread[] thread2Time = new Thread[1];

        setTitle("Tela de tempo para testar Threads");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descricaoHora, gridBagConstraints);

        mostraTempo.setPreferredSize(new Dimension(200, 25));
        mostraTempo.setEditable(false);
        gridBagConstraints.gridy++;
        jPanel.add(mostraTempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoHora2, gridBagConstraints);

        mostraTempo2.setPreferredSize(new Dimension(200, 25));
        mostraTempo2.setEditable(false);
        gridBagConstraints.gridy++;
        jPanel.add(mostraTempo2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jPanel.add(jButton, gridBagConstraints);

        jButton2.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jPanel.add(jButton2, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {/*Executa o clique no button*/
                running = true;
                thread1Time[0] = new Thread(thread1);
                thread1Time[0].start();
                thread2Time[0] = new Thread(thread2);
                thread2Time[0].start();

                jButton.setEnabled(false);
                jButton2.setEnabled(true);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                if (thread1Time[0] != null) {
                    thread1Time[0].interrupt();
                    thread2Time[0].interrupt();
                }
                jButton2.setEnabled(false);
                jButton.setEnabled(true);
            }
        });

        jButton2.setEnabled(false);

        add(jPanel, BorderLayout.WEST);
        /*Sempre sera o ultimo comando, Deixa a tela visivel ao usuario*/
        setVisible(true);
    }
}