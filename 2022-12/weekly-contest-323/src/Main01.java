import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2022/12/11
 */
public class Main01 {
    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                Arrays.sort(grid[i]);
            }
            int res = 0;
            for (int i = 0; i < grid[0].length; i++) {
                int max =  grid[0][i];
                for (int j = 0; j < grid.length; j++) {
                    max = Math.max(max, grid[j][i]);
                }
                res += max;
            }
            return res;
        }
    }
}
