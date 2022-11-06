import java.util.HashMap;

/**
 * 2458. 移除子树后的二叉树高度
 *
 * @author yangxiaozhuo
 * @date 2022/10/30
 * 给你一棵 二叉树 的根节点 root ，树中有 n 个节点。每个节点都可以被分配一个从 1 到 n 且互不相同的值。另给你一个长度为 m 的数组 queries 。
 * 你必须在树上执行 m 个 独立 的查询，其中第 i 个查询你需要执行以下操作：
 * 从树中 移除 以 queries[i] 的值作为根节点的子树。题目所用测试用例保证 queries[i] 不 等于根节点的值。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是执行第 i 个查询后树的高度。
 * 注意：
 * 查询之间是独立的，所以在每个查询执行后，树会回到其 初始 状态。
 * 树的高度是从根到树中某个节点的 最长简单路径中的边数 。
 *
 * 示例 1：
 * 输入：root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
 * 输出：[2]
 * 解释：上图展示了从树中移除以 4 为根节点的子树。
 * 树的高度是 2（路径为 1 -> 3 -> 2）。
 */
public class Main04 {
    class Solution {
        public int[] treeQueries(TreeNode root, int[] queries) {
            HashMap<TreeNode, Integer> treeHeight = new HashMap<>();
            build(root,treeHeight);
            int[] ans = new int[treeHeight.size() + 10];
            treeHeight.put(null, -1);
            dfs(root,ans,treeHeight,0,0);
            for (int i = 0; i < queries.length; i++) {
                queries[i] = ans[queries[i]];
            }
            return queries;
        }

        private void dfs(TreeNode root, int[] ans, HashMap<TreeNode, Integer> treeHeight, int height, int r_height) {
            if (root == null) {
                return;
            }
            ans[root.val] = r_height;
            dfs(root.left,ans,treeHeight,height + 1,Math.max(r_height,1+ height + treeHeight.get(root.right)));
            dfs(root.right,ans,treeHeight,height + 1,Math.max(r_height, 1+height + treeHeight.get(root.left)));
        }

        private int build(TreeNode root, HashMap<TreeNode, Integer> treeHeight) {
            if (root == null) {return -1;}
            int left = build(root.left, treeHeight);
            int right = build(root.right, treeHeight);
            int max = Math.max(left, right) + 1;
            treeHeight.put(root, max);
            return max;
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
