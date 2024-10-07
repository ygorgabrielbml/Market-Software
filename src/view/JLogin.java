package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import backend.Usuario;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelGeral;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	protected static Usuario l1;

	// Método main para lançar a aplicação.
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JLogin frame = new JLogin();
				frame.setLocationRelativeTo(null); // Centraliza a janela
				frame.setVisible(true); // Torna a janela visível
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Cria a aplicação.
	public JLogin() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		PanelGeral = new JPanel();
		PanelGeral.setBackground(new Color(255, 165, 0));
		setContentPane(PanelGeral);
		PanelGeral.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(147, 60, 58, 14);
		PanelGeral.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 75, 135, 20);
		PanelGeral.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(147, 110, 58, 14);
		PanelGeral.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(147, 125, 135, 20);
		PanelGeral.add(txtSenha);

		// Início do Login (usuario & senha).

		// Início dos botões entrar e cadastrar.

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(49, 62, 69));
		btnEntrar.setBounds(147, 160, 135, 23);
		PanelGeral.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtUsuario.getText();
				String senha = new String(txtSenha.getPassword());
				String mensagem = "Acesso negado, verifique se você preencheu os campos corretamente!";
				if (login != null && !login.isEmpty() && senha != null && senha.length() > 0) {
					l1 = new Usuario();
					l1.setSenha(senha);
					l1.setLogin(login);
					mensagem = l1.login();
					JOptionPane.showMessageDialog(btnEntrar, mensagem);
					if (mensagem.equals("Login efetuado com sucesso")) {
						JInicio inicioFrame = new JInicio();

						// Centraliza a janela
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						int x = (screenSize.width - inicioFrame.getWidth()) / 2;
						int y = (screenSize.height - inicioFrame.getHeight()) / 2;
						inicioFrame.setLocation(x, y);
						inicioFrame.setVisible(true);
						dispose();

					}
				} else {
					JOptionPane.showMessageDialog(btnEntrar, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(49, 62, 69));
		btnCadastrar.setBounds(147, 200, 135, 23);
		PanelGeral.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCadastro cadastrarFrame = new JCadastro();

				// Centraliza a janela
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screenSize.width - cadastrarFrame.getWidth()) / 2;
				int y = (screenSize.height - cadastrarFrame.getHeight()) / 2;
				cadastrarFrame.setLocation(x, y);

				// Exibe a nova janela e fecha a janela de login
				cadastrarFrame.setVisible(true);
				dispose(); // Fecha a janela de login
			}
		});

		// Fim dos botões entrar e cadastrar.

		// Início do painel do meio.
		JPanel PanelMeio = new JPanel();
		PanelMeio.setBackground(new Color(255, 255, 255));
		PanelMeio.setBounds(113, 20, 200, 230);
		PanelGeral.add(PanelMeio);
		
				// Início do Login (usuario & senha).
				JLabel lblLogin = new JLabel("Login");
				PanelMeio.add(lblLogin);
				lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
}
