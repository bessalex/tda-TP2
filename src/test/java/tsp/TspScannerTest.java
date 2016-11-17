package tsp;

import org.junit.Test;

/**
 * Created by alex on 17/11/16.
 */
public class TspScannerTest {
    @Test
    public void getMatrix() throws Exception {

        int nodes = 14;
        TspScanner scan = new TspScanner("src/main/resources/tsp/tsp1.txt",nodes);

        Integer[][] matrix = scan.getMatrix(" |\n");

        for (int i=0; i <= nodes; i++){
            for (int j=0; j <= nodes; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }



    @Test
    public void getSolution() throws Exception {
        int nodes = 14;
        TspScanner scan = new TspScanner("src/main/resources/tsp/p01_s.txt",nodes);

        Integer[] values = scan.getSolution("\n");

        for (int i=0; i <= nodes+1; i++){
            System.out.print(values[i] + " ");
        }
        System.out.println(" ");
    }

}