package test1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/05/14
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.circularGameLosers(5, 2)));
    }
}
class Solution {
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        int gap = k;
        while (!set.contains(index)) {
            set.add(index);
            index += gap;
            gap = gap + k;
            index = index % n;
        }
        int[] res = new int[n - set.size()];
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                res[t] = i;
                t++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i]++;
        }
        return res;
    }
}