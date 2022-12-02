package one;

/**
 * 687. 最长同值路径
 *
 * @author yangxiaozhuo
 * @date 2022/09/02
 */
public class Main02 {

    class Solution {
        int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root, root.val);
            return ans;
        }

        public int dfs(TreeNode root, int val) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left, root.val);
            int right = dfs(root.right, root.val);
            ans = Math.max(ans, left + right);
            if (root.val == val) {
                return Math.max(left, right) + 1;
            } else {
                return 0;
            }
        }
    }
}
