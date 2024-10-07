package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.Usuario;

public class JCadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelGeral;
    private JTextField txtCPF;
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JPasswordField txtSenha2;
    private JComboBox<String> comboboxHomemMulher; // Atributo de classe

    // Launch the application.
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCadastro frame = new JCadastro();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the frame.
    public JCadastro() {
        setTitle("Cadastro");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 415);
        
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(218, 165, 32));
        PanelGeral.setForeground(Color.WHITE);
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);

        // Início do painel de cadastro
        JPanel PanelMeio = new JPanel();
        PanelMeio.setBackground(Color.WHITE);
        PanelMeio.setBounds(88, 11, 234, 354);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        // Início do criar conta & cancelar criação.
        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(26, 320, 87, 23);
        PanelMeio.add(btnCriar);
        btnCriar.setForeground(Color.WHITE);
        btnCriar.setBackground(new Color(49, 62, 69));
        btnCriar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (txtNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(JCadastro.this, "É preciso inserir um nome.");
                    return;
                }

                // Verifica se as senhas são iguais
                if (!new String(txtSenha.getPassword()).equals(new String(txtSenha2.getPassword()))) {
                    JOptionPane.showMessageDialog(JCadastro.this, "As senhas não coincidem.");
                    return;
                }

                // Verifica a segurança da senha
                if (!isPasswordSecure(new String(txtSenha.getPassword()))) {
                    JOptionPane.showMessageDialog(JCadastro.this, "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, uma letra minúscula e um número.");
                    return;
                }

                // Formata o CPF
                String cpf = formatCPF(txtCPF.getText());
                if (cpf == null) {
                    JOptionPane.showMessageDialog(JCadastro.this, "O CPF deve estar no formato 000.000.000-00.");
                    return;
                }

                // Criação do cadastro
                LocalDate dataAtual = LocalDate.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataFormatada = dataAtual.format(formato);

                // Aqui você pode usar o objeto 'cadastro' conforme necessário
                int opcao = JOptionPane.showConfirmDialog(JCadastro.this,"Cadastro realizado com sucesso.", "Cadastro", JOptionPane.OK_CANCEL_OPTION);

                // Se o usuário clicar em "Ok", redirecionar para a página de login
                if (opcao == JOptionPane.OK_OPTION) {
                    // Trocar para a tela de login
                	Usuario usuario = new Usuario();
                	usuario.setDataAdmissao(dataFormatada);
                    usuario.setNome(txtNome.getText());
                    usuario.setCpf(cpf);
                    String generoSelecionado = (String) comboboxHomemMulher.getSelectedItem();
                    boolean genero = "Masculino".equals(generoSelecionado); // true se "Masculino", false se "Feminino"

                    usuario.setGenero(genero); // Atribuindo o valor booleano ao objeto Cadastro
                    usuario.setSenha(new String(txtSenha.getPassword()));
                    String mensagem = usuario.registro();
                    File imgFile = new File("target/1000_F_331699188_lRpvqxO5QRtwOM05gR50ImaaJgBx68vi.jpg");
                	JLogin loginFrame = new JLogin(); // Supondo que JLogin seja a classe de login
                	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    		        int x = (screenSize.width - loginFrame.getWidth()) / 2;
    		        int y = (screenSize.height - loginFrame.getHeight()) / 2;
    		        loginFrame.setLocation(x, y);
                	loginFrame.setVisible(true); // Exibir a tela de login
                    JCadastro.this.dispose(); // Fechar a tela de cadastro atual
                }
            }
        });


        JLabel lblCadastro = new JLabel("Cadastro");
        lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCadastro.setBounds(92, 11, 79, 14);
        PanelMeio.add(lblCadastro);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(123, 320, 85, 23);
        PanelMeio.add(btnCancelar);
        btnCancelar.setBackground(new Color(49, 62, 69));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLogin loginFrame = new JLogin();

				// Centraliza a janela
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screenSize.width - loginFrame.getWidth()) / 2;
				int y = (screenSize.height - loginFrame.getHeight()) / 2;
				loginFrame.setLocation(x, y);
				loginFrame.setVisible(true);
				dispose();
			}
		});

        // Fim do criar conta & cancelar criação.

        // Início do campo de senha.
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(26, 150, 56, 14);
        PanelMeio.add(lblSenha);
        lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));

        txtSenha = new JPasswordField();
        txtSenha.setBounds(26, 175, 182, 20);
        PanelMeio.add(txtSenha);

        JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
        lblConfirmarSenha.setBounds(26, 206, 109, 14);
        PanelMeio.add(lblConfirmarSenha);
        lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));

        txtSenha2 = new JPasswordField();
        txtSenha2.setBounds(26, 231, 182, 20);
        PanelMeio.add(txtSenha2);

        // Fim do campo de senha.

        // Início das informações pessoais do funcionário.
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(26, 94, 56, 14);
        PanelMeio.add(lblNome);
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));

        txtNome = new JTextField();
        txtNome.setBounds(26, 119, 181, 20);
        PanelMeio.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGenero.setBounds(26, 262, 46, 14);
        PanelMeio.add(lblGenero);

        // Use o atributo de classe para o JComboBox
        comboboxHomemMulher = new JComboBox<>(); 
        comboboxHomemMulher.setBounds(26, 287, 182, 22);
        PanelMeio.add(comboboxHomemMulher);
        comboboxHomemMulher.addItem("Masculino");
        comboboxHomemMulher.addItem("Feminino");
        comboboxHomemMulher.setSelectedIndex(0);

        txtCPF = new JTextField();
        txtCPF.setBounds(26, 63, 181, 20);
        PanelMeio.add(txtCPF);
        txtCPF.setColumns(10);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(26, 38, 56, 14);
        PanelMeio.add(lblCPF);
        lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));

        // Adicionando KeyListener ao campo CPF para formatação automática
        txtCPF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String formattedCPF = formatInputCPF(txtCPF.getText());
                txtCPF.setText(formattedCPF);
                // Move o cursor para o final do texto
                txtCPF.setCaretPosition(formattedCPF.length());
            }
        });

        // Fim das informações pessoais do funcionário.
    }

    // Método para verificar a segurança da senha
    private boolean isPasswordSecure(String password) {
        return password.length() >= 8 && 
               password.matches(".*[a-z].*") && // pelo menos uma letra minúscula
               password.matches(".*[A-Z].*") && // pelo menos uma letra maiúscula
               password.matches(".*[0-9].*");   // pelo menos um número
    }

    // Método para formatar a entrada do CPF
    private String formatInputCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (cpf.length() <= 3) {
            return cpf; // Retorna os primeiros 3 dígitos
        } else if (cpf.length() <= 6) {
            return cpf.substring(0, 3) + "." + cpf.substring(3); // Adiciona o ponto após os 3 dígitos
        } else if (cpf.length() <= 9) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6); // Adiciona o segundo ponto
        } else if (cpf.length() <= 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9); // Adiciona o traço
        }

        return cpf; // Retorna o CPF formatado
    }

    // Método para formatar o CPF para o padrão 000.000.000-00
    private String formatCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", ""); // Remove caracteres não numéricos
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
        }
        return null; // Retorna null se o CPF não estiver no formato correto
    }
}