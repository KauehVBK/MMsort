import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Tela2 extends JFrame {
    private JTextField tf_nome;
    private JTextArea tx_a;
    private JComboBox<Integer> comb_rank;
    private List<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tela2 window = new Tela2();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Tela2() {
        initialize();
    }

    public void initialize() {
        // Configuração básica da janela
        setTitle("Tela de Cadastro");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Componentes de entrada
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 50, 20);
        add(lblNome);

        tf_nome = new JTextField();
        tf_nome.setBounds(61, 11, 150, 20);
        add(tf_nome);

        JLabel lblRank = new JLabel("Rank:");
        lblRank.setBounds(10, 41, 50, 20);
        add(lblRank);

        comb_rank = new JComboBox<>();
        comb_rank.setBounds(61, 41, 80, 22);
        for (int i = 1; i <= 5; i++) {
            comb_rank.addItem(i);
        }
        add(comb_rank);

        // Botão de adicionar
        JButton btn_add = new JButton("Adicionar");
        btn_add.setBounds(61, 70, 150, 25);
        btn_add.addActionListener(this::adicionarItem);
        add(btn_add);

        // Área de texto para exibição
        tx_a = new JTextArea();
        tx_a.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tx_a);
        scrollPane.setBounds(10, 110, 414, 140);
        add(scrollPane);

 
    }

    private void adicionarItem(ActionEvent e) {
        String nome = tf_nome.getText().trim();
        Integer rank = (Integer) comb_rank.getSelectedItem();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Adiciona à lista
        String item = nome + " (Rank: " + rank + ")";
        lista.add(item);

        // Atualiza a exibição
        atualizarExibicao();

        // Limpa o campo
        tf_nome.setText("");
    }

    private void mostrarRanks(ActionEvent e) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum item cadastrado ainda!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        atualizarExibicao();
    }

    private void atualizarExibicao() {
        StringBuilder sb = new StringBuilder();
        sb.append("Itens cadastrados (").append(lista.size()).append("):\n\n");
        
        for (String item : lista) {
            sb.append("• ").append(item).append("\n");
        }
        
        tx_a.setText(sb.toString());
    }
}