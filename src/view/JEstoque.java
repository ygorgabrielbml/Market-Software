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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class JEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelGeral;
	private JTextField inputNomeProduto;
	private JTextField inputCB;
	private JTextField inputPreco;
	private JTextField inputQuantidade;
	private JTextField textField;
	private JTextField inputMotivo;

	//Launch the application.
	
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

	
	 //Create the frame.
	 
	public JEstoque() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 348);
		PanelGeral = new JPanel();
		PanelGeral.setBackground(new Color(184, 134, 11));
		PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(PanelGeral);
		PanelGeral.setLayout(null);
		
		//Início do Header.
		
		JPanel Header = new JPanel();
		Header.setBackground(new Color(218, 165, 32));
		Header.setBounds(0, 0, 484, 46);
		PanelGeral.add(Header);
		Header.setLayout(null);
		
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
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setBounds(385, 11, 89, 23);
		Header.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
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

		//Fim do Header.
		
		
		//Painel do meio.
		
		JPanel PanelMeio = new JPanel();
		PanelMeio.setLayout(null);
		PanelMeio.setBounds(10, 57, 464, 241);
		PanelGeral.add(PanelMeio);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(184, 134, 11));
		separator.setBackground(new Color(184, 134, 11));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(245, 0, 2, 293);
		PanelMeio.add(separator);
		
		//Inicio do painel de adicionar produtos.
		
		JPanel panelAdicionarProdutos = new JPanel();
		panelAdicionarProdutos.setBounds(0, 0, 247, 241);
		PanelMeio.add(panelAdicionarProdutos);
		panelAdicionarProdutos.setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setForeground(new Color(255, 255, 255));
		btnAdicionarProduto.setBackground(new Color(49, 62, 69));
		btnAdicionarProduto.setBounds(51, 200, 144, 30);
		panelAdicionarProdutos.add(btnAdicionarProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do produto: ");
		lblNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeProduto.setBounds(51, 11, 144, 14);
		panelAdicionarProdutos.add(lblNomeProduto);
		
		inputNomeProduto = new JTextField();
		inputNomeProduto.setColumns(10);
		inputNomeProduto.setBounds(51, 28, 144, 20);
		panelAdicionarProdutos.add(inputNomeProduto);
		
		JLabel lblCB = new JLabel("Código de barras:");
		lblCB.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCB.setBounds(51, 59, 144, 14);
		panelAdicionarProdutos.add(lblCB);
		
		inputCB = new JTextField();
		inputCB.setColumns(10);
		inputCB.setBounds(51, 76, 144, 20);
		panelAdicionarProdutos.add(inputCB);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreco.setBounds(51, 107, 144, 14);
		panelAdicionarProdutos.add(lblPreco);
		
		inputPreco = new JTextField();
		inputPreco.setColumns(10);
		inputPreco.setBounds(51, 124, 144, 20);
		panelAdicionarProdutos.add(inputPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setBounds(51, 152, 144, 14);
		panelAdicionarProdutos.add(lblQuantidade);
		
		inputQuantidade = new JTextField();
		inputQuantidade.setColumns(10);
		inputQuantidade.setBounds(51, 169, 144, 20);
		panelAdicionarProdutos.add(inputQuantidade);
		
		//Fim do painel de adicionar produtos.
		
		
		//Inicio do painel de remover produtos.
		JPanel panelRemoverProdutos = new JPanel();
		panelRemoverProdutos.setBounds(249, 0, 215, 241);
		PanelMeio.add(panelRemoverProdutos);
		panelRemoverProdutos.setLayout(null);
		
		JLabel lblCodigoBarras = new JLabel("Código de barras:");
		lblCodigoBarras.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoBarras.setBounds(10, 11, 134, 14);
		panelRemoverProdutos.add(lblCodigoBarras);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 195, 20);
		panelRemoverProdutos.add(textField);
		textField.setColumns(10);
		
		inputMotivo = new JTextField();
		inputMotivo.setBounds(10, 81, 195, 108);
		panelRemoverProdutos.add(inputMotivo);
		inputMotivo.setColumns(10);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMotivo.setBounds(10, 67, 47, 14);
		panelRemoverProdutos.add(lblMotivo);
		
		JButton btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.setForeground(new Color(255, 255, 255));
		btnRemoverProduto.setBackground(new Color(49, 62, 69));
		btnRemoverProduto.setBounds(34, 200, 144, 30);
		panelRemoverProdutos.add(btnRemoverProduto);
		
		//Fim do painel de adicionar produtos.
		
	}
}
