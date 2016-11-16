package FlowNetwork.Graph;

/**
 * Created by maxi on 15/11/16.
 */
public class Digraph extends Graph {
    public Digraph(Integer totalNodes) {
        super(totalNodes);
    }

    public void addEdge(Integer source, Integer target, Integer weight) {
        this.nodes.get(source).addEdge(target,weight);
    }

}