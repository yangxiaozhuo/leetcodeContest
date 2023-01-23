package two;

/**
 * 1813. 句子相似性 III
 *
 * @author yangxiaozhuo
 * @date 2023/01/19
 */
public class Main16 {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if(sentence1.length() == sentence2.length()) {
                return sentence1.equals(sentence2);
            }
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            if(s1.length == s2.length) {
                return false;
            }
            if(s1.length > s2.length) {
                String[] s = s1;
                s1 = s2;
                s2 = s;
            }
            int t = 0;
            int a = 0;
            for(int i = 0; i < s1.length; i++) {
                if(s1[i].equals(s2[a])) {
                    a++;
                    t++;
                } else {
                    break;
                }
            }
            int b = s2.length - 1;
            for(int i = s1.length - 1; i >= 0; i--) {
                if(s1[i].equals(s2[b])) {
                    b--;
                    t++;
                } else {
                    break;
                }
            }
            return t >= s1.length;
        }
    }
}
