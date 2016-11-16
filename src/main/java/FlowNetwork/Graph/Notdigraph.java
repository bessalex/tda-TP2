package FlowNetwork.Graph;

/**
 * Created by maxi on 15/11/16.
 */
public class Notdigraph extends Graph{

    public Notdigraph(Integer totalNodes) {
        super(totalNodes);
    }

    public void addEdge(Integer source, Integer target, Integer weight) {
        Edge edge = nodes.get(source).addEdge(target,weight);
        Edge redge = nodes.get(target).addEdge(source,0);
        edge.setRedge(redge);
        redge.setRedge(edge);
    }
}