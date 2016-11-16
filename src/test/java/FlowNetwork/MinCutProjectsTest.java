package FlowNetwork;

import FlowNetwork.Graph.Notdigraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by maxi on 16/11/16.
 */
public class MinCutProjectsTest {

    @Test
    public void MinCutProjectsTest() {
        Notdigraph notdigraph = new Notdigraph(7);
        notdigraph.addEdge(0,1,20);
        notdigraph.addEdge(0,2,10);
        notdigraph.addEdge(1,3,999999);
        notdigraph.addEdge(1,4,999999);
        notdigraph.addEdge(2,5,999999);
        notdigraph.addEdge(3,6,16);
        notdigraph.addEdge(4,6,13);
        notdigraph.addEdge(5,6,9);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        flowNetwork.max_flow(0,6);
        Assert.assertEquals(flowNetwork.getMinCut().size(), 1);
        Assert.assertEquals(flowNetwork.getMinCut().get(0), Integer.valueOf(2));
    }

    @Test
    public void MinCutProjectsTest2() {
        Notdigraph notdigraph = new Notdigraph(8);
        notdigraph.addEdge(0,2,10);
        notdigraph.addEdge(0,1,20);
        notdigraph.addEdge(0,7,11);
        notdigraph.addEdge(7,3,999999);
        notdigraph.addEdge(2,5,999999);
        notdigraph.addEdge(1,3,999999);
        notdigraph.addEdge(1,4,999999);
        notdigraph.addEdge(1,5,999999);
        notdigraph.addEdge(3,6,16);
        notdigraph.addEdge(4,6,13);
        notdigraph.addEdge(5,6,9);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        flowNetwork.max_flow(0,6);
        Assert.assertEquals(flowNetwork.getMinCut().size(), 3);
    }

    @Test
    public void MinCutProjectsTest3() {
        Notdigraph notdigraph = new Notdigraph(5);
        notdigraph.addEdge(0,1,5);
        notdigraph.addEdge(0,2,100000);
        notdigraph.addEdge(1,3,999999);
        notdigraph.addEdge(2,3,999999);
        notdigraph.addEdge(3,4,5);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        flowNetwork.max_flow(0,4);
        Assert.assertEquals(flowNetwork.getMinCut().size(), 2);
    }

    @Test
    public void MinCutProjectsTest4() {
        Notdigraph notdigraph = new Notdigraph(5);
        notdigraph.addEdge(0,1,5);
        notdigraph.addEdge(0,2,1);
        notdigraph.addEdge(1,3,999999);
        notdigraph.addEdge(2,3,999999);
        notdigraph.addEdge(3,4,5);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        flowNetwork.max_flow(0,4);
        Assert.assertEquals(flowNetwork.getMinCut().size(), 2);
    }

    @Test
    public void MinCutProjectsTest5() {
        Notdigraph notdigraph = new Notdigraph(5);
        notdigraph.addEdge(0,1,3);
        notdigraph.addEdge(0,2,1);
        notdigraph.addEdge(1,3,999999);
        notdigraph.addEdge(2,3,999999);
        notdigraph.addEdge(3,4,5);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        flowNetwork.max_flow(0, 4);
        Assert.assertEquals(flowNetwork.getMinCut().size(), 0);
    }
}
