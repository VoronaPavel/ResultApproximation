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
        Subtract((left, right) -> left - right, " - "),
        Empty((left, right) -> left * 10 + right, "");

        private final BiFunction<Integer, Integer, Integer> reducer;
        private final String operator;

        Reducer(BiFunction<Integer, Integer, Integer> reducer, String operator) {
            this.reducer = reducer;
            this.operator = operator;
        }

        Node reduce(Node left, Node right) {
            return new Node(reducer.apply(left.value, right.value), left.representation + operator + right.representation);
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

        public static List<List<Node>> f(List<List<Node>> nodes) {
            if (nodes.get(0).size() == 1) return nodes;

            List<List<Node>> solutions = new ArrayList<>();
            for (List<Node> n: nodes) {
                for (int i = 0; i < n.size(); i++) {
                    solutions.add(reduceLeft(n));
                    reduceRight(n).forEach(c -> solutions.add(c));
                }
            }
            return solutions;
        }

        private static List<List<Node>> reduceRight(List<Node> n) {
            List<Node> subList = n.subList(1, n.size());
            List<Node> wholeList = new ArrayList<>();
            wholeList.add(n.get(0));
            ArrayList<List<Node>> es = new ArrayList<>();
            es.add(subList);
            wholeList.addAll(f(es));
            return wholeList;
        }

        private static List<Node> reduceLeft(List<Node> n) {
            Node l = n.get(0);
            Node r = n.get(1);
            Node reduced = Reducer.Empty.reduce(l, r);
            n.remove(1);
            n.remove(0);
            n.add(0, reduced);
            return n;
        }
    }
}
