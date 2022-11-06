package one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 *
 * @author yangxiaozhuo
 * @date 2022/10/05
 */
public class Main05 {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < cpdomains.length; i++) {
                String[] s = cpdomains[i].split(" ");
                int temp = Integer.parseInt(s[0]);
                int l = s[1].length() - 1;
                while (l >= 0) {
                    while (l >= 0 && s[1].charAt(l) != '.') {
                        l--;
                    }
                    String a = s[1].substring(l + 1);
                    map.put(a, map.getOrDefault(a, 0) + temp);
                    l--;
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> set : map.entrySet()) {
                res.add(set.getValue() + " " + set.getKey());
            }
            return res;
        }
    }
}
