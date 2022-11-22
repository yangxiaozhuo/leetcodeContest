package two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 775. 全局倒置与局部倒置
 *
 * @author yangxiaozhuo
 * @date 2022/11/16
 */
public class Main16 {
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int all = 0;
            int local = 0;
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < nums.length; i++) {
                set.add(i);
            }
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] > nums[i + 1]) {
                    local++;
                }
            }
            for(int i = 0; i < nums.length; i++) {
                all += find(nums[i], set);
            }
            return all == local;
        }
        public int find(int nums, TreeSet<Integer> set) {
            int size = set.headSet(nums,false).size();
            set.remove(nums);
            return size;
        }
    }
}
