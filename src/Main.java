import java.util.Arrays;

import javax.swing.SwingUtilities;


public class Main extends Merge{

	 //ArrayList<String> textoNome = new ArrayList<>();

	int capacidadeArray = 1;
	//String[] textoNome = new String[capacidadeArray];
	int[] intRank = new int[capacidadeArray];
	int i = 0;
	
	
    public static void main(String[] args) {
    	
    	
        // int[] actual = { 5, 1, 6, 2, 3, 4 ,18,123,5,6,88,900,234};
        //int[] expected = { 1, 2, 3, 4, 5, 6};
        // Merge.mergeSort(actual, actual.length);
        //assertArrayEquals(expected, actual);
        //System.out.printf(Arrays.toString(actual));
        
        SwingUtilities.invokeLater(() -> {
            Tela2 tela = new Tela2();
            tela.setVisible(true);
        });
    }


 
}















