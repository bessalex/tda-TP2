package FlowNetwork.Graph;

/**
 * Created by maxi on 15/11/16.
 */
public class Edge {
    private Integer targetNode;
    private Integer weight;
    private Integer flow;
    private Edge redge;

    public Edge(Integer targetNode, Integer weight) {
        this.targetNode = targetNode;
        this.weight = weight;
        this.flow = 0;
    }

    public Integer getTargetNode() {
        return this.targetNode;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public Integer getFlow() {
        return this.flow;
    }

    public void setFlow(Integer newFlow) {
        this.flow = newFlow;
    }

    public void setRedge(Edge redge) {
        this.redge = redge;
    }

    public Edge getRedge(){
        return this.redge;
    }
}