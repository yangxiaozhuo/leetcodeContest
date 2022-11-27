package three;

/**
 * 809. 情感丰富的文字
 *
 * @author yangxiaozhuo
 * @date 2022/11/25
 */
public class Main25 {
    class Solution {
        Node root = new Node();

        public int expressiveWords(String s, String[] words) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
                int right = i;
                while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                    right++;
                }
                cur.val = right - i;
                i = right - 1;
            }
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if (test(words[i])) {
                    res++;
                }
            }
            return res;
        }

        public boolean test(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
                int right = i;
                while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                    right++;
                }
                if (right - i > cur.val || (cur.val < 3 && right - i != cur.val)) {
                    return false;
                }
                i = right - 1;
            }
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    return false;
                }
            }
            return true;
        }

        class Node {
            int val = 0;
            Node[] children = new Node[26];
        }
    }
}
