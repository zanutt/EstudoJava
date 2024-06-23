package aprendendo.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondTelaTest extends JDialog {

    private volatile boolean running = true;

    public SecondTelaTest() {
        JPanel jPanel = new JPanel(new GridBagLayout());/*Painel de componentes*/

        JLabel descricaoHora = new JLabel("Nome");
        JTextField mostraTempo = new JTextField();

        JLabel descricaoHora2 = new JLabel("Email");
        JTextField mostraTempo2 = new JTextField();

        JButton jButton = new JButton("Add Lista");
        JButton jButton2 = new JButton("Stop");

        ImplementacaoFilaThread fila = new ImplementacaoFilaThread();



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
        gridBagConstraints.gridy++;
        jPanel.add(mostraTempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoHora2, gridBagConstraints);

        mostraTempo2.setPreferredSize(new Dimension(200, 25));
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
                for (int qtd = 0; qtd < 100; qtd++) {/*Simulando 100 envios em massa*/
                    ObjetoFilaThread filaThread = new ObjetoFilaThread();

                    filaThread.setNome(mostraTempo.getText());
                    filaThread.setEmail(mostraTempo2.getText()+ " - "+ qtd);

                    fila.add(filaThread);
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                fila.interrupt();
            }
        });

        fila.start();
        add(jPanel, BorderLayout.WEST);
        /*Sempre sera o ultimo comando, Deixa a tela visivel ao usuario*/
        setVisible(true);
    }
}