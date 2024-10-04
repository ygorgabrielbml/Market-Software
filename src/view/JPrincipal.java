package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class JPrincipal extends JFrame {

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
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 165, 32));
		panel.setBounds(0, 0, 434, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEstoquePage = new JButton("Estoque");
		btnEstoquePage.setBounds(165, 11, 89, 23);
		panel.add(btnEstoquePage);
		
		JButton btnPerfilPage = new JButton("Perfil");
		btnPerfilPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfilPage.setBounds(335, 11, 89, 23);
		panel.add(btnPerfilPage);
		
		JButton btnNewButton = new JButton("Compras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 58, 414, 192);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 11, 287, 20);
		panel_1.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(308, 11, 96, 20);
		panel_1.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtém o texto do campo de pesquisa e exibe uma mensagem
		        String textoPesquisa = txtPesquisa.getText();
		        JOptionPane.showMessageDialog(null, "Você pesquisou por: " + textoPesquisa);
		    }
		});
	}
}
