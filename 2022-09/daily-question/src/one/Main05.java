package one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树
 *
 * @author yangxiaozhuo
 * @date 2022/09/05
 */
public class Main05 {
    class Solution {
        HashMap<String, Integer> map;
        List<TreeNode> res;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            map = new HashMap<>();
            res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            dfs(root);
            return res;
        }

        public String dfs(TreeNode root) {
            if (root == null) {
                return null;
            }
            String path = root.val +","+ dfs(root.left) +","+ dfs(root.right);
            int t = map.getOrDefault(path,0);
            map.put(path, t + 1);
            if(t==1) {
                res.add(root);
            }
            return path;
        }
    }
}
