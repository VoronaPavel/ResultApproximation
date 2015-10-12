import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Problem1 {

    static class Node {

        public final int value;
        public final String representation;

        private Node(int value, String representation) {
            this.value = value;
            this.representation = representation;
        }

        @Override public String toString() {
            return "Node{value=" + value + ", representation=" + representation + "}";
        }

        public static Node create(int value) {
            return new Node(value, String.valueOf(value));
        }
    }

    enum Reducer {

        Add((left, right) -> left + right, " + "),
        Subtract((left, right) -> left - right, " - ");

        private final BiFunction<Integer, Integer, Integer> reducer;
        private final String operator;

        Reducer(BiFunction<Integer, Integer, Integer> reducer, String operator) {
            this.reducer = reducer;
            this.operator = operator;
        }

        Node reduce(Node left, Node right) {
            return new Node(reducer.apply(left.value, right.value),
                    left.representation + operator + right.representation);
        }
    }

    public static class Calculator {

        public static List<List<Node>> calculate(List<List<Node>> nodes) {
            if (nodes.get(0).size() == 1) return nodes;

            List<List<Node>> solutions = new ArrayList<>();
            for (List<Node> n : nodes) {
                for (Reducer reducer : Reducer.values()) {
                    List<Node> newNodes = new ArrayList<>(n);
                    Node reducedNode = reducer.reduce(newNodes.get(0), newNodes.get(1));
                    newNodes.remove(1);
                    newNodes.remove(0);
                    newNodes.add(0, reducedNode);
                    solutions.add(newNodes);
                }
            }
            return calculate(solutions);
        }

    }
}
