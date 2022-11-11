/**
 * 2415. 反转二叉树的奇数层
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main03 {
    class Solution {
        public void dfs(TreeNode root1, TreeNode root2, int depth) {
            if (root1 == null) {
                return;
            }
            if (depth % 2 == 1) {
                int temp = root1.val;
                root1.val = root2.val;
                root2.val = temp;
            }
            dfs(root1.left, root2.right, depth + 1);
            dfs(root1.right, root2.left, depth + 1);
        }

        public TreeNode reverseOddLevels(TreeNode root) {
            dfs(root.left, root.right, 1);
            return root;
        }
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
