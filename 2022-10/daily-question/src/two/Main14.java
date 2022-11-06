package two;

/**
 * 940. 不同的子序列 II
 *
 * @author yangxiaozhuo
 * @date 2022/10/14
 */
public class Main14 {
    class Solution {
        public int distinctSubseqII(String s) {
            int mod = 1000000007;
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int sum = 0;
                for (int j = 0; j < 26; j++) {
                    sum = (sum + arr[j]) % mod;
                }
                arr[s.charAt(i) - 'a'] = sum + 1;
            }
            int res = 0;
            for (int i = 0; i < 26; i++) {
                res = res + arr[i];
                res = res % mod;
            }
            return res % mod;
        }
    }
}
