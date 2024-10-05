package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEstoque frame = new JEstoque();
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
	public JEstoque() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 165, 32));
		panel.setBounds(0, 0, 484, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCompras = new JButton("Compras");
		btnCompras.setBounds(10, 11, 89, 23);
		panel.add(btnCompras);
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
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setBounds(385, 11, 89, 23);
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
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(198, 11, 89, 23);
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

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 57, 464, 243);
		contentPane.add(panel_1);

		// Botão "Adicionar Produto"
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setBounds(35, 200, 150, 30); // Ajuste de acordo com a posição desejada
		panel_1.add(btnAdicionarProduto);

		btnAdicionarProduto.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("a");
		    }
		});

		// Botão "Remover Produto"
		JButton btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.setBounds(275, 200, 150, 30); // Ajuste de acordo com a posição desejada
		panel_1.add(btnRemoverProduto);

		btnRemoverProduto.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("b");
		    }
		});

		
	}
}
