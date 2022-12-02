package one;

/**
 * 669. 修剪二叉搜索树
 *
 * @author yangxiaozhuo
 * @date 2022/09/10
 */
public class Main10 {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root==null) {
                return null;
            }
            if(root.val < low) {
                return trimBST(root.right,low,high);
            }
            if(root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
    }
}
