package app;

import javax.swing.SwingUtilities;
import view.JLogin;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLogin login = new JLogin(); // Cria uma nova instância da classe JLogin
                login.setLocationRelativeTo(null); // Centraliza a janela
                login.setVisible(true); // Torna a janela visível
            }
        });
    }
}
