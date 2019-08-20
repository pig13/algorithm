package advanced_03;

public class IsBalancedTree {

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }


    public static class Data {
        int level;
        boolean isB;

        Data(int level, boolean isB) {
            this.level = level;
            this.isB = isB;
        }

    }

    public static Data process(Node head, int level) {
        if (head == null) {
            return new Data(level, true);
        }
        Data leftData = process(head.left, level + 1);
        if (!leftData.isB) {
            return new Data(level, false);
        }
        Data rightData = process(head.right, level + 1);
        if (!rightData.isB) {
            return new Data(level, false);
        }
        if (Math.abs(leftData.level - rightData.level) > 1) {
            return new Data(level, false);
        }
        return new Data(Math.max(leftData.level, rightData.level), true);


    }


    public static boolean isBalanced(Node head) {
        return process(head, 1).isB;

    }


}
