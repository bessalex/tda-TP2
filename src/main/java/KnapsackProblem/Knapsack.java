package KnapsackProblem;

import java.util.ArrayList;

/**
 * Created by alex on 12/11/16.
 */
public class Knapsack {
    int maxItems, maxWeight;
    int [][] knapsack;
    ArrayList<Item> items;
    int itemWeight, itemValue;

    public Knapsack(int maxItems, int maxWeight, ArrayList<Item> items){
        this.maxItems = maxItems;
        this.maxWeight = maxWeight;
        this.items = items;

        knapsack = new int[this.maxItems+1][this.maxWeight+1];
        for (int w=0; w <= this.maxWeight; w++) {
            knapsack[0][w] = 0;
        }

        for (int i=1; i <= this.maxItems; i++){
            for (int w=0; w <= this.maxWeight; w++){
                itemWeight = items.get(i-1).getWeight();
                itemValue = items.get(i-1).getValue();
                if (itemWeight <= w){
                    if (knapsack[i-1][w] >= (itemValue + knapsack[i-1][w-itemWeight]))
                        knapsack[i][w] = knapsack[i-1][w];
                    else
                        knapsack[i][w] = itemValue + knapsack[i-1][w-itemWeight];
                }else{
                    knapsack[i][w] = knapsack[i-1][w];
                }
            }
        }
    }


    public int getOpt(){
        return knapsack[this.maxItems][this.maxWeight];
    }


}
