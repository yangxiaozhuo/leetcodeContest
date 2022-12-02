package one;

import java.util.ArrayList;

/**
 * 828. 统计子串中的唯一字符
 *
 * @author yangxiaozhuo
 * @date 2022/09/06
 */
public class Main06 {
    class Solution {
        public int uniqueLetterString(String s) {
            ArrayList<Integer>[] arrays = new ArrayList[26];
            for (int i = 0; i < s.length(); i++) {
                if (arrays[s.charAt(i) - 'A'] == null) {
                    arrays[s.charAt(i) - 'A'] = new ArrayList<>();
                    arrays[s.charAt(i) - 'A'].add(-1);
                }
                arrays[s.charAt(i) - 'A'].add(i);
            }
            int res = 0;
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i] == null) {
                    continue;
                }
                ArrayList<Integer> array = arrays[i];
                array.add(s.length());
                for (int j = 1; j < array.size() - 1; j++) {
                    res = res + (array.get(j) - array.get(j - 1)) * (array.get(j + 1) - array.get(j));
                }
            }
            return res;
        }
    }

}
