import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 10/11/16.
 */
public class CsvScannerTest {


    @Test
    public void CsvScannerTestPathInvalido() {
        CsvScanner csv = new CsvScanner("PathInvalido");

        ArrayList<Instance> instances = csv.getInstances();

        Assert.assertEquals(instances, null);
        }

    @Test
    public void CsvScannerTestConteoInstancias() {
        CsvScanner csv = new CsvScanner("/home/alex/Workspace/tda/tda-TP2/src/main/resources/knapPI_1_50_1000.csv");

        ArrayList<Instance> instances = csv.getInstances();

        Assert.assertNotEquals(instances, null);

        int count=0;
        for (Instance instance: instances ){
            Assert.assertEquals(instance.getMaxItems(),50);
            count++;
        }
        Assert.assertEquals(count,100);

        instances.clear();

    }

    @Test
    public void CsvScannerTestConteo_Items_por_instancias(){
        CsvScanner csv = new CsvScanner("/home/alex/Workspace/tda/tda-TP2/src/main/resources/knapPI_1_50_1000.csv");

        ArrayList<Instance> instances = csv.getInstances();
        Assert.assertNotEquals(instances, null);

        for (Instance instance: instances ){
            ArrayList<Item> items = instance.getItems();
            Assert.assertEquals(items.size(), 50);
            items.clear();
        }

        instances.clear();
    }
}