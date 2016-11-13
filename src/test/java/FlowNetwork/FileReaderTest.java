package FlowNetwork;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by maxi on 13/11/16.
 */
public class FileReaderTest {


    @Test
    public void FileReaderMProjectsTest() {
        FileReader fileReader = new FileReader("src/main/resources/example.txt");
        Assert.assertEquals(fileReader.getmProjects(),Integer.valueOf(2));
    }

    @Test
    public void FileReaderNAreasTest() {
        FileReader fileReader = new FileReader("src/main/resources/example.txt");
        Assert.assertEquals(fileReader.getnAreas(),Integer.valueOf(3));
    }

    @Test
    public void FileReaderAreasCostTest() {
        FileReader fileReader = new FileReader("src/main/resources/example.txt");
        Assert.assertEquals(fileReader.getAreasCosts().get(0),Integer.valueOf(16));
        Assert.assertEquals(fileReader.getAreasCosts().get(1), Integer.valueOf(13));
        Assert.assertEquals(fileReader.getAreasCosts().get(2),Integer.valueOf(9));
    }

    @Test
    public void FileReaderProjectsTest() {
        FileReader fileReader = new FileReader("src/main/resources/example.txt");
        Assert.assertEquals(fileReader.getProjects().get(0).getProfit(),Integer.valueOf(20));
        Assert.assertEquals(fileReader.getProjects().get(0).getAreasRequired().get(0),Integer.valueOf(1));
        Assert.assertEquals(fileReader.getProjects().get(0).getAreasRequired().get(1),Integer.valueOf(2));
        Assert.assertEquals(fileReader.getProjects().get(1).getProfit(),Integer.valueOf(10));
        Assert.assertEquals(fileReader.getProjects().get(1).getAreasRequired().get(0),Integer.valueOf(3));
    }
}
