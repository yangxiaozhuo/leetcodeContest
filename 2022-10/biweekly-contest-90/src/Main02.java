import java.util.*;

/**
 * 2452. 距离字典两次编辑以内的单词
 *
 * @author yangxiaozhuo
 * @date 2022/10/29
 *
 * 给你两个字符串数组queries 和dictionary。数组中所有单词都只包含小写英文字母，且长度都相同。
 * 一次 编辑中，你可以从 queries中选择一个单词，将任意一个字母修改成任何其他字母。从queries中找到所有满足以下条件的字符串：不超过两次编辑内，字符串与dictionary中某个字符串相同。
 * 请你返回queries中的单词列表，这些单词距离dictionary中的单词编辑次数不超过两次。单词返回的顺序需要与queries中原本顺序相同。
 *
 * 示例 1：
 * 输入：queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
 * 输出：["word","note","wood"]
 * 解释：
 * - 将 "word" 中的 'r' 换成 'o' ，得到 dictionary 中的单词 "wood" 。
 * - 将 "note" 中的 'n' 换成 'j' 且将 't' 换成 'k' ，得到 "joke" 。
 * - "ants" 需要超过 2 次编辑才能得到 dictionary 中的单词。
 * - "wood" 不需要修改（0 次编辑），就得到 dictionary 中相同的单词。
 * 所以我们返回 ["word","note","wood"] 。
 */
public class Main02 {
    public static void main(String[] args) {
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        Solution solution = new Solution();
        System.out.println(solution.twoEditWords(queries, dictionary));
    }
    static class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                for (int j = 0; j < dictionary.length; j++) {
                    String query = queries[i];
                    String s = dictionary[j];
                    int time = 0;
                    for (int k = 0; k < query.length(); k++) {
                        int t = query.charAt(k) - s.charAt(k);
                        if (t != 0) {
                            time++;
                            if (time == 3) {
                                break;
                            }
                        }
                    }
                    if (time <= 2) {
                        res.add(query);
                        break;
                    }
                }
            }
            return res;
        }
    }
}
