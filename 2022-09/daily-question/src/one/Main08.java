package one;

/**
 * 667. 优美的排列 II
 *
 * @author yangxiaozhuo
 * @date 2022/09/08
 */
public class Main08 {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] ans = new int[n];
            int numk = k + 1;
            int numTemp = 1;
            //下标段[0, k]中，偶数下标填充[1,2,3..]
            for (int i = 0; i <= k; i += 2) {
                ans[i] = numTemp++;
            }
            //下标段[0, k]中，奇数下标填充[k + 1, k, k - 1...]
            for (int i = 1; i <= k; i += 2) {
                ans[i] = numk--;
            }
            //下标段[k + 1, n - 1]都是顺序填充
            for (int i = k + 1; i < n; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
}
