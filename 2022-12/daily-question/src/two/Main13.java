package two;

/**
 * 1832. 判断句子是否为全字母句
 *
 * @author yangxiaozhuo
 * @date 2022/12/13
 */
public class Main13 {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int[] dp = new int[26];
            for (char c : sentence.toCharArray()) {
                dp[c - 'a'] = 1;
            }
            for (int i = 0; i < 26; i++) {
                if (dp[i] == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
