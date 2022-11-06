/**
 * 2432. 处理用时最长的那个任务的员工
 *
 * @author yangxiaozhuo
 * @date 2022/10/09
 * <p>
 * 共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。
 * 给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ：
 * idi 是处理第 i 个任务的员工的 id ，且
 * leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。
 * 注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。
 * 返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。
 * <p>
 * 示例 1：
 * 输入：n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]
 * 输出：1
 * 解释：
 * 任务 0 于时刻 0 开始，且在时刻 3 结束，共计 3 个单位时间。
 * 任务 1 于时刻 3 开始，且在时刻 5 结束，共计 2 个单位时间。
 * 任务 2 于时刻 5 开始，且在时刻 9 结束，共计 4 个单位时间。
 * 任务 3 于时刻 9 开始，且在时刻 15 结束，共计 6 个单位时间。
 * 时间最长的任务是任务 3 ，而 id 为 1 的员工是处理此任务的员工，所以返回 1 。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] logs = new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        System.out.println(solution.hardestWorker(10, logs));
    }

    static class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int max = logs[0][1];
            int res = logs[0][0];
            for (int i = 1; i < logs.length; i++) {
                if (logs[i][1] - logs[i - 1][1] > max) {
                    max = logs[i][1] - logs[i - 1][1];
                    res = logs[i][0];
                } else if (logs[i][1] - logs[i - 1][1] == max && logs[i][0] < res) {
                    res = logs[i][0];
                }
            }
            return res;
        }
    }
}
