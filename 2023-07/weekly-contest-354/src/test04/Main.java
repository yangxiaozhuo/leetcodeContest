package test04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/07/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = new ArrayList<>();
        strings.add("de");
        strings.add("le");
        strings.add("e");
        System.out.println(solution.longestValidSubstring("leetcode", strings));
    }
}
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        long res = (1L + word.length()) * word.length() / 2;
        Node root = new Node();
        for (int i = 0; i < forbidden.size(); i++) {
            build(root, forbidden.get(i));
        }
        char[] words = word.toCharArray();
        int temp = 0;
        for (int i = 0; i < words.length; i++) {
            Node cur = root;
            for (int j = i; j < words.length; j++) {
                int t = words[j] - 'a';
                if (cur.child[t] == null) {
                    break;
                } else if (cur.child[t].val == 0) {
                    cur = cur.child[t];
                } else {
                    res = res - (words.length - j);
                    res = res - (i + 1);
                    if (j == i) {
                        res++;
                    }
                    res = res + temp;
                    temp++;
                    break;
                }
            }
        }
        return (int)res;
    }


    private void build(Node root, String forbidden) {
        Node cur = root;
        for (char c : forbidden.toCharArray()) {
            if (cur.child[c-'a'] == null) {
                cur.child[c-'a'] = new Node();
            }
            cur = cur.child[c-'a'];
        }
        cur.val++;
    }
}
class Node {
    int val;
    Node[] child = new Node[26];
}