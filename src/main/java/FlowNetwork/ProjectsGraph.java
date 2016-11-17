package FlowNetwork;

import FlowNetwork.Graph.Notdigraph;

import java.util.ArrayList;

/**
 * Created by maxi on 16/11/16.
 */
public class ProjectsGraph {

    private Notdigraph graph;
    private Integer nodesCount;

    public ProjectsGraph(String filePath) {
        FileReader fileReader = new FileReader(filePath);
        Integer nodesCount = 2 + fileReader.getnAreas() + fileReader.getmProjects();
        Notdigraph notdigraph = new Notdigraph(nodesCount);
        int nodeNumber = 1;
        for (Project project: fileReader.getProjects()) {
            notdigraph.addEdge(0,nodeNumber,project.getProfit());
            nodeNumber += 1;
        }
        Integer firstArea = nodeNumber;
        for (int i=0; i<fileReader.getnAreas(); i++) {
            notdigraph.addEdge(nodeNumber, nodesCount - 1, fileReader.areasCost.get(i));
            nodeNumber += 1;
        }
        int projectNumber = 1;
        for (Project project: fileReader.getProjects()) {
            for (Integer area: project.getAreasRequired()) {
                notdigraph.addEdge(projectNumber,firstArea+area-1,999999);
            }
            projectNumber += 1;
        }
        this.graph = notdigraph;
        this.nodesCount = nodesCount;
    }

    public ArrayList<Integer> getRentableProjects() {
        FlowNetwork flowNetwork = new FlowNetwork(this.graph);
        flowNetwork.max_flow(0,this.nodesCount-1);
        return flowNetwork.getMinCut();
    }


}
