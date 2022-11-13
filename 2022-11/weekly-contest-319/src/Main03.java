import java.util.ArrayList;
import java.util.Arrays;


/**
 * 6235. 逐层排序二叉树所需的最少操作数目
 *
 * @author yangxiaozhuo
 * @date 2022/11/13
 */
public class Main03 {
    public static void main(String[] args) {
        int[] ints = new int[]{4, 1, 6, 2, 3, 5};
        System.out.println(fun(ints));

    }

    static public int fun(int[] temp) {
        int[] nums = new int[temp.length];
        int[] copy = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
            copy[i] = temp[i];
        }
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == nums[i]) {
                continue;
            }
            //找copy中 nums[i]所在的位置l，查看copy[l]是否等于 nums[i]
            int index = find(copy, nums[i]);
            int t = nums[i];
            nums[i] = nums[index];
            nums[index] = t;
            if (nums[i] != copy[i]) {
                i--;
            }
            res++;
        }
        return res;
    }

    static private int find(int[] copy, int num) {
        int l = 0;
        int r = copy.length;
        while (r > l) {
            int mid = r + l >> 1;
            if (copy[mid] == num) {
                return mid;
            } else if (copy[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static class Solution {
        public int minimumOperations(TreeNode root) {
            int res = 0;
            ArrayList<TreeNode> arrayList = new ArrayList<>();
            arrayList.add(root);
            while (!arrayList.isEmpty()) {
                ArrayList<TreeNode> temp = new ArrayList<>();
                while (!arrayList.isEmpty()) {
                    TreeNode remove = arrayList.remove(0);
                    if (remove.left != null) {
                        temp.add(remove.left);
                    }
                    if (remove.right != null) {
                        temp.add(remove.right);
                    }
                }
                arrayList = temp;
                res = res + fun(temp);
            }
            return res;
        }

        public int fun(ArrayList<TreeNode> temp) {
            int[] nums = new int[temp.size()];
            int[] copy = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                nums[i] = temp.get(i).val;
                copy[i] = temp.get(i).val;
            }
            Arrays.sort(copy);
            int res = 0;
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] == nums[i]) {
                    continue;
                }
                //找copy中 nums[i]所在的位置l，查看copy[l]是否等于 nums[i]
                int index = find(copy, nums[i]);
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                res++;
            }
            return res;
        }

        private int find(int[] copy, int num) {
            int l = 0;
            int r = copy.length;
            while (r > l) {
                int mid = r + l >> 1;
                if (copy[mid] == num) {
                    return mid;
                } else if (copy[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
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
