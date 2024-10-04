package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class JCadastro {

	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JPasswordField txtSenha2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro window = new JCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(218, 165, 32));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(114, 50, 181, 20);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(114, 36, 56, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(114, 93, 181, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(114, 79, 56, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(114, 130, 56, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(114, 167, 109, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(114, 143, 181, 20);
		frame.getContentPane().add(txtSenha);
		
		txtSenha2 = new JPasswordField();
		txtSenha2.setBounds(114, 182, 181, 20);
		frame.getContentPane().add(txtSenha2);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBackground(new Color(49, 62, 69));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(114, 213, 87, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(new Color(49, 62, 69));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(208, 213, 87, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(88, 11, 234, 239);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		panel.add(lblNewLabel);
	}
}
