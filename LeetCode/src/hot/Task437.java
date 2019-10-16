package hot;

import java.util.HashMap;

public class Task437 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return process(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }


        public int process(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            sum -= root.val;
            return (sum == 0 ? 1 : 0) + process(root.left, sum) + process(root.right, sum);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);


        int res = new Solution().pathSum(root, 8);
        System.out.println(res);


    }
}
