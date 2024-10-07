package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.InfoPlus;
import backend.Usuario;

public class JPerfil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelGeral;
    private JLabel lblImagem;
    private Image originalImage;

    
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
        setBounds(100, 100, 450, 291);
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(184, 134, 11));
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);
        Usuario usuario = JLogin.l1;

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
        PanelMeio.setBounds(10, 61, 414, 176);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        lblImagem = new JLabel();
        lblImagem.setBounds(10, 39, 117, 88);
        PanelMeio.add(lblImagem);

        //Inicio do nome & cpf do funcionário.
        ArrayList<String> infos = null;
		try {
			infos = usuario.mostrarInfos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        JLabel infoNome = new JLabel(infos.get(0));
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

        JLabel infoCPF = new JLabel(infos.get(1));
        infoCPF.setBounds(137, 72, 156, 22);
        PanelMeio.add(infoCPF);

        //Fim do nome & cpf do funcionário.
        
        //Inicio do vendas realizadas & valor gerado;
        InfoPlus usuarioP = new InfoPlus(usuario.getNome(), usuario.getCpf(), usuario.isGenero(), usuario.getSenha(), usuario.getDataAdmissao(), 0, 0, usuario.getIdUser());
        ArrayList<Object> infoad = null;
        try {
			infoad = usuarioP.mostrarVendas();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (infoad.isEmpty()) {
        	infoad.add(Integer.valueOf(0));
        	infoad.add(Double.valueOf(0));
        }
        JLabel lblVendasRealizadas = new JLabel("Vendas realizadas:");
        lblVendasRealizadas.setBounds(137, 93, 126, 14);
        lblVendasRealizadas.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblVendasRealizadas);
        
        Integer vendas = (Integer) infoad.get(0);
        JLabel infoVendasRealizadas = new JLabel(vendas.toString());
        infoVendasRealizadas.setBounds(137, 105, 156, 22);
        PanelMeio.add(infoVendasRealizadas);

        JLabel lblValorGerado = new JLabel("Valor gerado: ");
        lblValorGerado.setBounds(137, 129, 111, 14);
        lblValorGerado.setFont(new Font("Tahoma", Font.BOLD, 11));
        PanelMeio.add(lblValorGerado);
        
        Double valor = (Double) infoad.get(1);
        JLabel infoValorGerado = new JLabel(valor.toString());
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

        JLabel infoDataAdmisao = new JLabel(infos.get(2));
        System.out.println(infos.get(2));
        infoDataAdmisao.setBounds(303, 105, 101, 22);
        PanelMeio.add(infoDataAdmisao);
        
        //Fim da data de admissão.

        JButton btnMudarImagem = new JButton("Mudar foto");
        btnMudarImagem.setForeground(new Color(255, 255, 255));
        btnMudarImagem.setBackground(new Color(49, 62, 69));
        btnMudarImagem.setBounds(10, 138, 117, 22);
        PanelMeio.add(btnMudarImagem);
        byte[] imagem = usuarioP.recuperarImagem();
        originalImage = InfoPlus.converterBytesParaImage(imagem);
        Image resizedImage = originalImage.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        lblImagem.setIcon(resizedIcon);
        lblImagem.setText(null);
        
        JLabel infoGenero = new JLabel(infos.get(3));
        infoGenero.setBounds(303, 39, 101, 22);
        PanelMeio.add(infoGenero);
        
        JButton btnTrocarConta = new JButton("Trocar conta");
        btnTrocarConta.setForeground(Color.WHITE);
        btnTrocarConta.setBackground(new Color(49, 62, 69));
        btnTrocarConta.setBounds(278, 138, 126, 22);
        PanelMeio.add(btnTrocarConta);
        
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
                    originalImage = originalIcon.getImage();
                    Image resizedImage = originalImage.getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    lblImagem.setIcon(resizedIcon);
                    lblImagem.setText(null);
                    usuarioP.inserirImagem(selectedFile);
       
                }
            }
          
        });
        
        //Fim do painel do meio.
        
    }
}