import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela2 tela = new Tela2();
            tela.setVisible(true);
        });
    }
}
