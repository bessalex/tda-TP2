package KnapsackProblem;


import java.util.ArrayList;

/**
 * Created by alex on 16/11/16.
 */
public class KnapsackReport {
    String format = "%-40s  %s\t\t  %s-%s%n";
    ArrayList<Instance> instances;

    public KnapsackReport(String fileName, ArrayList<Instance> instances) {
        this.instances = instances;
    }


    public void generate(int from, int to){
        if (to >= this.instances.size())
           to = this.instances.size();

        System.out.printf("%-40s%s  %s %n", "Instance Name", "Seconds" ," File-Calc");
        for (int j=from; j<to; j++){
            Instance instance = this.instances.get(j);
            long start = System.currentTimeMillis();
            Knapsack knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(), instance.getItems());
            long finish = System.currentTimeMillis();
            int opt = instance.getOptimum();
            int optCalc = knapsack.getOpt();

            System.out.printf(this.format, instance.getName(), Long.toString(finish - start), opt, optCalc );
            knapsack = null;
            instance = null;
        }
    }



}
