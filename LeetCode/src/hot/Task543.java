package hot;


public class Task543 {


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //max 记录当前的最大直径
        max = Math.max(leftDepth + rightDepth, max);
        //返回当前树的高度
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
