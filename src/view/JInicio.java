package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class JInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelGeral;
	private JTextField txtPesquisa;

	
	//Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicio frame = new JInicio();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//Create the frame.
	 
	public JInicio() {	
		setTitle("Início");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelGeral = new JPanel();
		PanelGeral.setBackground(new Color(184, 134, 11));
		PanelGeral.setForeground(Color.WHITE);
		PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelGeral);
		PanelGeral.setLayout(null);
		
		//Início do Header.
		
		JPanel Header = new JPanel();
		Header.setBackground(new Color(218, 165, 32));
		Header.setBounds(0, 0, 434, 47);
		PanelGeral.add(Header);
		Header.setLayout(null);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(165, 11, 89, 23);
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
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(335, 11, 89, 23);
		Header.add(btnPerfil);
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
	
		JButton btnCompras = new JButton("Compras");
		btnCompras.setBounds(10, 11, 89, 23);
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
		
		//Fim do Header.

		
		//Inicio do painel do meio.
		
		JPanel PanelMeio = new JPanel();
		PanelMeio.setBounds(10, 58, 414, 192);
		PanelGeral.add(PanelMeio);
		PanelMeio.setLayout(null);
		
		//Início do campo de pesquisa.
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 11, 287, 20);
		PanelMeio.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBackground(new Color(49, 62, 69));
		btnPesquisar.setBounds(308, 11, 96, 20);
		PanelMeio.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtém o texto do campo de pesquisa e exibe uma mensagem
		        String textoPesquisa = txtPesquisa.getText();
		        JOptionPane.showMessageDialog(null, "Você pesquisou por: " + textoPesquisa);
		    }
		});
		
		//Fim do campo de pesquisa.
		
		
		//Fim do painel do meio.
		
	}
}
