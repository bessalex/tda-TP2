package KnapsackProblem;

/**
 * Created by alex on 10/11/16.
 */
public class Item {

    protected int value;
    protected int weight;
    protected int selected;


    public Item(int value, int weight, int selected){
        this.value = value;
        this.weight = weight;
        this.selected = selected;
    }

    public Item(int value, int weight){
        this.value = value;
        this.weight = weight;
        this.selected = 0;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}