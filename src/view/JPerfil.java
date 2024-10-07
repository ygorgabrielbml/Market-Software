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
    private JPanel PanelGeral;
    private JLabel lblImagem;

    
     // Launch the application.
     
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

    //Create the frame.
     
    public JPerfil() {
        setTitle("Perfil");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(184, 134, 11));
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);

        //Inicio do Header.
        
        JPanel Header = new JPanel();
        Header.setBackground(new Color(218, 165, 32));
        Header.setBounds(0, 0, 434, 44);
        PanelGeral.add(Header);
        Header.setLayout(null);

        JButton btnCompras = new JButton("Compras");
        btnCompras.setBounds(335, 11, 89, 23);
        Header.add(btnCompras);
        btnCompras.addActionListener(new ActionListener() {
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
        Header.add(btnEstoque);
        btnEstoque.addActionListener(new ActionListener() { 
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
        Header.add(btnInicio);
        btnInicio.addActionListener(new ActionListener() { 
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

        //Fim do Header.
        
        //Inicio do painel do meio.
        JPanel PanelMeio = new JPanel();
        PanelMeio.setBounds(10, 61, 414, 189);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        lblImagem = new JLabel();
        lblImagem.setBounds(10, 39, 117, 88);
        PanelMeio.add(lblImagem);

        //Inicio do nome & cpf do funcionário.
        
        JTextArea infoNome = new JTextArea();
        infoNome.setBounds(137, 39, 156, 22);
        PanelMeio.add(infoNome);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(137, 25, 46, 14);
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblNome);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(137, 60, 46, 14);
        lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblCPF);

        JTextArea infoCPF = new JTextArea();
        infoCPF.setBounds(137, 72, 156, 22);
        PanelMeio.add(infoCPF);

        //Fim do nome & cpf do funcionário.
        
        //Inicio do vendas realizadas & valor gerado;
        
        JLabel lblVendasRealizadas = new JLabel("Vendas realizadas:");
        lblVendasRealizadas.setBounds(137, 93, 126, 14);
        lblVendasRealizadas.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblVendasRealizadas);

        JTextArea infoVendasRealizadas = new JTextArea();
        infoVendasRealizadas.setBounds(137, 105, 156, 22);
        PanelMeio.add(infoVendasRealizadas);

        JLabel lblValorGerado = new JLabel("Valor gerado: ");
        lblValorGerado.setBounds(137, 129, 111, 14);
        lblValorGerado.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblValorGerado);

        JTextArea infoValorGerado = new JTextArea();
        infoValorGerado.setBounds(137, 143, 156, 22);
        PanelMeio.add(infoValorGerado);

        JLabel lblGenero = new JLabel("Genêro:");
        lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGenero.setBounds(303, 25, 46, 14);
        PanelMeio.add(lblGenero);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        separator.setBackground(new Color(0, 0, 0));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(303, 25, 0, 142);
        PanelMeio.add(separator);
        
        //Fim do CheckBoxGênero
        
        //Data de admissão.
        
        JLabel lblDataAdmissao = new JLabel("Data de admissão:");
        lblDataAdmissao.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDataAdmissao.setBounds(303, 93, 150, 14);
        PanelMeio.add(lblDataAdmissao);

        JTextArea infoDataAdmisao = new JTextArea();
        infoDataAdmisao.setBounds(303, 105, 101, 22);
        PanelMeio.add(infoDataAdmisao);
        
        //Fim da data de admissão.

        JButton btnMudarImagem = new JButton("Mudar foto");
        btnMudarImagem.setForeground(new Color(255, 255, 255));
        btnMudarImagem.setBackground(new Color(49, 62, 69));
        btnMudarImagem.setBounds(10, 138, 117, 22);
        PanelMeio.add(btnMudarImagem);
        
        JTextArea infoDataAdmisao_1 = new JTextArea();
        infoDataAdmisao_1.setBounds(303, 39, 101, 22);
        PanelMeio.add(infoDataAdmisao_1);

        btnMudarImagem.addActionListener(new ActionListener() {

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
                    Image resizedImage = originalImage.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    lblImagem.setIcon(resizedIcon);
                    lblImagem.setText(null);
       
                }
            }
          
        });
        
        //Fim do painel do meio.
        
    }
}
