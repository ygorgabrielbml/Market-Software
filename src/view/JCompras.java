package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class JCompras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompras frame = new JCompras();
					frame.setLocationRelativeTo(null);
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
	public JCompras() {
		setTitle("Compras");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 165, 32));
		panel.setBounds(0, 0, 564, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(10, 11, 89, 23);
		panel.add(btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JPerfil perfilFrame = new JPerfil();

		        // Centraliza a janela
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int x = (screenSize.width - perfilFrame.getWidth()) / 2;
		        int y = (screenSize.height - perfilFrame.getHeight()) / 2;
		        perfilFrame.setLocation(x, y);
		        
		        perfilFrame.setVisible(true);
		        dispose();
		    }
		});

		
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(239, 11, 89, 23);
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
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setBounds(465, 11, 89, 23);
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
		panel_1.setBounds(10, 62, 544, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(131, 11, 282, 20);
		panel_1.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBounds(423, 10, 111, 23);
		btnPesquisar.setBackground(new Color(49, 62, 69));
		panel_1.add(btnPesquisar);
		
		JLabel lblNewLabel = new JLabel("Resultados:");
		lblNewLabel.setBounds(10, 48, 89, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel_1.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(272, 61, 10, 257);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(184, 134, 11));
		separator.setBackground(new Color(184, 134, 11));
		panel_1.add(separator);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setForeground(new Color(255, 255, 255));
		btnFiltrar.setBackground(new Color(49, 62, 69));
		btnFiltrar.setBounds(10, 10, 111, 23);
		panel_1.add(btnFiltrar);
		
		JLabel lblNewLabel_1 = new JLabel("Método de pagamento: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(348, 266, 135, 14);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(272, 253, 272, 2);
		separator_1.setForeground(new Color(184, 134, 11));
		separator_1.setBackground(new Color(184, 134, 11));
		panel_1.add(separator_1);
		
		JButton btnNewButton = new JButton("Débito");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(49, 62, 69));
		btnNewButton.setBounds(372, 291, 76, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crédito");
		btnNewButton_1.setBackground(new Color(49, 62, 69));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(458, 291, 76, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("À vista");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(49, 62, 69));
		btnNewButton_2.setBounds(286, 291, 76, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Valor total: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(292, 195, 70, 14);
		panel_1.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(292, 209, 70, 22);
		panel_1.add(textArea);
		
		JButton btnNewButton_3 = new JButton("Remover");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(49, 62, 69));
		btnNewButton_3.setBounds(423, 198, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Cancelar");
		btnNewButton_3_1.setBackground(new Color(49, 62, 69));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(49, 62, 69));
		btnNewButton_3_1.setBounds(423, 221, 89, 23);
		panel_1.add(btnNewButton_3_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(184, 134, 11));
		separator_1_1.setBackground(new Color(184, 134, 11));
		separator_1_1.setBounds(272, 189, 272, 2);
		panel_1.add(separator_1_1);
	}
}
