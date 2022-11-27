/**
 * @author yangxiaozhuo
 * @date 2022/11/26
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
//            令第 i 行一的数目为 onesRowi 。
//            令第 j 列一的数目为 onesColj 。
//            令第 i 行零的数目为 zerosRowi 。
//            令第 j 列零的数目为 zerosColj 。
            int[] onesRowi = new int[grid.length];
            int[] zerosRowi = new int[grid.length];
            int[] onesColj = new int[grid[0].length];
            int[] zerosColj = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        onesColj[j] += 1;
                        onesRowi[i] += 1;
                    } else {
                        zerosColj[j] += 1;
                        zerosRowi[i] += 1;
                    }
                }
            }
            int[][] res = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
//                    onesRowi + onesColj - zerosRowi - zerosColj
                    res[i][j] = onesRowi[i] + onesColj[j] - zerosRowi[i] - zerosColj[j];
                }
            }
            return res;
        }
    }
}
