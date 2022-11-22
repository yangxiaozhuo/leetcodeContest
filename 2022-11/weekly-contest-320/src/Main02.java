import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2022/11/20
 */
public class Main02 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            dfs(arrayList, root);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < queries.size(); i++) {
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                arrayList1.add(findLow(arrayList, queries.get(i)));
                arrayList1.add(findUp(arrayList, queries.get(i)));
                res.add(arrayList1);
            }
            return res;
        }

        private void dfs(ArrayList<Integer> arrayList, TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(arrayList, root.left);
            arrayList.add(root.val);
            dfs(arrayList, root.right);
        }

        private Integer findUp(ArrayList<Integer> arrayList, Integer integer) {
            if (integer > arrayList.get(arrayList.size() - 1)) {
                return -1;
            }
            int l = 0;
            int r = arrayList.size();
            while (r > l) {
                int mid = r + l >> 1;
                if (arrayList.get(mid) >= integer) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return arrayList.get(r);
        }

        private Integer findLow(ArrayList<Integer> arrayList, Integer integer) {
            if (integer < arrayList.get(0)) {
                return -1;
            }
            int l = 0;
            int r = arrayList.size() - 1;
            while (r > l) {
                int mid = r + l + 1 >> 1;
                if (arrayList.get(mid) <= integer) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return arrayList.get(r);
        }
    }

    static class Solution1 {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            treeNodes.add(root);
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = treeNodes.poll();
                    arrayList.add(poll.val);
                    if (poll.left != null) {
                        treeNodes.add(poll.left);
                    }
                    if (poll.right != null) {
                        treeNodes.add(poll.right);
                    }
                }
            }
            Collections.sort(arrayList);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < queries.size(); i++) {
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                arrayList1.add(findLow(arrayList, queries.get(i)));
                arrayList1.add(findUp(arrayList, queries.get(i)));
                res.add(arrayList1);
            }
            return res;
        }

        private Integer findUp(ArrayList<Integer> arrayList, Integer integer) {
            if (integer > arrayList.get(arrayList.size() - 1)) {
                return -1;
            }
            int l = 0;
            int r = arrayList.size();
            while (r > l) {
                int mid = r + l >> 1;
                if (arrayList.get(mid) >= integer) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return arrayList.get(r);
        }

        private Integer findLow(ArrayList<Integer> arrayList, Integer integer) {
            if (integer < arrayList.get(0)) {
                return -1;
            }
            int l = 0;
            int r = arrayList.size();
            while (r > l) {
                int mid = r + l + 1 >> 1;
                if (arrayList.get(mid) <= integer) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return arrayList.get(r);
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
