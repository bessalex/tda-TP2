package tsp;

import java.util.HashSet;
import java.util.Set;

public class TSP {

    private static final Integer integer = 0;

    public final Pair getPathWeight(Integer source, Set<Integer> nodes, Integer[][] matrix) {
        if (nodes.isEmpty()) {
            System.out.println(source);
            return new Pair(String.format("(%s,0)", String.valueOf(source)),matrix[source][0]);
        }
        Set<Pair> solutions = new HashSet<>();
        for (Integer node : nodes) {
            Set<Integer> copy = copySet(nodes,node);
            Pair pair = getPathWeight(node,copy,matrix);
            Integer value = matrix[source][node] + pair.getValue();
            solutions.add(new Pair(String.format("(%s,%s) + %s",String.valueOf(source),String.valueOf(node),pair.getPath()),value));
        }
        return getMin(solutions);
    }

    public Pair getMin(Set<Pair> values) {
        Pair min = new Pair("",1000000);
        for (Pair pair : values) {
            if (pair.getValue() < min.getValue()) {
                min = pair;
            }
        }
        return min;
    }

    public Set<Integer> copySet(Set<Integer> set, Integer toDelete) {
        Set<Integer> copySet = new HashSet<>();
        copySet.addAll(set);
        copySet.remove(toDelete);
        return copySet;
    }

}
