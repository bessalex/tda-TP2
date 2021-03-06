package tspTest;

import org.junit.Test;
import tsp.Pair;
import tsp.TSP;
import tsp.TspScanner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juanall on 12/11/16.
 */
public class TSPTests {

    @Test
    public void tspSimpleCaseTest() {
        Set<Integer> nodes = new HashSet<>();
        //nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);

        Integer[][] matrix = new Integer[4][4];
        matrix[0][0] = 0;
        matrix[1][1] = 0;
        matrix[2][2] = 0;
        matrix[3][3] = 0;

        matrix[1][0] = 10;
        matrix[0][1] = 10;

        matrix[2][0] = 35;
        matrix[0][2] = 35;

        matrix[2][1] = 3;
        matrix[1][2] = 3;

        matrix[3][1] = 2;
        matrix[1][3] = 2;

        matrix[0][3] = 7;
        matrix[3][0] = 7;

        matrix[3][2] = 9;
        matrix[2][3] = 9;

        TSP tsp = new TSP();
        Pair result = tsp.getPathWeight(0,nodes,matrix);
        System.out.println(String.format("Path : %s . Value : %s",result.getPath(),String.valueOf(result.getValue())));

    }


    @Test
    public void tspSimple_s1() {
        int items = 5;

        Set<Integer> nodes = new HashSet<>();
        for (int i=1; i<=items;i++){
            nodes.add(i);
        }


        TspScanner scan = new TspScanner("src/main/resources/tsp/tsp1.txt",items);
        Integer[][] matrix = scan.getMatrix(" |\n");

        TSP tsp = new TSP();
        Pair result = tsp.getPathWeight(0,nodes,matrix);
     //   System.out.println(String.format("Path : %s . Value : %s",result.getPath(),String.valueOf(result.getValue())));
    }
}
