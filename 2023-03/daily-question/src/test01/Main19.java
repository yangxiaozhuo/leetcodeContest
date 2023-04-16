package test01;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/03/19
 */
public class Main19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLexSmallestString("5525", 9, 2));

    }
    static class Solution {
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>();

        public String findLexSmallestString(String s, int a, int b) {
            queue.add(s);
            dfs(s, a, b);
            return queue.peek();
        }

        public void dfs(String s, int a, int b) {
            if (set.contains(s)) {
                return;
            }
            queue.add(s);
            set.add(s);
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i=i+2) {
                chars[i] = (char)((chars[i] - '0' + a) % 10 + '0');
            }
            String s1 = new String(chars);
            dfs(s1, a, b);
            String s2 = s.substring(b) + s.substring(0, b);
            dfs(s2, a, b);
        }

    }
}
