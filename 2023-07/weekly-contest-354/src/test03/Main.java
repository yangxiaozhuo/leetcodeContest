import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int max = nums.get(0);
        int sum = 1;
        for (int i = 1 ; i < nums.size(); i++) {
            if (max == nums.get(i)) {
                sum++;
            } else {
                sum--;
                if (sum == -1) {
                    sum = 1;
                    max = nums.get(i);
                }
            }
        }
        sum = 0;
        for (Integer num : nums) {
            if (num == max) {
                sum++;
            }
        }
        // max 有sum个
        int l = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == max) {
                l++;
            }
            if (l * 2 > (i + 1) && (sum - l) * 2 > (nums.size() - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}