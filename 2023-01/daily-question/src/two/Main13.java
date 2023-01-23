package two;

/**
 * 2287. 重排字符形成目标字符串
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main13 {
    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] ta = new int[26];
            for (char c : s.toCharArray()) {
                ta[c - 'a']++;
            }
            int res = 1000;
            int[] aa = new int[26];
            for (char c : target.toCharArray()) {
                aa[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (aa[i] != 0)
                    res = Math.min(res, ta[i] / aa[i]);
            }
            return res;
        }
    }
}
