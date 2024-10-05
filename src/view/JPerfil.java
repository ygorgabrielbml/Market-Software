package view;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class JPerfil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel imagemLabel; // Declare imagemLabel como um atributo da classe

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JPerfil frame = new JPerfil();
                    frame.setLocationRelativeTo(null); // Centraliza a janela ao abrir
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
    public JPerfil() {
        setTitle("Perfil");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(184, 134, 11));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(218, 165, 32));
        panel.setBounds(0, 0, 434, 44);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Compras");
        btnNewButton.setBounds(335, 11, 89, 23);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCompras comprasFrame = new JCompras();

                // Centraliza a janela
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - comprasFrame.getWidth()) / 2;
                int y = (screenSize.height - comprasFrame.getHeight()) / 2;
                comprasFrame.setLocation(x, y);

                comprasFrame.setVisible(true);
                dispose();
            }
        });

        JButton btnEstoque = new JButton("Estoque");
        btnEstoque.setBounds(10, 11, 89, 23);
        panel.add(btnEstoque);
        btnEstoque.addActionListener(new ActionListener() { // Corrigido para usar btnEstoque
            @Override
            public void actionPerformed(ActionEvent e) {
                JEstoque estoqueFrame = new JEstoque();

                // Centraliza a janela
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - estoqueFrame.getWidth()) / 2;
                int y = (screenSize.height - estoqueFrame.getHeight()) / 2;
                estoqueFrame.setLocation(x, y);
                estoqueFrame.setVisible(true);
                dispose();
            }
        });

        JButton btnInicio = new JButton("Início");
        btnInicio.setBounds(171, 11, 89, 23);
        panel.add(btnInicio);
        btnInicio.addActionListener(new ActionListener() { // Corrigido para usar btnInicio
            @Override
            public void actionPerformed(ActionEvent e) {
                JInicio inicioFrame = new JInicio();

                // Centraliza a janela
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - inicioFrame.getWidth()) / 2;
                int y = (screenSize.height - inicioFrame.getHeight()) / 2;
                inicioFrame.setLocation(x, y);
                inicioFrame.setVisible(true);
                dispose();
            }
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 61, 414, 189);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        imagemLabel = new JLabel();
        imagemLabel.setBounds(10, 39, 117, 88);
        panel_1.add(imagemLabel);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(139, 39, 156, 22);
        panel_1.add(textArea);

        JLabel lblNewLabel = new JLabel("Nome:");
        lblNewLabel.setBounds(139, 25, 46, 14);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("CPF:");
        lblNewLabel_1.setBounds(139, 60, 46, 14);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_1.add(lblNewLabel_1);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(139, 72, 156, 22);
        panel_1.add(textArea_1);

        JLabel lblNewLabel_2 = new JLabel("Vendas realizadas:");
        lblNewLabel_2.setBounds(139, 93, 126, 14);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_1.add(lblNewLabel_2);

        JTextArea textArea_3 = new JTextArea();
        textArea_3.setBounds(139, 105, 156, 22);
        panel_1.add(textArea_3);

        JLabel lblNewLabel_3 = new JLabel("Valor gerado: ");
        lblNewLabel_3.setBounds(139, 129, 111, 14);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_1.add(lblNewLabel_3);

        JTextArea textArea_4 = new JTextArea();
        textArea_4.setBounds(139, 143, 156, 22);
        panel_1.add(textArea_4);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Masculino");
        chckbxNewCheckBox.setBounds(311, 40, 97, 23);
        panel_1.add(chckbxNewCheckBox);

        JLabel lblNewLabel_4 = new JLabel("Genêro:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_4.setBounds(311, 25, 46, 14);
        panel_1.add(lblNewLabel_4);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Feminino");
        chckbxNewCheckBox_1.setBounds(311, 60, 97, 23);
        panel_1.add(chckbxNewCheckBox_1);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        separator.setBackground(new Color(0, 0, 0));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(305, 23, 7, 142);
        panel_1.add(separator);

        JLabel lblNewLabel_5 = new JLabel("Data de admissão:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNewLabel_5.setBounds(311, 93, 150, 14);
        panel_1.add(lblNewLabel_5);

        JTextArea textArea_5 = new JTextArea();
        textArea_5.setBounds(307, 105, 101, 22);
        panel_1.add(textArea_5);

        JButton btnNewButton_3 = new JButton("Mudar foto");
        btnNewButton_3.setBounds(10, 138, 117, 22);
        panel_1.add(btnNewButton_3);

        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon originalIcon = new ImageIcon(selectedFile.getPath());
                    // Redimensionar a imagem
                    Image originalImage = originalIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(imagemLabel.getWidth(), imagemLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    imagemLabel.setIcon(resizedIcon);
                    imagemLabel.setText(null);
                }
            }
        });
    }
}
