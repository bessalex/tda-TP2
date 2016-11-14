package KnapsackProblem;

import java.util.ArrayList;

/**
 * Created by alex on 10/11/16.
 */
public class Instance {

    protected String name;
    protected int maxItems;
    protected int capacity;
    protected int optimum;
    protected float time;

    ArrayList<Item> items;


    public Instance(String name, int maxItems, int capacity){
        this.name = new String(name);
        this.maxItems = maxItems;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public Instance(String name, int maxItems, int capacity, int optimum, float time){
        this.name = new String(name);
        this.maxItems = maxItems;
        this.capacity = capacity;
        this.optimum = optimum;
        this.time = time;
        this.items = new ArrayList<>();
    }


    public void addItem(int value, int weight, int selected){
        this.items.add(new Item(value,weight,selected));

    }

    public Item getItem(int index){
        return this.items.get(index);
    }

    public ArrayList<Item>  getItems(){
        return this.items;
    }

    public String getName() {
        return name;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOptimum() {
        return optimum;
    }

    public float getTime() {
        return time;
    }
}