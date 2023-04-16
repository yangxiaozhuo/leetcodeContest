package text02;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2023/03/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{58, 42, 8, 75, 28};  //30
    }
}

class Solution {
    int max = 1;
    long[] nums = new long[100010];

    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 1);
        if (max < k) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[100010 - k];
    }

    private void dfs(TreeNode root, int at) {
        if (root == null) {
            return;
        }
        max = Math.max(max, at);
        nums[at] += root.val;
        dfs(root.left, at + 1);
        dfs(root.right, at + 1);
    }

    public class TreeNode {
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
}