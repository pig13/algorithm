package algorithm_greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;

        }
    }

    public static class MinCostcomparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node1.c - node2.c;
        }
    }

    public static class MaxProfitcomparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node2.p - node1.p;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] profit, int[] capital) {
        Node[] head = new Node[profit.length];
        for (int i = 0; i < profit.length; i++) {
            head[i] = new Node(profit[i], capital[i]);
        }
        PriorityQueue<Node> minCostPQ = new PriorityQueue<>(new MinCostcomparator());
        PriorityQueue<Node> maxProfitPQ = new PriorityQueue<>(new MaxProfitcomparator());
        for (int i = 0; i < head.length; i++) {
            minCostPQ.add(head[i]);
        }
        while (k > 0) {
            while (!minCostPQ.isEmpty() && minCostPQ.peek().c <= W) {
                maxProfitPQ.add(minCostPQ.poll());
            }
            if (maxProfitPQ.isEmpty()) {
                return W;
            }
            W += maxProfitPQ.poll().p;
            k--;
        }
        return W;

    }


}
