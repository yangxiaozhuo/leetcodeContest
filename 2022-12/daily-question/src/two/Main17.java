package two;

/**
 * 1764. 通过连接另一个数组的子数组得到一个数组
 * @author yangxiaozhuo
 * @date 2022/12/17
 */
public class Main17 {
    class Solution {
        public boolean canChoose(int[][] groups, int[] nums) {
            int len = 0;
            for(int[] i : groups) {
                len += i.length;
            }
            if(nums.length < len) {
                return false;
            }
            int index = 0;
            for(int i = 0; i < nums.length; ) {
                if(fun(nums, groups[index], i)) {
                    i = i + groups[index].length;
                    index++;
                    if(index == groups.length) {
                        return true;
                    }
                } else {
                    i++;
                }
            }
            return false;
        }
        public boolean fun(int[] nums, int[] group, int i) {
            for(int j = 0; j < group.length; j++) {
                if(i == nums.length) {
                    return false;
                }
                if(group[j] != nums[i]) {
                    return false;
                } else {
                    i++;
                }
            }
            return true;
        }
    }
}
