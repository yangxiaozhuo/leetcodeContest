package one;


/**
 * 1803. 统计异或值在范围内的数对有多少
 *
 * @author yangxiaozhuo
 * @date 2023/01/05
 */
public class Main05 {
    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            return f(nums, high) - f(nums, low - 1);
        }

        private int f(int[] nums, int mid) {
            Node root = new Node();
            int res = 0;
            for (int i = 1; i < nums.length; i++) {
                add(nums[i - 1],root);
                res += get(nums[i],root,mid);
            }
            return res;
        }

        private int get(int num, Node root, int mid) {
            Node cur = root;
            int res = 0;
            for (int i = 16; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (((mid >> i) & 1) != 0) {
                    if (cur.sons[bit] != null) {
                        res += cur.sons[bit].val;
                    }
                    if (cur.sons[bit ^ 1] == null) {
                        return res;
                    }
                    cur = cur.sons[bit ^ 1];
                } else {
                    if (cur.sons[bit] == null) {
                        return res;
                    }
                    cur = cur.sons[bit];
                }
            }
            res += cur.val;
            return res;
        }

        private void add(int num, Node root) {
            Node cur = root;
            for (int i = 16; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.sons[bit] == null) {
                    cur.sons[bit] = new Node();
                }
                cur = cur.sons[bit];
                cur.val++;
            }
        }

        class Node {
            int val;
            Node[] sons = new Node[2];
        }
    }
}
