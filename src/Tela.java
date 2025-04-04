/*
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class Tela extends Main {


	
	private JFrame frmTela;
	private JTextField tf_nome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frmTela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Tela() {
		initialize();
	}


	private void initialize() {
		frmTela = new JFrame();
		frmTela.setTitle("Tela");
		frmTela.setBounds(100, 100, 450, 300);
		frmTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTela.getContentPane().setLayout(null);
		
		JComboBox<Integer> comb_rank = new JComboBox<Integer>();
		comb_rank.setMaximumRowCount(5);
		comb_rank.setBounds(61, 36, 86, 22);
		frmTela.getContentPane().add(comb_rank);
		comb_rank.addItem(1);
		comb_rank.addItem(2);
		comb_rank.addItem(3);
		comb_rank.addItem(4);
		comb_rank.addItem(5);
		
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 63, 14);
		frmTela.getContentPane().add(lblNewLabel);
		
		tf_nome = new JTextField();
		tf_nome.setBounds(61, 8, 86, 20);
		frmTela.getContentPane().add(tf_nome);
		tf_nome.setColumns(10);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setBounds(10, 41, 63, 14);
		frmTela.getContentPane().add(lblRank);
		
		JButton btn_add = new JButton("Adicionar");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
			    // 1. Pegar o texto do campo
                String texto = tf_nome.getText().trim();
                
                // 2. Validar se não está vazio
                if (texto.isEmpty()) {
                    JOptionPane.showMessageDialog(frmTela, "Digite algo antes de adicionar!");
                    return;
                }
                
                // 3. Adicionar ao ArrayList (cresce dinamicamente)
                lista.add(texto);
                
                // 4. Atualizar a exibição
                StringBuilder sb = new StringBuilder();
                sb.append("Itens no ArrayList (Tamanho: " + lista.size() + "):\n");
                for (String item : lista) {
                    sb.append("- ").append(item).append("\n");
                }
                tf_nome.setText(sb.toString());
                
                // 5. Limpar o campo
                tf_nome.setText("");
                
                // 6. Opcional: mostrar mensagem de sucesso
                System.out.println("Texto adicionado: " + texto);
			}
            }
		);
		btn_add.setBounds(83, 70, 89, 23);
		frmTela.getContentPane().add(btn_add);
		
		JTextArea tx_a = new JTextArea();
		tx_a.setEditable(false);
		tx_a.setBounds(10, 111, 414, 139);
		frmTela.getContentPane().add(tx_a);
		
		JLabel lblNewLabel_1 = new JLabel("Ver ranks");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(250, 8, 120, 49);
		frmTela.getContentPane().add(lblNewLabel_1);
		
		JButton btn_ver = new JButton("");
		btn_ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//ArrayList<String>lista = new ArrayList<String>();
			//lista.add("teste");
			//lista.add("teste2");
			//textArea.setText("asd\nawqe");
			
			tx_a.setText(tx_a.getText()+"\n"+"abc");
			}
		});
		btn_ver.setBounds(260, 56, 89, 23);
		frmTela.getContentPane().add(btn_ver);
		
	
		
			}
}
*/
