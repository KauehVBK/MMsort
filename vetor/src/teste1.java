import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class teste1 {

    private JFrame frame;
    private JTextField tf_nome;
    private JTextField tf_rank;
    private List<Jogador> jogadores = new ArrayList<>();
    private int proximoRank = 1;

    class Jogador {
        String nome;
        int rank;
        
        public Jogador(String nome, int rank) {
            this.nome = nome;
            this.rank = rank;
        }
        
        @Override
        public String toString() {
            return "Rank " + rank + ": " + nome;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    teste1 window = new teste1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public teste1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300); // Aumentei a altura para melhor visualização
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nome do jogador");
        lblNewLabel.setBounds(10, 11, 117, 14);
        frame.getContentPane().add(lblNewLabel);
        
        tf_nome = new JTextField();
        tf_nome.setBounds(98, 8, 86, 20);
        frame.getContentPane().add(tf_nome);
        tf_nome.setColumns(10);
        
        tf_nome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inserirJogador();
            }
        });
        
        JLabel lblRank = new JLabel("Colocação");
        lblRank.setBounds(10, 31, 78, 14);
        frame.getContentPane().add(lblRank);
        
        tf_rank = new JTextField();
        tf_rank.setColumns(10);
        tf_rank.setBounds(98, 28, 86, 20);
        tf_rank.setEditable(false);
        tf_rank.setText(String.valueOf(proximoRank));
        frame.getContentPane().add(tf_rank);
        
        JButton btn_add = new JButton("Inserir");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inserirJogador();
            }
        });
        btn_add.setBounds(10, 56, 174, 23);
        frame.getContentPane().add(btn_add);
        
        JPanel panel = new JPanel();
        panel.setBounds(214, 0, 220, 261);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        // Cria o JScrollPane envolvendo o JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 70, 200, 180); // Aumentei a altura
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);
        
        JLabel lblNewLabel_1 = new JLabel("Ranking");
        lblNewLabel_1.setBounds(10, 11, 130, 23);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
        JButton btn_ver = new JButton("Listar ranks");
        btn_ver.setBounds(10, 36, 89, 23);
        panel.add(btn_ver);
        btn_ver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                
                if(jogadores.isEmpty()) {
                    textArea.setText("Nenhum jogador cadastrado.");
                    return;
                }
                
                jogadores.sort((j1, j2) -> Integer.compare(j1.rank, j2.rank));
                
                for(Jogador jogador : jogadores) {
                    textArea.append(jogador.toString() + "\n");
                }
                
                // Rolagem automática para o final
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        });
    }

    private void inserirJogador() {
        String nome = tf_nome.getText();
                
        if(nome.isEmpty()) {
            return;
        }
        
        jogadores.add(new Jogador(nome, proximoRank));
        proximoRank++;
        tf_rank.setText(String.valueOf(proximoRank));
        
        tf_nome.setText("");
        tf_nome.requestFocus();
    }
}