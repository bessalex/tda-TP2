import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alex on 12/11/16.
 */
public class KnapsackTest {
    @Test
    public void getOpt() throws Exception {
        CsvScanner csv = new CsvScanner("src/main/resources/knapTest.csv");
        Instance instance = csv.getnsInstace(0);

        Knapsack knapsack = new Knapsack(instance.getMaxItems(), instance.getCapacity(),instance.getItems());

        Assert.assertEquals(knapsack.getOpt(), 9);
    }

}