package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class JCompras extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelGeral;
    private JTextField txtPesquisa;
    private ArrayList<String> listaProdutos;
    private HashMap<String, Double> precosProdutos;
    private DefaultListModel<String> modeloResultados;
    private DefaultListModel<String> modeloCarrinho;
    private JTextArea infoValorTotal;
    private double valorTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCompras frame = new JCompras();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JCompras() {
        setTitle("Compras");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 453);
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(184, 134, 11));
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);

        inicializarListaProdutos();

        JPanel Header = new JPanel();
        Header.setBackground(new Color(218, 165, 32));
        Header.setBounds(0, 0, 564, 44);
        PanelGeral.add(Header);
        Header.setLayout(null);

        JButton btnPerfil = new JButton("Perfil");
        btnPerfil.setBounds(10, 11, 89, 23);
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

        JButton btnEstoque = new JButton("Estoque");
        btnEstoque.setBounds(239, 11, 89, 23);
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

        JButton btnInicio = new JButton("Inicio");
        btnInicio.setBounds(465, 11, 89, 23);
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

        JPanel PanelMeio = new JPanel();
        PanelMeio.setBounds(10, 62, 544, 339);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(10, 11, 403, 20);
        PanelMeio.add(txtPesquisa);
        txtPesquisa.setColumns(10);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setForeground(new Color(255, 255, 255));
        btnPesquisar.setBounds(423, 10, 111, 23);
        btnPesquisar.setBackground(new Color(49, 62, 69));
        PanelMeio.add(btnPesquisar);
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisa = txtPesquisa.getText();
                ArrayList<String> resultado = pesquisarProduto(pesquisa);
                exibirResultadoPesquisa(resultado);
            }
        });

        JLabel lblResultados = new JLabel("Resultados:");
        lblResultados.setBounds(97, 49, 89, 14);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblResultados.setForeground(new Color(0, 0, 0));
        PanelMeio.add(lblResultados);

        JSeparator separator = new JSeparator();
        separator.setBounds(272, 61, 10, 278);
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(new Color(184, 134, 11));
        separator.setBackground(new Color(184, 134, 11));
        PanelMeio.add(separator);

        modeloResultados = new DefaultListModel<>();
        JList<String> listResultados = new JList<>(modeloResultados);
        listResultados.setBounds(10, 74, 255, 92);
        PanelMeio.add(listResultados);

        JButton btnAdicionarCarrinho = new JButton("Adicionar no carrinho");
        btnAdicionarCarrinho.setBounds(10, 174, 252, 23);
        btnAdicionarCarrinho.setForeground(new Color(255, 255, 255));
        btnAdicionarCarrinho.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnAdicionarCarrinho);
        btnAdicionarCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produtoSelecionado = listResultados.getSelectedValue();
                if (produtoSelecionado != null) {
                    adicionarAoCarrinho(produtoSelecionado);
                }
            }
        });

        modeloCarrinho = new DefaultListModel<>();
        JList<String> listCarrinho = new JList<>(modeloCarrinho);
        listCarrinho.setBounds(284, 74, 250, 259);
        PanelMeio.add(listCarrinho);

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

        valorTotal = 0.0;

        JButton btnRemoverProduto = new JButton("Remover produto");
        btnRemoverProduto.setBounds(115, 208, 147, 23);
        btnRemoverProduto.setForeground(new Color(255, 255, 255));
        btnRemoverProduto.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnRemoverProduto);
        btnRemoverProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produtoSelecionado = listCarrinho.getSelectedValue();
                if (produtoSelecionado != null) {
                    removerProdutoCarrinho(produtoSelecionado);
                }
            }
        });

        JButton btnCancelarProduto = new JButton("Cancelar produto");
        btnCancelarProduto.setBounds(115, 242, 147, 23);
        btnCancelarProduto.setForeground(new Color(255, 255, 255));
        btnCancelarProduto.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnCancelarProduto);
        btnCancelarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarProduto();
            }
        });

        JButton btnCancelarCompra = new JButton("Cancelar compra");
        btnCancelarCompra.setBounds(115, 276, 147, 23);
        btnCancelarCompra.setForeground(new Color(255, 255, 255));
        btnCancelarCompra.setBackground(new Color(49, 62, 64));
        PanelMeio.add(btnCancelarCompra);
        btnCancelarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCompra();
            }
        });
        
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setForeground(new Color(255, 255, 255));
        btnFinalizarCompra.setBackground(new Color(49, 62, 64));
        btnFinalizarCompra.setBounds(10, 310, 252, 23);
        PanelMeio.add(btnFinalizarCompra);
        
        
    }

    private void inicializarListaProdutos() {
        listaProdutos = new ArrayList<>();
        precosProdutos = new HashMap<>();

        listaProdutos.add("Camiseta Preta");
        precosProdutos.put("Camiseta Preta", 39.99);

        listaProdutos.add("Calça Jeans");
        precosProdutos.put("Calça Jeans", 79.99);

        listaProdutos.add("Tênis Esportivo");
        precosProdutos.put("Tênis Esportivo", 149.99);

        listaProdutos.add("Jaqueta de Couro");
        precosProdutos.put("Jaqueta de Couro", 299.99);

        listaProdutos.add("Relógio de Pulso");
        precosProdutos.put("Relógio de Pulso", 199.99);
    }

    private ArrayList<String> pesquisarProduto(String pesquisa) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String produto : listaProdutos) {
            if (produto.toLowerCase().contains(pesquisa.toLowerCase())) {
                resultado.add(produto + " - R$ " + String.format("%.2f", precosProdutos.get(produto)));
            }
        }
        return resultado;
    }

    private void exibirResultadoPesquisa(ArrayList<String> resultado) {
        modeloResultados.clear();
        for (String produto : resultado) {
            modeloResultados.addElement(produto);
        }
    }

    private void adicionarAoCarrinho(String produtoComPreco) {
        modeloCarrinho.addElement(produtoComPreco);
        String nomeProduto = produtoComPreco.split(" - ")[0];
        valorTotal += precosProdutos.get(nomeProduto);
        infoValorTotal.setText(String.format("R$ %.2f", valorTotal));
    }

    private void removerProdutoCarrinho(String produtoComPreco) {
        modeloCarrinho.removeElement(produtoComPreco);
        String nomeProduto = produtoComPreco.split(" - ")[0];
        valorTotal -= precosProdutos.get(nomeProduto);
        infoValorTotal.setText(String.format("R$ %.2f", valorTotal));
    }

    private void cancelarProduto() {
        modeloCarrinho.clear();
        valorTotal = 0.0;
        infoValorTotal.setText(String.format("R$ %.2f", valorTotal));
    }

    private void cancelarCompra() {
        JOptionPane.showMessageDialog(this, "Compra cancelada. Todos os produtos foram removidos do carrinho.", "Cancelar Compra", JOptionPane.INFORMATION_MESSAGE);
        cancelarProduto();
    }
}
