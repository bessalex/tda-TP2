package FlowNetwork;

import FlowNetwork.Graph.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by maxi on 15/11/16.
 */
public class FlowNetwork {

    protected ArrayList<ArrayList<Integer>> flow;
    protected Graph graph;
    protected ArrayList<Integer> minCut;

    public FlowNetwork(Graph graph) {
        this.flow = new ArrayList<ArrayList<Integer>>();
        this.graph = graph;
    }

    public ArrayList<Edge> find_path (Integer source, Integer sink, ArrayList<Edge> path) {

        if (source == sink) {
            return path;
        }
        ArrayList<Edge> result = new ArrayList<Edge>();
        ArrayList<Edge> edges = this.graph.adj_e(source);
        for (int i = 0; i<edges.size(); i++) {
            Edge edge = edges.get(i);
            Integer residual = edge.getWeight() - edge.getFlow();
            if (residual > 0 && (!path.contains(edge))) {
                ArrayList<Edge> pathCopy = new ArrayList<Edge>();

                for (int o=0; o<path.size(); o++) {
                    Edge edgeY = path.get(o);
                    pathCopy.add(edgeY);
                }

                pathCopy.add(edge);
                result = find_path(edge.getTargetNode(), sink, pathCopy);
                if (result.size() > 0) {
                    return result;
                }
            }
        }
        return new ArrayList<Edge>();
    }

    public Integer max_flow(Integer source, Integer sink) {
        ArrayList<Edge> path = find_path(source, sink, new ArrayList<Edge>());
        while (path.size() > 0) {
            ArrayList<Integer> residuals = new ArrayList<Integer>();
            for (int i=0; i<path.size(); i++) {
                Edge edge = path.get(i);
                residuals.add(edge.getWeight() - edge.getFlow());
            }

            //Get min of residuals
            int min = residuals.get(0);
            int index = 0;
            for(int j=0;j<residuals.size();j++) {
                if(residuals.get(j) < min) {
                    min = residuals.get(j);
                    index = j;
                }
            }
            Integer flow_amount = residuals.get(index);
            for (Edge e: path) {
                e.setFlow(e.getFlow() + flow_amount);
                e.getRedge().setFlow(e.getRedge().getFlow() - flow_amount);
            }
            path = find_path(source, sink, new ArrayList<Edge>());

        }
        Integer result = 0;
        for (Edge theEdge: this.graph.adj_e(source)) {
            result += theEdge.getFlow();
        }
        this.calculateMinCut(source);
        return result;
    }

    public void calculateMinCut(Integer source) {
        ArrayList<Integer> minimalCut = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        Node node = graph.getNode(source);
        node.visited();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (Edge edge : node.getEdges()) {
                if((edge.getWeight() -edge.getFlow()) > 0) {
                    Node currentNode = graph.getNode(edge.getTargetNode());
                    if (currentNode.getState() == State.NOTVISITED) {
                        minimalCut.add(currentNode.getId());
                        currentNode.visited();
                        queue.add(currentNode);
                    }
                }

            }
        }
        System.out.println(minimalCut);
        this.minCut = minimalCut;
    }

    public ArrayList<Integer> getMinCut() {
        return this.minCut;
    }
}
