package FlowNetwork;

import FlowNetwork.Graph.Notdigraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by maxi on 15/11/16.
 */
public class FlowNetworkTest {

    @Test
    public void FordFulkTest() {
        Notdigraph notdigraph = new Notdigraph(6);
        notdigraph.addEdge(0,1,3);
        notdigraph.addEdge(0,2,3);
        notdigraph.addEdge(1,2,2);
        notdigraph.addEdge(1,3,3);
        notdigraph.addEdge(2,4,2);
        notdigraph.addEdge(4,5,3);
        notdigraph.addEdge(3,4,4);
        notdigraph.addEdge(3,5,2);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        Assert.assertEquals(flowNetwork.max_flow(0,5),Integer.valueOf(5));
    }

    @Test
    public void FordFulkTest2() {
        Notdigraph notdigraph = new Notdigraph(6);
        notdigraph.addEdge(0,1,11);
        notdigraph.addEdge(0,2,12);
        notdigraph.addEdge(2,1,1);
        notdigraph.addEdge(1,3,12);
        notdigraph.addEdge(2,4,11);
        notdigraph.addEdge(4,5,4);
        notdigraph.addEdge(4,3,7);
        notdigraph.addEdge(3,5,19);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        Assert.assertEquals(flowNetwork.max_flow(0,5),Integer.valueOf(23));
    }

    @Test
    public void FordFulkTest3() {
        Notdigraph notdigraph = new Notdigraph(6);
        notdigraph.addEdge(0,1,2);
        notdigraph.addEdge(0,2,2);
        notdigraph.addEdge(2,1,2);
        notdigraph.addEdge(1,3,2);
        notdigraph.addEdge(2,4,2);
        notdigraph.addEdge(4,5,2);
        notdigraph.addEdge(4,3,3);
        notdigraph.addEdge(3,5,3);

        FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
        Assert.assertEquals(flowNetwork.max_flow(0,5),Integer.valueOf(4));
    }

    //@Test
    //public void FordFulkTest4() {
    //    Notdigraph notdigraph = new Notdigraph(7);
    //    notdigraph.addEdge(0,1,20);
    //    notdigraph.addEdge(0,2,10);
    //    notdigraph.addEdge(1,3,0);
     //   notdigraph.addEdge(1,4,0);
      //  notdigraph.addEdge(2,5,0);
       // notdigraph.addEdge(3,6,16);
        //notdigraph.addEdge(4,6,13);
        //notdigraph.addEdge(5,6,9);

  //      FlowNetwork flowNetwork = new FlowNetwork(notdigraph);
    //    Assert.assertEquals(flowNetwork.max_flow(0,6),Integer.valueOf(4));
    //}
}
