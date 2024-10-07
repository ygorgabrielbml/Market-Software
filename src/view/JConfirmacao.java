package view;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JConfirmacao extends JFrame {
	private static final long serialVersionUID = 1L;
	public JConfirmacao() {
        setTitle("Confirmação");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel lblMensagem = new JLabel("Redirecionando para login.");
        lblMensagem.setBounds(50, 20, 200, 20);
        add(lblMensagem);
        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(100, 60, 80, 30);
        add(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLogin loginFrame = new JLogin(); // Supondo que JLogin seja a classe de login
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int x = (screenSize.width - loginFrame.getWidth()) / 2;
		        int y = (screenSize.height - loginFrame.getHeight()) / 2;
		        loginFrame.setLocation(x, y);
                loginFrame.setVisible(true); // Exibir a tela de login
                dispose(); // Fecha a tela de confirmação
            }
        });
    }
}