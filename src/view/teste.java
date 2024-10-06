package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class teste extends JFrame {


	private static final long serialVersionUID = 7742653218683159869L;
	private JTextField searchField;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    private List<String> data;

    public teste() {
        setTitle("Sistema de Pesquisa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Dados que serão pesquisados
        data = new ArrayList<>();
        data.add("Alice");
        data.add("Bob");
        data.add("Charlie");
        data.add("David");
        data.add("Eve");
        data.add("Frank");
        data.add("Grace");

        // Campo de pesquisa
        searchField = new JTextField();
        add(searchField, BorderLayout.NORTH);

        // Modelo da lista
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        add(new JScrollPane(resultList), BorderLayout.CENTER);

        // Atualizar a lista com todos os dados iniciais
        updateList("");

        // Adiciona um DocumentListener para monitorar alterações no JTextField
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });
    }

    // Método para pesquisar e atualizar a lista
    private void search() {
        String searchText = searchField.getText().toLowerCase(); // Pega o texto do campo de pesquisa
        updateList(searchText); // Atualiza a lista de acordo com a pesquisa
    }

    // Método para atualizar a lista de resultados
    private void updateList(String searchText) {
        // Filtra a lista de dados com base no texto de pesquisa
        List<String> filteredData = data.stream()
                .filter(item -> item.toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        // Atualiza o modelo da lista
        listModel.clear();
        for (String item : filteredData) {
            listModel.addElement(item);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new teste().setVisible(true);
        });
    }
}
