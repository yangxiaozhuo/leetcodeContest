package two;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 805. 数组的均值分割
 *
 * @author yangxiaozhuo
 * @date 2022/11/14
 */
public class Main14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{0,0,0};
        System.out.println(solution.splitArraySameAverage(ints));
    }

    static class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            int av = 0;
            for (int i = 0; i < nums.length; i++) {
                av += nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums.length;
            }
            int[] nums2 = new int[nums.length];
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = nums[i] - av;
            }
            ArrayList<Integer> low = new ArrayList<>();
            ArrayList<Integer> height = new ArrayList<>();
            int temp = 0;
            boolean flag = false;
            boolean flag2 = false;
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] < 0) {
                    low.add(nums2[i]);
                    temp += nums2[i];
                    flag2 = true;
                } else if(nums2[i] > 0){
                    height.add(nums2[i]);
                    flag2 = true;
                } else {
                    flag = true;
                }
            }
            HashSet<Integer> lowSet = new HashSet<>();
            HashSet<Integer> heightSet = new HashSet<>();
            lowSet.add(0);
            heightSet.add(0);
            dfs(lowSet, low,0);
            dfs(heightSet, height,0);
            if (flag2) {
                lowSet.remove(0);
                heightSet.remove(0);
            }
            if (!flag) {
                lowSet.remove(temp);
                heightSet.remove(-temp);
            }
            for (Integer d : lowSet) {
                if (heightSet.contains(-d) || (d == 0 && height.contains(0))) {
                    return true;
                }
            }
            return false;
        }

        private void dfs(HashSet<Integer> set, ArrayList<Integer> nums, int index) {
            if (index == nums.size()) {
                return;
            }
            HashSet<Integer> temp = new HashSet<>();
            for (Integer d : set) {
                temp.add(d + nums.get(index));
            }
            set.addAll(temp);
            dfs(set,nums,index + 1);
        }
    }
}
