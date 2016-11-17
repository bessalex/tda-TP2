package KnapsackProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 12/11/16.
 */
public class KnapsackTest {
    @Test
    public void getOpt() throws Exception {
        CsvScanner csv = new CsvScanner("src/main/resources/knapTest.csv");
        Instance instance = csv.getnsInstace(0);

        Knapsack knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(),instance.getItems());

        Assert.assertEquals(knapsack.getOpt(), 9);
    }

    @Test
    public void getOptSmall() throws Exception {
        CsvScanner csv = new CsvScanner("src/main/resources/knapsack/knapPI_1_50_1000.csv");

        ArrayList<Instance> instances = csv.getInstances();

        Knapsack knapsack;
        for (Instance instance: instances ){
            knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(),instance.getItems());
            int opt = instance.getOptimum();
            int optCalc = knapsack.getOpt();
            Assert.assertEquals(optCalc, opt);
        }
    }


}