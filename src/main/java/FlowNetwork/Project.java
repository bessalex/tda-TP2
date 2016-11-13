package FlowNetwork;

import java.util.ArrayList;

/**
 * Created by maxi on 13/11/16.
 */
public class Project {

    protected Integer profit;
    protected ArrayList<Integer> areasRequired;

    public Project(Integer profit, ArrayList<Integer> areasRequired){
        this.profit = profit;
        this.areasRequired = areasRequired;
    }

    public Integer getProfit(){
        return profit;
    }

    public ArrayList<Integer> getAreasRequired(){
        return areasRequired;
    }
}
