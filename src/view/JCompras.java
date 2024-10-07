package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JCompras extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelGeral;
    private JTextField txtPesquisa;
    private JTextArea areaResultados;  // Referência direta ao JTextArea
    private ArrayList<String> listaProdutos;

    // Launch the application.
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

    // Create the frame.
    public JCompras() {
        setTitle("Compras");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 470);
        PanelGeral = new JPanel();
        PanelGeral.setBackground(new Color(184, 134, 11));
        PanelGeral.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelGeral);
        PanelGeral.setLayout(null);

        // Inicializa a lista de produtos manualmente.
        inicializarListaProdutos();

        // Início do Header.
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

        // Fim do Header.

        // Inicio do painel do meio.
        JPanel PanelMeio = new JPanel();
        PanelMeio.setBounds(10, 62, 544, 358);
        PanelGeral.add(PanelMeio);
        PanelMeio.setLayout(null);

        // Início da aba de pesquisa.
        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(131, 11, 282, 20);
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
        lblResultados.setBounds(10, 48, 89, 14);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblResultados.setForeground(new Color(0, 0, 0));
        PanelMeio.add(lblResultados);

        areaResultados = new JTextArea();  // Inicializa o JTextArea
        areaResultados.setBounds(10, 70, 250, 110);
        PanelMeio.add(areaResultados);

        JSeparator separator = new JSeparator();
        separator.setBounds(272, 61, 10, 297);
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setForeground(new Color(184, 134, 11));
        separator.setBackground(new Color(184, 134, 11));
        PanelMeio.add(separator);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setForeground(new Color(255, 255, 255));
        btnFiltrar.setBackground(new Color(49, 62, 69));
        btnFiltrar.setBounds(10, 10, 111, 23);
        PanelMeio.add(btnFiltrar);

        // Fim da aba de pesquisa.

        // Início do método de pagamento.
        JLabel lblMetodoPagamento = new JLabel("Método de pagamento: ");
        lblMetodoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblMetodoPagamento.setBounds(70, 269, 135, 14);
        PanelMeio.add(lblMetodoPagamento);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 259, 272, 2);
        separator_1.setForeground(new Color(184, 134, 11));
        separator_1.setBackground(new Color(184, 134, 11));
        PanelMeio.add(separator_1);

        JButton btnDebito = new JButton("Débito");
        btnDebito.setForeground(new Color(255, 255, 255));
        btnDebito.setBackground(new Color(49, 62, 69));
        btnDebito.setBounds(98, 294, 76, 23);
        PanelMeio.add(btnDebito);
        btnDebito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDebito debitoFrame = new JDebito();
                // Centraliza a janela
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - debitoFrame.getWidth()) / 2;
                int y = (screenSize.height - debitoFrame.getHeight()) / 2;
                debitoFrame.setLocation(x, y);
                debitoFrame.setVisible(true);
            }
        });
        

        JButton btnCredito = new JButton("Crédito");
        btnCredito.setBackground(new Color(49, 62, 69));
        btnCredito.setForeground(new Color(255, 255, 255));
        btnCredito.setBounds(184, 294, 76, 23);
        PanelMeio.add(btnCredito);

        JButton btnAvista = new JButton("À vista");
        btnAvista.setForeground(new Color(255, 255, 255));
        btnAvista.setBackground(new Color(49, 62, 69));
        btnAvista.setBounds(10, 294, 76, 23);
        PanelMeio.add(btnAvista);

        // Fim do método de pagamento.

        // Inicio do valor total, remover produto do carrinho e cancelar compra.
        JLabel lblValorTotal = new JLabel("Valor total: ");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblValorTotal.setBounds(35, 212, 70, 14);
        PanelMeio.add(lblValorTotal);

        JTextArea infoValorTotal = new JTextArea();
        infoValorTotal.setEnabled(false);
        infoValorTotal.setEditable(false);
        infoValorTotal.setBounds(35, 226, 70, 22);
        PanelMeio.add(infoValorTotal);

        JButton btnRemoverProduto = new JButton("Remover");
        btnRemoverProduto.setBackground(new Color(49, 62, 69));
        btnRemoverProduto.setForeground(new Color(255, 255, 255));
        btnRemoverProduto.setBounds(144, 208, 96, 23);
        PanelMeio.add(btnRemoverProduto);

        JButton btnCancelarCompra = new JButton("Cancelar");
        btnCancelarCompra.setForeground(new Color(255, 255, 255));
        btnCancelarCompra.setBackground(new Color(49, 62, 69));
        btnCancelarCompra.setBounds(144, 234, 96, 23);
        PanelMeio.add(btnCancelarCompra);
        
        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(184, 134, 11));
        separator_1_2.setBackground(new Color(184, 134, 11));
        separator_1_2.setBounds(0, 199, 272, 2);
        PanelMeio.add(separator_1_2);
        
        JButton btnNewButton = new JButton("Finalizar compra");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(49, 62, 64));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(10, 328, 250, 23);
        PanelMeio.add(btnNewButton);
    }

    // Inicializa uma lista manual de produtos.
    private void inicializarListaProdutos() {
        listaProdutos = new ArrayList<>();
        listaProdutos.add("Camiseta Preta");
        listaProdutos.add("Calça Jeans");
        listaProdutos.add("Tênis Esportivo");
        listaProdutos.add("Jaqueta de Couro");
        listaProdutos.add("Relógio de Pulso");
        listaProdutos.add("Mochila Escolar");
    }

    // Método para pesquisar um produto na lista manual.
    private ArrayList<String> pesquisarProduto(String nome) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String produto : listaProdutos) {
            if (produto.toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    // Exibe o resultado da pesquisa.
    private void exibirResultadoPesquisa(ArrayList<String> resultado) {
        StringBuilder sb = new StringBuilder();
        for (String produto : resultado) {
            sb.append(produto).append("\n");
        }
        areaResultados.setText(sb.toString());  // Atualiza diretamente o JTextArea
    }
}
