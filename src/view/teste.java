package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class teste extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollBar scrollBar; // Declarar o JScrollBar

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JPerfil frame = new JPerfil();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(184, 134, 11));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        // Criar o painel de cabeçalho
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(218, 165, 32));
        panelHeader.setBounds(0, 0, 434, 50);
        contentPane.add(panelHeader);
        panelHeader.setLayout(null);

        // Adicionar botões ao cabeçalho
        JButton btnCompras = new JButton("Compras");
        btnCompras.setBounds(335, 11, 89, 23);
        panelHeader.add(btnCompras);

        JButton btnEstoque = new JButton("Estoque");
        btnEstoque.setBounds(10, 11, 89, 23);
        panelHeader.add(btnEstoque);

        JButton btnInicio = new JButton("Início");
        btnInicio.setBounds(171, 11, 89, 23);
        panelHeader.add(btnInicio);

        // Criar o painel de informações
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(218, 165, 32));
        panelInfo.setLayout(null);
        panelInfo.setBounds(0, 51, 434, 600); // Altura maior para rolagem

        // Adicionar informações ao painel
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNome.setBounds(10, 10, 46, 14);
        panelInfo.add(lblNome);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 30, 370, 100);
        textArea.setText("Insira as informações do perfil aqui...");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panelInfo.add(textArea);
        
        // Adicionar mais informações
        JLabel lblOutro = new JLabel("Outra informação:");
        lblOutro.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblOutro.setBounds(10, 140, 120, 14);
        panelInfo.add(lblOutro);

        JTextArea textAreaOutro = new JTextArea();
        textAreaOutro.setBounds(10, 160, 370, 100);
        textAreaOutro.setText("Mais informações aqui...");
        textAreaOutro.setLineWrap(true);
        textAreaOutro.setWrapStyleWord(true);
        panelInfo.add(textAreaOutro);
        
        // Adicionar mais componentes conforme necessário para aumentar a altura

        // Adicionar o painel de informações ao contentPane
        contentPane.add(panelInfo);

        // Criar o JScrollBar
        scrollBar = new JScrollBar(JScrollBar.VERTICAL);
        scrollBar.setBounds(417, 51, 17, 600); // Posição e tamanho do JScrollBar
        contentPane.add(scrollBar);

        // Adicionar um listener para o JScrollBar
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Ajustar a posição do painel de informações com base na rolagem
                int y = -scrollBar.getValue();
                panelInfo.setLocation(0, y + 51); // Ajustar a posição vertical do painel
            }
        });
    }
}
