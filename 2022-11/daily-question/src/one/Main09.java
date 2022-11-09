package one;

/**
 * 764. 最大加号标志
 *
 * @author yangxiaozhuo
 * @date 2022/11/09
 */
public class Main09 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mines = new int[][]{{4, 2}};
        System.out.println(solution.orderOfLargestPlusSign(5, mines));
    }

    static class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            if (n * n - mines.length <= 0) {
                return 0;
            }
            int l = 1;
            int r = (n + 1) / 2;
            int[][] nums = new int[n][n];
            for (int i = 0; i < mines.length; i++) {
                nums[mines[i][0]][mines[i][1]] = 1;
            }
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (fun(mid, nums)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }

        public boolean fun(int mid, int[][] nums) {
            for (int i = mid - 1; i < nums.length - mid + 1; i++) {
                for (int j = mid - 1; j < nums.length - mid + 1; j++) {
                    if (isOne(mid, nums, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isOne(int mid, int[][] nums, int r, int c) {
            for (int i = 0; i < mid; i++) {
                if (nums[r - i][c] == 1 || nums[r + i][c] == 1 || nums[r][c - i] == 1 || nums[r][c + i] == 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
