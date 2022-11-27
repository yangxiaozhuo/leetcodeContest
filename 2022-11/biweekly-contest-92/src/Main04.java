import java.util.ArrayList;

/**
 * @author yangxiaozhuo
 * @date 2022/11/26
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        System.out.println(solution.countPalindromes("59512466578132614814196491971876338859244406929452199756228378713015412768735254930628396137980073496628401961595248672912041180305244208428947414824289671139125610743753264552642815437903029523044136795931677661597594403226238400735680030265775991320600147474632546846536803993112820273876592340956857714475604157141465692672702706617317580783844553116501002848669970331419813302301459997809687961783633032212919277670805575104154224983170305246174343083857332877019974240765990975658491174017330404"));
//        System.out.println(solution.countPalindromes("9999900000"));
//        19504  95664210873507549084361027559308288038020451384423
//        System.out.println(solution.countPalindromes("95664210873507549084361027559308288038020451384423"));
        long r = System.currentTimeMillis();
        System.out.println(r - l);
    }

    static class Solution {
        long res = 0;
        int mod = 1000000007;

        public int countPalindromes(String s) {
            res = 0;
            int[][] dp = new int[10][10000];
            int[] index = new int[10];
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - '0';
                int t = index[a];
                dp[a][t] = i;
                index[a]++;
            }
            for (int i = 0; i < s.length(); i++) {
                int a = s.charAt(i) - '0';
                if (dp[a][index[a] - 1] < i + 4) {
                    continue;
                }
                int r = find(dp[a], i, index[a] - 1);
                while (r <= index[a]-1) {
                    fun(i, dp[a][r], dp, index);
                    r++;
                }
            }
            return (int) (res % mod);
        }

        private void fun(int l, int r, int[][] dp, int[] index) {
            for (int i = 0; i < dp.length; i++) {
                int left = finddayul(dp[i], l, index[i] - 1);
                int right = findxiaoyul(dp[i], r, index[i] - 1);
                if (left == right) {
                    continue;
                }
                jisuan(dp[i], left, right);
            }
        }

        //计算
        private void jisuan(int[] dp, int left, int right) {
            for (int i = left; i < right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    res = (res + dp[j] - dp[i] - 1) % mod;
                }
            }
        }

        //找dp[i]中小于target的最小值
        private int findxiaoyul(int[] ints, int target, int r) {
            int l = 0;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (ints[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            return r;
        }

        //找dp[i]中大于target的最小值
        private int finddayul(int[] ints, int target, int r) {
            int l = 0;
            while (l < r) {
                int mid = l + r >> 1;
                if (ints[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return r;
        }

        //ints找大于等于i+4的值 最小的
        private int find(int[] ints, int i, int r) {
            int l = 0;
            while (l < r) {
                int mid = l + r >> 1;
                if (ints[mid] < i + 4) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return r;
        }

    }
}
