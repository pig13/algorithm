package demo;

import java.util.Stack;

public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }
        System.out.println();

    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            Stack<Node> tmp = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                tmp.push(head);
                if (head.left != null) {
                    stack.add(head.left);
                }
                if (head.right != null) {
                    stack.add(head.right);
                }
            }
            while (!tmp.isEmpty()) {
                System.out.print(tmp.pop().value + " ");
            }
        }
        System.out.println();

    }

    public static void posOrderUnRecur2(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node stackTop = null;
            while (!stack.isEmpty()) {
                stackTop = stack.peek();
                if (stackTop.left != null && head != stackTop.left && head != stackTop.right) {
                    // head != stackTop.left && head != stackTop.right 表示左右孩子都没被打印过，如果只有head != stackTop.left 那么在这里就会陷入循环
                    stack.push(stackTop.left);//说明c的左右子树还没打印完毕，此时c左节点可以入栈
                } else if (stackTop.right != null && head != stackTop.right) {
                    stack.push(stackTop.right);//说明c的右子树还没有处理过，次数c的右节点入栈
                } else {
                    // 左右孩子都被打印过了，父节点出栈打印
                    System.out.print(stack.pop().value + " ");
                    head = stackTop;
                    // head 代表上一次打印的节点
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }


}
