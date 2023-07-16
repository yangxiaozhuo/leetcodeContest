package test04;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/07/08
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumBeautifulSubstrings("1011"));
    }
}

class Solution {
    int res = 100000;
    HashSet<Integer> set = new HashSet<>();
    public int minimumBeautifulSubstrings(String s) {
        int temp = 1;
        while (temp < (1 << 18)) {
            set.add(temp);
            temp = temp * 5;
        }
        dfs(s,0, 0);
        if (res == 100000) {
            return -1;
        }
        return res;
    }

    private boolean dfs(String s,int start, int had) {
        boolean bool = false;
        if (s.charAt(start) == '0') {
            return false;
        }
        int t = 0;
        for (int i = start; i < s.length(); i++) {
               // 从start到i [start, i]
            if (s.charAt(i) == '1') {
                t = t * 2 + 1;
            } else {
                t = t * 2;
            }
            if (set.contains(t)) {
                if (i == s.length() -1) {
                    res = Math.min(res, had + 1);
                    return true;
                }
                boolean dfs = dfs(s, i + 1, had + 1);
                if (dfs) {
                    bool = true;
                }
            }
        }
        return bool;
    }
}