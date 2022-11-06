/**
 * 1662. 检查两个字符串数组是否相等
 *
 * @author yangxiaozhuo
 * @date 2022/11/01
 * <p>
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 * 示例 1：
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] word1 = new String[]{"ab","c"};
        String[] word2 = new String[]{"a","bc"};
        System.out.println(solution.arrayStringsAreEqual(word1,word2));
    }

    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < word1.length; i++) {
                sb1.append(word1[i]);
            }
            for(int i = 0; i < word2.length; i++) {
                sb2.append(word2[i]);
            }
            return sb1.toString().equals(sb2.toString());
        }
    }
}
