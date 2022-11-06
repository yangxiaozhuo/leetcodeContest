/**
 * 1668. 最大重复子字符串
 *
 * @author yangxiaozhuo
 * @date 2022/11/03
 * <p>
 * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
 * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 * <p>
 * 示例 1：
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepeating("ababc", "ab"));
    }

    static class Solution {
        public int maxRepeating(String sequence, String word) {
            int count = 0;
            String tmp = word;
            while (sequence.contains(word)) {
                word += tmp;
                count++;
            }
            return count;
        }
    }
}
