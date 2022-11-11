/**
 * 2416. 字符串的前缀分数和
 *
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main04 {
    class Solution {
        public int[] sumPrefixScores(String[] words) {
            Node root = new Node();
            for (int i = 0; i < words.length; i++) {
                Node cur = root;
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (cur.sons[c - 'a'] == null) {
                        cur.sons[c - 'a'] = new Node();
                    }
                    cur = cur.sons[c - 'a'];
                    cur.val++;

                }
            }
            int[] res = new int[words.length];
            for (int i = 0; i < res.length; i++) {
                int num = 0;
                Node cur = root;
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    cur = cur.sons[c - 'a'];
                    num = num + cur.val;
                }
                res[i] = num;
            }
            return res;
        }

        class Node {
            int val;
            Node[] sons;

            public Node() {
                this.val = 0;
                this.sons = new Node[26];
            }
        }
    }
}
