package KnapsackProblem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 10/11/16.
 */
public class CsvScanner {
    Scanner scanner = null;

    ArrayList<Instance> instances;

    public CsvScanner(String filePath) {
        try {
            this.scanner = new Scanner(new File(filePath));
            this.instances = new ArrayList<>();
            Instance instance;
            while ((instance = getInstance()) != null){
                this.instances.add(instance);
            }

        }catch(Exception e){
            this.scanner = null;
            this.instances = null;
        }
    }

    public ArrayList<Instance> getInstances(){
        return this.instances;
    }


    public Instance getnsInstace(int index){
        return this.instances.get(index);
    }


    private Instance getInstance(){
        int maxItems, capacity, optimum;
        float time;
        int number, value, weight, selected;
        String next;

        if (!scanner.hasNext())
            return null;

        scanner.useDelimiter(",| |\n");
        String name = scanner.next();
        next = scanner.next();
        maxItems =  scanner.nextInt(); next = scanner.next();
        capacity = scanner.nextInt(); next = scanner.next();
        optimum = scanner.nextInt(); next = scanner.next();
        next = scanner.next(); time = Float.parseFloat(next);

        Instance instance = new Instance(name, maxItems, capacity, optimum, time);

        //scanner.useDelimiter(",");
        while (scanner.hasNextInt()){
            number = scanner.nextInt();
            value = scanner.nextInt();
            weight = scanner.nextInt();
            selected = scanner.nextInt();
            instance.addItem(value, weight, selected);
        }
        scanner.next();
        scanner.next();

        return instance;
    }
}
