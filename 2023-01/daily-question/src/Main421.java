/**
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main421 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println(solution.findMaximumXOR(ints));
    }

    static class Solution {
        int MAX_BIT = 31;

        public int findMaximumXOR(int[] nums) {
            Node root = new Node();
            int res = 0;
            add(nums[0], root);
            for (int num : nums) {
                res = Math.max(get(num, root), res);
                add(num, root);
            }
            return res;
        }

        private int get(int num, Node root) {
            int res = 0;
            Node cur = root;
            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.son[1 - bit] == null) {
                    res = res * 2;
                    cur = cur.son[bit];
                } else {
                    res = res * 2 + 1;
                    cur = cur.son[1 - bit];
                }
            }
            return res;
        }

        private void add(int num, Node root) {
            Node cur = root;
            for (int i = MAX_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.son[bit] == null) {
                    cur.son[bit] = new Node();
                }
                cur = cur.son[bit];
                cur.val++;
            }
        }

        class Node {
            int val = 0;
            Node[] son = new Node[2];
        }
    }
}
