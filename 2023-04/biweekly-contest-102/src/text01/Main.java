package text01;


/**
 * @author yangxiaozhuo
 * @date 2023/04/15
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = String.valueOf(grid[0][i]).length();
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, String.valueOf(grid[j][i]).length());
            }
            res[i] = max;
        }
        return res;
    }
}