import java.awt.Component;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Tela2 extends JFrame {
    private JTextField tf_nome;
    private JTextArea tx_a;
    private JComboBox<Integer> comb_rank;
    protected List<String> lista = new ArrayList<>();

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
        this.initialize();
    }

    public void initialize() {
        this.setTitle("Tela de Cadastro");
        this.setSize(450, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo((Component) null);
        this.getContentPane().setLayout((LayoutManager) null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 50, 20);
        this.add(lblNome);

        tf_nome = new JTextField();
        tf_nome.setBounds(61, 11, 150, 20);
        this.add(tf_nome);

        JLabel lblRank = new JLabel("Rank:");
        lblRank.setBounds(10, 41, 50, 20);
        this.add(lblRank);

        comb_rank = new JComboBox<>();
        comb_rank.setBounds(61, 41, 80, 22);
        for (int i = 1; i <= 5; i++) {
            comb_rank.addItem(i);
        }
        this.add(comb_rank);

        JButton btn_add = new JButton("Adicionar");
        btn_add.setBounds(61, 70, 150, 25);
        btn_add.addActionListener(this::adicionarItem);
        this.add(btn_add);

        JButton btn_ordenar = new JButton("Ordenar por Rank");
        btn_ordenar.setBounds(220, 70, 150, 25);
        btn_ordenar.addActionListener(this::ordenarPorRank);
        this.add(btn_ordenar);

        tx_a = new JTextArea();
        tx_a.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tx_a);
        scrollPane.setBounds(10, 110, 414, 140);
        this.add(scrollPane);
    }

    private void adicionarItem(ActionEvent e) {
        String nome = tf_nome.getText().trim();
        Integer rank = (Integer) comb_rank.getSelectedItem();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            String item = nome + " (Rank: " + rank + ")";
            lista.add(item);
            atualizarExibicao();
            tf_nome.setText("");
        }
    }

    private void ordenarPorRank(ActionEvent e) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum item para ordenar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        int[] ranks = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            String item = lista.get(i);
            String rankStr = item.substring(item.indexOf("Rank: ") + 6, item.indexOf(")"));
            ranks[i] = Integer.parseInt(rankStr);
        }

        
        Merge.mergeSort(ranks, ranks.length);

        
        List<String> novaLista = new ArrayList<>();
        for (int rank : ranks) {
            for (int j = 0; j < lista.size(); j++) {
                String item = lista.get(j);
                if (item.contains("Rank: " + rank)) {
                    novaLista.add(item);
                    lista.set(j, ""); // marca como usado
                    break;
                }
            }
        }

        
        lista = novaLista;
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
