package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import backend.Carrinho;
import backend.Produto;

public class JInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelGeral;
	private JTextField txtPesquisa;
	private JList<Object> listaProdutos; // Lista para mostrar os produtos
	private DefaultListModel<Object> modelLista; // Modelo da lista

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JInicio frame = new JInicio();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Create the frame.
	public JInicio() {
		setTitle("Início");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		PanelGeral = new JPanel();
		PanelGeral.setBackground(new Color(184, 134, 11));
		PanelGeral.setForeground(Color.WHITE);
		PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelGeral);
		PanelGeral.setLayout(null);

		// Início do Header.
		JPanel Header = new JPanel();
		Header.setBackground(new Color(218, 165, 32));
		Header.setBounds(0, 0, 434, 47);
		PanelGeral.add(Header);
		Header.setLayout(null);

		// Botões de navegação
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(165, 11, 89, 23);
		Header.add(btnEstoque);
		btnEstoque.addActionListener(e -> navigateTo(JEstoque.class));

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(335, 11, 89, 23);
		Header.add(btnPerfil);
		btnPerfil.addActionListener(e -> navigateTo(JPerfil.class));

		JButton btnCompras = new JButton("Compras");
		btnCompras.setBounds(10, 11, 89, 23);
		Header.add(btnCompras);
		btnCompras.addActionListener(e -> navigateTo(JCompras.class));

		// Fim do Header.

		// Início do painel do meio.
		JPanel PanelMeio = new JPanel();
		PanelMeio.setBounds(10, 58, 414, 222);
		PanelGeral.add(PanelMeio);
		PanelMeio.setLayout(null);

		// Campo de pesquisa
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 11, 287, 20);
		PanelMeio.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBackground(new Color(49, 62, 69));
		btnPesquisar.setBounds(308, 11, 96, 20);
		PanelMeio.add(btnPesquisar);

		// Lista para mostrar os produtos
		ArrayList<Produto> listaEstoque = Produto.verificarEstoque();
		modelLista = new DefaultListModel<>();
		listaProdutos = new JList<>(modelLista);
		for (Produto p : listaEstoque) {
			modelLista.addElement(p);
		}
		JScrollPane scrollpane = new JScrollPane(listaProdutos);
		scrollpane.setLocation(10, 42);
		scrollpane.setSize(394, 169);
		PanelMeio.add(scrollpane);

		// Ação do botão de pesquisa
		btnPesquisar.addActionListener(e -> {
			String textoPesquisa = txtPesquisa.getText();
			ArrayList<Carrinho> produtosEncontrados = Carrinho.pesquisar(textoPesquisa);
			modelLista.clear(); // Limpa a lista atual
			for (Carrinho produto : produtosEncontrados) {
				modelLista.addElement(produto); // Adiciona os produtos encontrados à lista
			}
			if (produtosEncontrados.isEmpty()) {
				for (Produto p : listaEstoque) {
					modelLista.addElement(p);
				}
				JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.", "Resultado da Pesquisa",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});

		// Fim do painel do meio.
	}

	// Método para navegar entre as janelas
	private void navigateTo(Class<?> clazz) {
		try {
			JFrame frame = (JFrame) clazz.getDeclaredConstructor().newInstance();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screenSize.width - frame.getWidth()) / 2;
			int y = (screenSize.height - frame.getHeight()) / 2;
			frame.setLocation(x, y);
			frame.setVisible(true);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método para mostrar as informações do produto
	private void mostrarInformacoesProduto() {
		Carrinho produtoSelecionado = (Carrinho) listaProdutos.getSelectedValue();
		if (produtoSelecionado != null) {
			JOptionPane.showMessageDialog(this,
					"Nome: " + produtoSelecionado.getNome() + "\n" + "Código de Barras: "
							+ produtoSelecionado.getCodigoBarras() + "\n" + "Valor: " + produtoSelecionado.getValor(),
					"Informações do Produto", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, selecione um produto na lista.",
					"Nenhum Produto Selecionado", JOptionPane.WARNING_MESSAGE);
		}
	}
}
