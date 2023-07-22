package test02;

/**
 * @author yangxiaozhuo
 * @date 2023/07/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }
}
//[630,493,433,428,228,115,579,756,95,158,939,864,469,982,739,391,830,242,408,259,786,641,758,514,904,626,236,165,95,613,514,397,951,924,677,910,394,885,323,176,545,432,661,57,981,248,998,863,511,910,811,210,777,365,300,316,26,6,195,852,502,471]
//423
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // l 和 r 最大-最小 <= k
        k = k * 2 + 1;
        int[] sums = new int[100010];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]]++;
        }
        int[] dp = new int[sums.length];
        for (int i = 0; i < sums.length && i < k; i++) {
            dp[0] += sums[i];
        }
        for (int i = 1; (i + k - 1) < sums.length; i++) {
            dp[i] = dp[i - 1] - sums[i - 1] + sums[i + k - 1];
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}