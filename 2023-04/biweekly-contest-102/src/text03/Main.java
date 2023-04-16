package text03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/04/15
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = new int[]{1, 4, 1, 3};
        int[] ints2 = new int[]{4, 7, 15, 8, 3, 5};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        int[] sum = new int[100010];
        dfs(root, sum, 0);
        fun(root, sum, 0);
        root.val = 0;
        return root;
    }

    private void fun(TreeNode root, int[] sum, int i) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            root.right.val = sum[i + 1] - root.right.val;
            fun(root.right, sum, i + 1);
            return;
        }
        if (root.left != null && root.right == null) {
            root.left.val = sum[i + 1] - root.left.val;
            fun(root.left, sum, i + 1);
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        int a = root.left.val;
        int b = root.right.val;
        root.left.val = sum[i + 1] - a - b;
        root.right.val = sum[i + 1] - a - b;
        fun(root.right, sum, i + 1);
        fun(root.left, sum, i + 1);
    }

    private void dfs(TreeNode root, int[] sum, int i) {
        if (root == null) {
            return;
        }
        sum[i] += root.val;
        dfs(root.left, sum, i + 1);
        dfs(root.right, sum, i + 1);
    }
}