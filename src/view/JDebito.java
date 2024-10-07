package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JDebito extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDinheiroCliente;
    private JTextField txtTroco;
    private JLabel lblValorTotal;
    private JTextField txtValorTotal;

    // Defina o valor total aqui, pode ser obtido de outra lógica
    private double valorTotal; // Inicialmente, não atribuímos um valor

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JDebito frame = new JDebito(500.00); // Passando um valor total de exemplo
                    frame.setResizable(false);;
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JDebito(double valorTotal) {
    this.valorTotal = valorTotal;
    }
    
    public JDebito() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 165, 248);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(184, 134, 11));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 134, 187);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblDinheiroCliente = new JLabel("Dinheiro do cliente:");
        lblDinheiroCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDinheiroCliente.setBounds(10, 67, 133, 14);
        panel.add(lblDinheiroCliente);
        
        txtDinheiroCliente = new JTextField();
        txtDinheiroCliente.setBounds(10, 92, 113, 20);
        panel.add(txtDinheiroCliente);
        txtDinheiroCliente.setColumns(10);
        
        JLabel lblTroco = new JLabel("Troco:");
        lblTroco.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTroco.setBounds(10, 123, 46, 14);
        panel.add(lblTroco);
        
        txtTroco = new JTextField();
        txtTroco.setForeground(new Color(0, 0, 0));
        txtTroco.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtTroco.setText("R$ " + "0.00");
        txtTroco.setEnabled(false);
        txtTroco.setEditable(false);
        txtTroco.setColumns(10);
        txtTroco.setBounds(10, 148, 113, 20);
        panel.add(txtTroco);
        
        lblValorTotal = new JLabel("Valor total:");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblValorTotal.setBounds(10, 11, 113, 14);
        panel.add(lblValorTotal);
        
        txtValorTotal = new JTextField();
        txtValorTotal.setText(String.format("R$ %.2f", valorTotal)); // Exibe o valor formatado
        txtValorTotal.setEditable(false);
        txtValorTotal.setEnabled(false);
        txtValorTotal.setColumns(10);
        txtValorTotal.setBounds(10, 36, 113, 20);
        panel.add(txtValorTotal);
        
        // Adiciona um DocumentListener para atualizar o troco
        txtDinheiroCliente.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                atualizarTroco();
            }
            public void removeUpdate(DocumentEvent e) {
                atualizarTroco();
            }
            public void changedUpdate(DocumentEvent e) {
                atualizarTroco();
            }
        });
    }

    // Método para atualizar o troco
    private void atualizarTroco() {
        try {
            double dinheiroCliente = Double.parseDouble(txtDinheiroCliente.getText());
            double troco = dinheiroCliente - valorTotal;
            txtTroco.setText(String.format("R$ %.2f", troco < 0 ? 0 : troco));
        } catch (NumberFormatException e) {
            txtTroco.setText("Insira números."); // Se a conversão falhar, mostra "Insira numeros".
        }
    }
}
