/**
 * 2451. 差值数组不同的字符串
 *
 * @author yangxiaozhuo
 * @date 2022/10/23
 * 给你一个字符串数组 words，每一个字符串长度都相同，令所有字符串的长度都为 n。
 * <p>
 * 每个字符串words[i]可以被转化为一个长度为n - 1的差值整数数组difference[i]，
 * 其中对于0 <= j <= n - 2有difference[i][j] = words[i][j+1] - words[i][j]。
 * 注意两个字母的差值定义为它们在字母表中位置之差，也就是说'a'的位置是0，'b'的位置是1，'z'的位置是25。
 * 比方说，字符串"acb"的差值整数数组是[2 - 0, 1 - 2] = [2, -1]。
 * words中所有字符串 除了一个字符串以外，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * 请你返回words中差值整数数组不同的字符串。
 * <p>
 * 示例 1：
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"adc", "wzy", "abc"};
        System.out.println(solution.oddString(words));
    }

    static class Solution {
        public String oddString(String[] words) {
            String[][] strings = new String[words.length][2];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < words[i].length() - 1; j++) {
                    int t = word.charAt(j + 1) - word.charAt(j);
                    stringBuilder.append(t);
                    stringBuilder.append(",");
                }
                strings[i][0] = word;
                strings[i][1] = stringBuilder.toString();
            }
            for (int i = 0; i < strings.length; i++) {
                int t = 0;
                for (int j = 0; j < strings.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (!strings[i][1].equals(strings[j][1])) {
                        t++;
                        if (t == 2) {
                            return strings[i][0];
                        }
                    } else {
                        break;
                    }
                }
            }
            return words[0];
        }
    }
}

