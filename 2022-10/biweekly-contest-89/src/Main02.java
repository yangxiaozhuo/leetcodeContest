import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2438. 二的幂数组中查询范围内的乘积
 *
 * @author yangxiaozhuo
 * @date 2022/10/15
 * 给你一个正整数n，你需要找到一个下标从0开始的数组powers，它包含 最少数目的 2的幂，
 * 且它们的和为n。powers数组是非递减顺序的。根据前面描述，构造powers数组的方法是唯一的。
 * 同时给你一个下标从 0开始的二维整数数组queries，其中queries[i] = [lefti, righti]，
 * 其中queries[i]表示请你求出满足lefti <= j <= righti的所有powers[j]的乘积。
 * 请你返回一个数组answers，长度与queries的长度相同，其中answers[i]是第i个查询的答案。
 * 由于查询的结果可能非常大，请你将每个answers[i]都对109 + 7取余。
 * <p>
 * 示例 1：
 * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
 * 输出：[2,4,64]
 * 解释：
 * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
 * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
 * 第 2 个查询的答案：powers[2] = 4 。
 * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
 * 每个答案对 109 + 7 得到的结果都相同，所以返回 [2,4,64] 。
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(solution.productQueries(15, queries)));
    }

    static class Solution {
        public int[] productQueries(int n, int[][] queries) {
            int mod = 1000000007;
            ArrayList<Integer> powers = new ArrayList<>();
            while (n > 0) {
                int t = ~n + 1;
                powers.add(n & t);
                n = (n ^ (n & t));
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                long temp = 1;
                int start = queries[i][0];
                int end = queries[i][1];
                for (; start <= end; start++) {
                    temp = temp * powers.get(start);
                    temp = temp % mod;
                }
                res[i] = (int) temp;
            }
            return res;
        }
    }
}
