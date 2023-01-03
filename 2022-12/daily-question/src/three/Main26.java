package three;

/**
 * 1759. 统计同构子字符串的数目
 * @author yangxiaozhuo
 * @date 2022/12/26
 */
public class Main26 {
    class Solution {
        public int countHomogenous(String s) {
            int res = 0;
            int l = 0;
            int mod = 1000_000_007;
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == chars[l]) {
                    res = res + i - l + 1;
                } else {
                    l = i;
                    res++;
                }
                res = res % mod;
            }
            return res;
        }
    }
}
