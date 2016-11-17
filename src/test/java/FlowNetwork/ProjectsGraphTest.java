package FlowNetwork;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by maxi on 17/11/16.
 */
public class ProjectsGraphTest {

    @Test
    public void ProjectsGraphTest() {
        ProjectsGraph projectsGraph = new ProjectsGraph("src/main/resources/example.txt");
        ArrayList<Integer> rentableProjects = projectsGraph.getRentableProjects();
        Assert.assertEquals(rentableProjects.size(), 1);
        Assert.assertEquals(rentableProjects.get(0), Integer.valueOf(2));
    }
}
