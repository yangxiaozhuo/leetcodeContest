package one;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 *
 * @author yangxiaozhuo
 * @date 2022/11/07
 */
public class Main07 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ambiguousCoordinates("(000001)"));
    }
    static class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> res = new ArrayList<>();
            for (int i = 2; i < s.length() - 1; i++) {
                ArrayList[] temp = fun(s.substring(1,i), s.substring(i, s.length() - 1));
                for (int j = 0; j < temp[0].size(); j++) {
                    for (int k = 0; k < temp[1].size(); k++) {
                        res.add("(" + temp[0].get(j) +", " + temp[1].get(k) + ")");
                    }
                }
            }
            return res;
        }

        private ArrayList[] fun(String s1, String s2) {
            ArrayList[] lists = new ArrayList[2];
            for (int i = 0; i < 2; i++) {
                lists[i] = new ArrayList<String>();
            }
            for (int i = 1; i < s1.length(); i++) {
                String t = s1.substring(0,i) + '.' + s1.substring(i);
                if(check(t) && isZero(s1.substring(i))) {
                    lists[0].add(t);
                }
            }
            if(s1.equals(Integer.parseInt(s1)+"")) {
                lists[0].add(s1);
            }
            for (int i = 1; i < s2.length(); i++) {
                String t = s2.substring(0,i) + '.' + s2.substring(i);
                if(check(t) && isZero(s2.substring(i))) {
                    lists[1].add(t);
                }
            }
            if(s2.equals(Integer.parseInt(s2)+"")) {
                lists[1].add(s2);
            }
            return lists;
        }

        private boolean isZero(String substring) {
            return Integer.parseInt(substring) != 0;
        }

        private boolean check(String t) {
            String[] split = t.split("\\.");
            if (split[0].length() > 1 && Integer.parseInt(split[0]) == 0) {
                return false;
            }
            if (split[0].length() > 1 && split[0].charAt(0) == '0') {
                return false;
            }
            if (split[1].charAt(split[1].length() -1) == '0') {
                return false;
            }
            return true;
        }
    }
}
