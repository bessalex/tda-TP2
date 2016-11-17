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

    /*
    @Test
    public void generateReporter() throws Exception {
        String format = "%-40s%1.2f \t %s %n";
        String fileName ;
        float seconds;

        for (int i=9; i< 10; i++) {
            fileName = "src/main/resources/knapsack/knapPI_" + i + "_50_1000.csv";
            System.out.println("\n\n\n Filename : " + fileName);
            CsvScanner csv = new CsvScanner(fileName);
            ArrayList<Instance> instances = csv.getInstances();

            if (instances != null) {
                System.out.printf("%-40s%s \t %s %n", "Instance Name", "Seconds" ,"NanoSeconds");
                //for (Instance instance : instances) {
                 for (int j=37; j<50; j++){
                    long start = System.nanoTime();
                    Instance instance = instances.get(j);
                    Knapsack knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(), instance.getItems());
                    long finish = System.nanoTime();
                    int opt = instance.getOptimum();
                    int optCalc = knapsack.getOpt();
                    Assert.assertEquals(optCalc, opt);
                    seconds = (finish - start) / 1000000000;
                    System.out.printf(format, instance.getName(),seconds, Long.toString(finish - start) );
                    knapsack = null;
                     instance = null;
                }
            }
        }
    }
    */
}