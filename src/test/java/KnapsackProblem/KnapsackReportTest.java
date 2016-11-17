package KnapsackProblem;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 16/11/16.
 */
public class KnapsackReportTest {

    @Test
    public void generate38_50() throws Exception {
        String format = "%-40s%1.2f \t %s %n";
        String fileName ;
        float seconds;

        for (int i=9; i< 16; i++) {
            fileName = "src/main/resources/knapsack/knapPI_" + i + "_50_1000.csv";
            System.out.println("\n\n\n Filename : " + fileName);
            CsvScanner csv = new CsvScanner(fileName);
            ArrayList<Instance> instances = csv.getInstances();

            if (instances != null) {
                KnapsackReport report = new KnapsackReport(fileName, instances);
                report.generate(37, 50);
            }
        }
    }

    @Test
    public void generate0_37() throws Exception {
        String format = "%-40s%1.2f \t %s %n";
        String fileName ;
        float seconds;

        for (int i=9; i< 16; i++) {
            fileName = "src/main/resources/knapsack/knapPI_" + i + "_50_1000.csv";
            System.out.println("\n\n\n Filename : " + fileName);
            CsvScanner csv = new CsvScanner(fileName);
            ArrayList<Instance> instances = csv.getInstances();

            if (instances != null) {
                KnapsackReport report = new KnapsackReport(fileName, instances);
                report.generate(0, 37);
            }
        }
    }

}