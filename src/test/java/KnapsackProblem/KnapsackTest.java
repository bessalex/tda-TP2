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
        CsvScanner csv = new CsvScanner("src/main/resources/knapPI_1_50_1000.csv");

        ArrayList<Instance> instances = csv.getInstances();

        Knapsack knapsack;
        for (Instance instance: instances ){
            knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(),instance.getItems());
            int opt = instance.getOptimum();
            int optCalc = knapsack.getOpt();
            Assert.assertEquals(optCalc, opt);
        }
    }

    @Test
    public void generateReporter() throws Exception {
        String format = "%-40s%s%n";
        CsvScanner csv = new CsvScanner("src/main/resources/knapPI_1_50_1000.csv");

        ArrayList<Instance> instances = csv.getInstances();

        Knapsack knapsack;

        System.out.printf(format,"Instance Name","Time (NanoSec)");
        for (Instance instance: instances ){
            long start = System.nanoTime();
            knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(),instance.getItems());
            long finish = System.nanoTime();
            int opt = instance.getOptimum();
            int optCalc = knapsack.getOpt();
            Assert.assertEquals(optCalc, opt);
            System.out.printf(format,instance.getName(), Long.toString(finish - start));
        }
    }
}