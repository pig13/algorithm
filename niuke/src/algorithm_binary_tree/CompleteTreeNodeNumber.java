package algorithm_binary_tree;

public class CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }


    public static int bs(Node node, int left, int height) {
        // left 当前节点的高度
        // height 整棵树的高度
        if (left == height) {
            return 1;
        }
        if (mostLeftLevel(node.right, left + 1) == height) {
            return (1 << (height - left)) + bs(node.right, left + 1, height);
        } else {
            return (1 << (height - left - 1)) + bs(node.left, left + 1, height);

        }

    }

    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
