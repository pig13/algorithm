package hot;

import java.util.*;

public class Task538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static Set<Integer> set = new HashSet<Integer>();
    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();


    public static TreeNode convertBST(TreeNode root) {
        // [2,1]  [2,1,3] 线上代码不过 https://leetcode-cn.com/problems/convert-bst-to-greater-tree/submissions/
        if (root == null) {
            return null;
        }
        func(root);
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        Arrays.sort(arr);
        int[] posArr = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            posArr[i] = posArr[i + 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], posArr[i]);
        }
        func2(root);
        return root;

    }

    public static void func2(TreeNode root) {
        // 遍历一遍，那数据
        if (root == null) {
            return;
        }
        root.val = map.get(root.val);
        func2(root.left);
        func2(root.right);
    }


    public static void func(TreeNode root) {
        // 再次遍历，更新数据
        if (root == null) {
            return;
        }
        set.add(root.val);
        func(root.left);
        func(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        convertBST(root);
        System.out.println();

    }

}
