package br.com.projeto.jdbc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

/**
 *
 * @author diego.felipe
 */
public class TratacaoErros {

    // algumas IDE's podem reclamar de codificação de texto,
    // por causa destes simbolos, por isso deve-se manter
    // a codificação UTF-8 ou alterar os simbolos
    private static final String BUTTON_UP = "▲";
    private static final String BUTTON_DOWN = "▼";
    private static final String MENSAGEM = "Ocorreu uma exceção não tratada em seu aplicativo. "
            + "Clique em Detalhes para obter mais informações ou clique em Sair para fechar o aplicativo imediatamente.";

    private TratacaoErros() {

    }

    public static void showException(String shortError, String strStackTrace) {

        // - fixedWith é um tamanho fixo para o frame não ficar redimensionando
        // ao abrir o JTextPane contendo a stacktrace.
        // - minHeight é o tamanho minimo do frame, quando o JTextPane da
        // StackTrace não estiver visível.
        // - maxHeight é a altura máxima do frame, comportando o JTextPane da
        // stracktrace aberto.
        int fixedWidth = 450;
        int minHeight = 250;
        int maxHeight = 500;

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        // obrigatório, para que o BorderLayout não redimensione automaticamente
        frame.setPreferredSize(new Dimension(fixedWidth, minHeight));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel principal que comportará os paineis de botoes
        // e da mensagem padrao
        JPanel principalPane = new JPanel();
        principalPane.setLayout(new BoxLayout(principalPane, BoxLayout.Y_AXIS));

        // painel onde será comportado o JTextPane com a mensagem
        // padrão mais a mensagem de erro sem o stacktrace
        JPanel messageDefaultPane = new JPanel(new BorderLayout(0, 5));
        messageDefaultPane.setBorder(BorderFactory.createEmptyBorder(3, 3, 0, 0));
        // componente onde será exibida a mensagem de erro padrao
        JTextPane tp_messageDefault = new JTextPane();
        tp_messageDefault.setBackground(frame.getBackground());
        tp_messageDefault.setEditable(false);
        tp_messageDefault.setText(MENSAGEM + "\n\n" + shortError);

        messageDefaultPane.add(tp_messageDefault, BorderLayout.CENTER);

        // scrollPane comportará o JTextPane que exibirá o stacktrace quando o
        // botao for clicado
        JScrollPane scrollPane = new JScrollPane();
        JTextPane tp_stackTrace = new JTextPane();
        tp_stackTrace.setBackground(frame.getBackground());
        tp_stackTrace.setEditable(false);

        // painel contendo os botoes Detais, Quit e Continue
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));

        // Como o estado do botão Details servirá para exibir ou ocultar
        // o JToggleButton faz mais sentido aqui
        JToggleButton btn_showDetails = new JToggleButton("Detalhes " + BUTTON_DOWN);
        btn_showDetails.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // quando o status do botao for "selecionado", a stacktrace será
                // atribuida no JTextPane, o frame terá sua altura alterada
                // para maxHeight e a posição da barra de scroll
                // ficará no topo do erro
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tp_stackTrace.setText(strStackTrace);
                    frame.setPreferredSize(new Dimension(fixedWidth, maxHeight));
                    tp_stackTrace.setCaretPosition(0);
                    frame.pack();
                    btn_showDetails.setText("Detalhes " + BUTTON_UP);
                    // quando o status anterior do botao for desfeito, remove a
                    // stacktrace do componente de texto e redefine
                    // a altura minima para o frame
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    tp_stackTrace.setText(null);
                    frame.setPreferredSize(new Dimension(fixedWidth, minHeight));
                    frame.pack();
                    btn_showDetails.setText("Detalhes " + BUTTON_DOWN);
                }
            }
        });

        // funcionalidades não implementadas

        buttonPane.add(btn_showDetails);
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));

        scrollPane.setViewportView(tp_stackTrace);

        principalPane.add(messageDefaultPane);
        principalPane.add(buttonPane);

        frame.add(principalPane, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}
