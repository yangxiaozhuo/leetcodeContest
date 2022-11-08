package one;

import java.util.HashSet;

/**
 * 1684. 统计一致字符串的数目
 *
 * @author yangxiaozhuo
 * @date 2022/11/08
 */
public class Main08 {
    public static void main(String[] args) {
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        String allowed = "ab";
        Solution solution = new Solution();
        System.out.println(solution.countConsistentStrings(allowed, words));
    }

    /**
     * 字母的很多可以用26长度的数组来做，快，空间小
     */
    static class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int res = 0;
            int[] origin = new int[26];
            for (int i = 0; i < allowed.length(); i++) {
                origin[allowed.charAt(i) - 'a']++;
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (origin[words[i].charAt(j) - 'a'] == 0) {
                        break;
                    }
                    if(j == words[i].length() - 1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

    /**
     * 方法1 hashset
     */
    static class Solution1 {
        public int countConsistentStrings(String allowed, String[] words) {
            int res = 0;
            HashSet<Character> origin = new HashSet<>();
            for (int i = 0; i < allowed.length(); i++) {
                origin.add(allowed.charAt(i));
            }
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                HashSet<Character> set = new HashSet<>();
                for (int j = 0; j < word.length(); j++) {
                    if (origin.contains(word.charAt(j))) {
                        set.add(word.charAt(j));
                    } else {
                        break;
                    }
                    if(j == word.length() - 1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
