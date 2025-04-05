import java.awt.*;
import java.util.Arrays;

import org.junit.Test;

public class Main extends Merge{

    public static void main(String[] args) {


        int[] actual = { 5, 1, 6, 2, 3, 4 ,18,123,5,6,88,900,234};
        //int[] expected = { 1, 2, 3, 4, 5, 6};
        Merge.mergeSort(actual, actual.length);
        //assertArrayEquals(expected, actual);
        System.out.printf(Arrays.toString(actual));
    }

}















