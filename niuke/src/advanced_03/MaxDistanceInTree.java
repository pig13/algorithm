package advanced_03;


public class MaxDistanceInTree {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Data {
        int h;
        int distance;

        public Data(int h, int distance) {
            this.h = h;
            this.distance = distance;
        }
    }


    public static int maxDistance(Node head) {
        return process(head).distance;
//        使用全局变量控制代替结构体(当数据类型统一时)，不习惯用这种方式
//        int[] record = new int[1];
//        return posOrder(head, record);
    }

    public static Data process(Node head) {
        if (head == null) {
            return new Data(0, 0);
        }
        Data leftData = process(head.left);
        Data rightData = process(head.right);
        int includeHeadDistance = leftData.h + rightData.h + 1;
        int resDistance = Math.max(Math.max(leftData.distance, rightData.distance), includeHeadDistance);
        int resH = Math.max(leftData.h, rightData.h) + 1;
        return new Data(resH, resDistance);
    }

    public static int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(maxDistance(head1));

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistance(head2));

    }


}
