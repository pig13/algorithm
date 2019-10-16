package offer;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class reConstructBinaryTree {

    public class Solution {
            public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


        // 題解 https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6?answerType=1&f=discussion
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            if (pre == null || in == null || pre.length == 0 || in.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(pre[0]);
            // 在中序中找到前序的根
            for (int i = 0; i < in.length; i++) {
                if (in[i] == pre[0]) {
                    // 左子树，注意 copyOfRange 函数，左闭右开
                    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                    // 右子树，注意 copyOfRange 函数，左闭右开
                    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                    break;
                }
            }
            return root;
        }

    }
}
