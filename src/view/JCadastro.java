package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
					window.frame.setLocationRelativeTo(null);
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
		frame.setTitle("Cadastro");
		frame.getContentPane().setBackground(new Color(218, 165, 32));
		frame.setBounds(100, 100, 450, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(88, 11, 234, 354);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setBounds(26, 320, 87, 23);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBackground(new Color(49, 62, 69));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(92, 11, 79, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(123, 320, 85, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(49, 62, 69));
		btnNewButton_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setBounds(26, 150, 56, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(26, 175, 182, 20);
		panel.add(txtSenha);
		
		JLabel lblNewLabel_4 = new JLabel("Confirmar Senha:");
		lblNewLabel_4.setBounds(26, 206, 109, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtSenha2 = new JPasswordField();
		txtSenha2.setBounds(26, 231, 182, 20);
		panel.add(txtSenha2);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(26, 94, 56, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNome = new JTextField();
		txtNome.setBounds(26, 119, 181, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblGênero = new JLabel("Gênero:");
		lblGênero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGênero.setBounds(26, 262, 46, 14);
		panel.add(lblGênero);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(26, 287, 182, 22);
		panel.add(comboBox);
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");

		comboBox.setSelectedIndex(0);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(26, 63, 181, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(26, 38, 56, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		String nome = txtNome.getText();
		String cpf = txtCPF.getText();
		String senha = new String(txtSenha.getPassword());
		String senha2 = new String(txtSenha2.getPassword());
		
		
	}
}
