package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBoxExample extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JList<String> resultsList;
    private DefaultListModel<String> listModel;
    private JButton addToCartButton;
    private DefaultListModel<String> cartModel;

    public SearchBoxExample() {
        setTitle("Search Box Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de busca
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        searchButton = new JButton("Buscar");
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Lista de resultados
        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        JScrollPane resultsScrollPane = new JScrollPane(resultsList);

        // Botão de adicionar ao carrinho
        addToCartButton = new JButton("Adicionar ao Carrinho");

        // Painel de carrinho
        cartModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setPreferredSize(new Dimension(200, 150));

        // Adiciona componentes ao frame
        add(searchPanel, BorderLayout.NORTH);
        add(resultsScrollPane, BorderLayout.CENTER);
        add(addToCartButton, BorderLayout.SOUTH);
        add(cartScrollPane, BorderLayout.EAST);

        // Evento de busca
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exemplo de resultados de busca
                String[] results = {"Item 1", "Item 2", "Item 3", "Item 4"};
                listModel.clear();
                for (String result : results) {
                    listModel.addElement(result);
                }
            }
        });

        // Evento para adicionar ao carrinho
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = resultsList.getSelectedValue();
                if (selectedItem != null) {
                    cartModel.addElement(selectedItem);
                } else {
                    JOptionPane.showMessageDialog(SearchBoxExample.this, "Selecione um item para adicionar ao carrinho.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchBoxExample().setVisible(true);
        });
    }
}
