package advanced_01;

public class MorrisTraversal {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            } else {
                Node mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.print(cur.value + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    cur = cur.right;
                    mostRight.right = null;
                }
            }
        }
        System.out.println();
    }

    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            } else {
                Node mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                    mostRight.right = null;
                }
            }
        }
        System.out.println();
    }

    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                Node mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    printRightEdge(cur.left);
                    cur = cur.right;
                }
            }
        }
        printRightEdge(head);
    }

    private static void printRightEdge(Node head) {
        if (head == null) {
            return;
        }
        //reverse the right edge
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        //print
        cur = pre;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        //recover
        cur = pre;
        pre = null;
        while (cur != null) {
            Node next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        morrisPre(root);
        morrisIn(root);
        morrisPos(root);
    }

}
