import java.util.HashSet;

/**
 * 2423. 删除字符使频率相同
 *
 * @author yangxiaozhuo
 * @date 2022/10/01
 * <p>
 * 给你一个下标从 0开始的字符串word，字符串只包含小写英文字母。你需要选择 一个下标并 删除下标处的字符，使得 word中剩余每个字母出现 频率相同。
 * 如果删除一个字母后，word中剩余所有字母的出现频率都相同，那么返回 true，否则返回 false。
 * 注意：
 * 字母x的 频率是这个字母在字符串中出现的次数。
 * 你 必须恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * 示例 1：
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalFrequency("abcc"));
    }

    static class Solution {
        public boolean equalFrequency(String word) {
            for (int i = 0; i < word.length(); i++) {
                if (check(word, i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean check(String word, int index) {
            int[] arr = new int[26];
            for (int i = 0; i < word.length(); i++) {
                if (i == index) continue;
                else arr[word.charAt(i) - 'a']++;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                set.add(arr[i]);
            }
            return set.size() < 3;
        }
    }
}
