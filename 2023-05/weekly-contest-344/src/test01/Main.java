package test01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/05/07
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            HashSet<Integer> pre = new HashSet<>();
            HashSet<Integer> next = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                pre.add(nums[j]);
            }
            for (int j = i+1; j < nums.length; j++) {
                next.add(nums[j]);
            }
            res[i] = pre.size() - next.size();
        }
        return res;
    }
}