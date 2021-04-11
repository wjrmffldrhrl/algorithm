package solved.P1068_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1068 {

    static class Counter {
        private int count = 0;

        public void count() {
            this.count++;
        }

        public int getCount() {
            return this.count;
        }
    }

    static class Node {
        int name;
        List<Node> children;

        public Node(int name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public void connectWithChild(Node child) {
            this.children.add(child);
        }

        public void countLeaf(Counter counter) {

            if (this.children.size() == 0 && this.name != -1) {
                counter.count();
            } else {
                for (Node child : children) {
                    child.countLeaf(counter);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }


        Node rootNode = new Node(-1);
        String[] parentsList = br.readLine().split(" ");
        for (int i = 0; i < parentsList.length; i++) {

            Node child = nodes.get(i);
            Node parent;
            if (parentsList[i].equals("-1")) {
                parent = rootNode;
            } else {
                parent = nodes.get(Integer.parseInt(parentsList[i]));
            }
            parent.connectWithChild(child);
        }

        int targetNodeNumber = Integer.parseInt(br.readLine());
        Node target = nodes.get(targetNodeNumber);

        Node targetParent = rootNode;
        for (Node node : nodes) {
            if (node.children.contains(target)) {
                targetParent = node;
                break;
            }
        }
        targetParent.children.remove(target);

        Counter counter = new Counter();
        rootNode.countLeaf(counter);


        System.out.println(counter.getCount());


    }
}
