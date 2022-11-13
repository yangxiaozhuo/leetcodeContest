package two;

import java.io.*;
import java.util.*;

/**
 * 791. 自定义字符串排序
 *
 * @author yangxiaozhuo
 * @date 2022/11/13
 */
public class Main13 {
    public static void main(String[] args) throws IOException {
    }

    static class Solution {
        public String customSortString(String order, String s) {
            ArrayList<Character> chars = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                chars.add(s.charAt(i));
            }
            Collections.sort(chars, (o1, o2) -> {
                return order.indexOf(o1) - order.indexOf(o2);
            });
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < chars.size(); i++) {
                sb.append(chars.get(i));
            }
            return sb.toString();
        }
    }
}
