package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.Carrinho;
import backend.InfoPlus;
import backend.Usuario;

public class JCompras extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelGeral;
    private JTextField txtPesquisa;
    private DefaultListModel<String> modeloResultados;
    private DefaultListModel<String> modeloCarrinho;
    private JTextArea infoValorTotal;
    private ArrayList<Carrinho> resultadoBusca;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JCompras frame = new JCompras();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public JCompras() {
        setTitle("Compras");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 422);
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(184, 134, 11));
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);
        



        JPanel Header = new JPanel();
        Header.setBackground(new Color(218, 165, 32));
        Header.setBounds(0, 0, 564, 44);
        PanelGeral.add(Header);
        Header.setLayout(null);

        JButton btnPerfil = new JButton("Perfil");
        btnPerfil.setBounds(10, 11, 89, 23);
        Header.add(btnPerfil);
        btnPerfil.addActionListener(e -> {
            JPerfil perfilFrame = new JPerfil();
            centralizarJanela(perfilFrame);
            perfilFrame.setVisible(true);
            dispose();
        });

        JButton btnEstoque = new JButton("Estoque");
        btnEstoque.setBounds(239, 11, 89, 23);
        Header.add(btnEstoque);
        btnEstoque.addActionListener(e -> {
            JEstoque estoqueFrame = new JEstoque();
            centralizarJanela(estoqueFrame);
            estoqueFrame.setVisible(true);
            dispose();
        });

        JButton btnInicio = new JButton("Inicio");
        btnInicio.setBounds(465, 11, 89, 23);
        Header.add(btnInicio);
        btnInicio.addActionListener(e -> {
            JInicio inicioFrame = new JInicio();
            centralizarJanela(inicioFrame);
            inicioFrame.setVisible(true);
            dispose();
        });

        JPanel PanelMeio = new JPanel();
        PanelMeio.setBounds(10, 62, 544, 307);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        // variavel da caixa de pesquisa
        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(10, 11, 403, 20);
        PanelMeio.add(txtPesquisa);
        txtPesquisa.setColumns(10);

        // botão de pesquisar
        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setForeground(new Color(255, 255, 255));
        btnPesquisar.setBounds(423, 10, 111, 23);
        btnPesquisar.setBackground(new Color(49, 62, 69));
        PanelMeio.add(btnPesquisar);
        btnPesquisar.addActionListener(e -> {
        	modeloResultados.clear();
            String pesquisa = txtPesquisa.getText();
            resultadoBusca = Carrinho.pesquisar(pesquisa); // pegando do banco de dados
            for (Carrinho p : resultadoBusca) {
            	modeloResultados.addElement(p.toString());
            }
        });

        JLabel lblResultados = new JLabel("Resultados:");
        lblResultados.setBounds(97, 49, 89, 14);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblResultados.setForeground(new Color(0, 0, 0));
        PanelMeio.add(lblResultados);

        // tabela de resultados
        modeloResultados = new DefaultListModel<>();
        JList<String> listResultados = new JList<>(modeloResultados);
        JScrollPane scrollpane = new JScrollPane(listResultados);
		scrollpane.setLocation(10, 74);
		scrollpane.setSize(261, 92);
		PanelMeio.add(scrollpane);

        JSeparator separator = new JSeparator();
        separator.setBounds(275, 61, 10, 236);
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(new Color(184, 134, 11));
        separator.setBackground(new Color(184, 134, 11));
        PanelMeio.add(separator);


        JButton btnAdicionarCarrinho = new JButton("Adicionar no carrinho");
        btnAdicionarCarrinho.setBounds(10, 174, 252, 23);
        btnAdicionarCarrinho.setForeground(new Color(255, 255, 255));
        btnAdicionarCarrinho.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnAdicionarCarrinho);
        btnAdicionarCarrinho.addActionListener(e -> {
            String produtoSelecionado = listResultados.getSelectedValue();
            if (produtoSelecionado != null) {
            	modeloCarrinho.addElement(produtoSelecionado + " - 1 Unid.");
            	infoValorTotal.setText(String.format("R$ %.2f", calcularValorTotal()));
            }
        });

        modeloCarrinho = new DefaultListModel<>();
        JList<String> listCarrinho = new JList<>(modeloCarrinho);
        JScrollPane scrollpane2 = new JScrollPane(listCarrinho);
        scrollpane2.setBounds(282, 74, 252, 224);
        PanelMeio.add(scrollpane2);

        JLabel lblCarrinho = new JLabel("Carrinho:");
        lblCarrinho.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCarrinho.setBounds(370, 49, 89, 14);
        PanelMeio.add(lblCarrinho);

        JLabel lblValorTotal = new JLabel("Valor total: ");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblValorTotal.setBounds(10, 217, 70, 14);
        PanelMeio.add(lblValorTotal);

        infoValorTotal = new JTextArea();
        infoValorTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        infoValorTotal.setEnabled(false);
        infoValorTotal.setEditable(false);
        infoValorTotal.setBounds(10, 242, 95, 23);
        PanelMeio.add(infoValorTotal);

        JButton btnRemoverProduto = new JButton("Remover produto");
        btnRemoverProduto.setBounds(115, 208, 147, 23);
        btnRemoverProduto.setForeground(new Color(255, 255, 255));
        btnRemoverProduto.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnRemoverProduto);
        btnRemoverProduto.addActionListener(e -> {
            String produtoSelecionado = listCarrinho.getSelectedValue();
            if (produtoSelecionado != null) {
                removerProdutoCarrinho(produtoSelecionado);
                infoValorTotal.setText(String.format("R$ %.2f", calcularValorTotal()));
            }
        });


        JButton btnCancelarCompra = new JButton("Cancelar compra");
        btnCancelarCompra.setBounds(115, 245, 147, 23);
        btnCancelarCompra.setForeground(new Color(255, 255, 255));
        btnCancelarCompra.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnCancelarCompra);
        btnCancelarCompra.addActionListener(e -> cancelarCompra());
        
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setForeground(new Color(255, 255, 255));
        btnFinalizarCompra.setBackground(new Color(49, 62, 64));
        btnFinalizarCompra.setBounds(10, 276, 252, 23);
        PanelMeio.add(btnFinalizarCompra);
        btnFinalizarCompra.addActionListener(e -> finalizarCompra());
    }

    private void centralizarJanela(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

   
    private double calcularValorTotal() {
        double total = 0.0;
        for (int i = 0; i < modeloCarrinho.size(); i++) {
            String produtoComPreco = modeloCarrinho.get(i);
            String[] nomeProduto = produtoComPreco.split(",");
            String valorS = nomeProduto[2].split(":")[1];
            double valorD = Double.parseDouble(valorS);
            total += valorD;
        }
        return total;
    }

    private void removerProdutoCarrinho(String produtoComPreco) {
        modeloCarrinho.removeElement(produtoComPreco);
        //String nomeProduto = produtoComPreco.split(" - ")[0];
        
        infoValorTotal.setText(String.format("R$ %.2f", calcularValorTotal()));
    }


    private void cancelarCompra() {
        modeloCarrinho.clear(); // Limpa o carrinho
        infoValorTotal.setText(String.format("R$ %.2f", 0.0)); // Reseta o valor total
        JOptionPane.showMessageDialog(this, "Compra cancelada com sucesso!", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void finalizarCompra() {
    	Usuario usuario = JLogin.l1;
		InfoPlus venda = new InfoPlus(usuario.getNome(),usuario.getCpf(), usuario.isGenero(), usuario.getSenha(), usuario.getDataAdmissao(), 0, 0.0, usuario.getIdUser());
    	try {
			venda.registrarVenda(calcularValorTotal());
			modeloCarrinho.clear();
			infoValorTotal.setText(String.format("R$ %.2f", 0.0)); // Reseta o valor total
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}