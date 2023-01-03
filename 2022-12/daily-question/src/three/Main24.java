package three;

/**
 * 1754. 构造字典序最大的合并字符串
 * @author yangxiaozhuo
 * @date 2022/12/24
 */
public class Main24 {
    class Solution {
        public String largestMerge(String word1, String word2) {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            StringBuilder res = new StringBuilder();
            int i = 0;
            int j = 0;
            while(i < chars1.length && j < chars2.length) {
                if(fun(chars1, chars2, i, j)) {
                    res.append(chars1[i]);
                    i++;
                } else {
                    res.append(chars2[j]);
                    j++;
                }
            }
            while(i < chars1.length) {
                res.append(chars1[i]);
                i++;
            }
            while(j < chars2.length) {
                res.append(chars2[j]);
                j++;
            }
            return res.toString();
        }
        public boolean fun(char[] chars1, char[] chars2, int i, int j) {
            if(i >= chars1.length && j >= chars2.length) {
                return true;
            }
            if(i >= chars1.length) {
                return false;
            }
            if(j >= chars2.length) {
                return true;
            }
            if(chars1[i] < chars2[j]) {
                return false;
            }
            if(chars1[i] > chars2[j]) {
                return true;
            }
            return fun(chars1, chars2, i + 1, j + 1);
        }
    }
}
