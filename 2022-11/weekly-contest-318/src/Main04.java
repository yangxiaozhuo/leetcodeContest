import java.util.*;

/**
 * 2463. 最小移动总距离
 *
 * @author yangxiaozhuo
 * @date 2022/11/06
 */
public class Main04 {
    /**
     * 记忆化搜索   递推
     * 优点
     * 缺点    38ms
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> robot = new ArrayList<>();
        robot.add(9);
        robot.add(11);
        robot.add(99);
        robot.add(101);
        int[][] factory = new int[][]{{7, 1}, {10, 1}, {14, 1}, {96, 1}, {100, 1}, {103, 1}};
        System.out.println(solution.minimumTotalDistance(robot, factory));
    }


    //记忆化搜素  时间复杂度 = O（状态个数） * O(单个状态的转移次数) * O(计算转移转移来源所需次数)
    //                   = O(nm) * (m) * O(1) = O(n m^2)
    static class Solution {
        long[][] dp;
        int n;
        int m;

        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            n = factory.length;
            m = robot.size();
            dp = new long[n + 1][m + 1];
            Collections.sort(robot);
            Arrays.sort(factory, (o1, o2) -> o1[0] - o2[0]);
            return fun(0, 0, factory, robot);
        }

        //表示，第i-n个工厂 修理第j-m个机器人
        private long fun(int i, int j, int[][] factory, List<Integer> robot) {
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            if (j == m) {
                return 0;
            }
            if (i == n - 1) {
                if (m - j > factory[i][1]) {
                    return Long.MAX_VALUE;
                } else {
                    long res = 0;
                    for (int k = j; k < m; k++) {
                        res = res + Math.abs(factory[i][0] - robot.get(k));
                    }
                    return res;
                }
            }
            long res = fun(i + 1, j, factory, robot);
            long s = 0;
            for (int k = 1; k <= factory[i][1] && j + k - 1 < m; k++) {
                s = s + Math.abs(robot.get(j + k - 1) - factory[i][0]);
                long t = fun(i + 1, j + k, factory, robot);
                if (t != Long.MAX_VALUE) {
                    if (res == Long.MAX_VALUE) {
                        res = s + t;
                    } else {
                        res = Math.min(res, s + t);
                    }
                }
            }
            dp[i][j] = res;
            return res;
        }
    }
}
