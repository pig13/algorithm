package algorithm_graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;
    public int out;
    // 邻居节点
    public ArrayList<Node> nexts;
    // 邻居边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
