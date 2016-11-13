package tsp;

/**
 * Created by juanall on 13/11/16.
 */
public class Pair {
    private String path ;
    private Integer value;

    public Pair(String path, Integer value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public Integer getValue() {
        return value;
    }
}
