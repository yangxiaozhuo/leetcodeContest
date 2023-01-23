import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/01/15
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{3,1,4,3,2,2,4};

        System.out.println(solution.countGood(ints, 2));
    }

    static class Solution {
        public long countGood(int[] nums, int k) {
            int l = 0;
            int r = 0;
            long res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            long temp = 0;
            while (r < nums.length) {
                long t = ad(map, nums[r]);
                r++;
                temp = t + temp;
                while (temp >= k) {
                    res = res + nums.length - r + 1;
                    long tt = rm(map, nums[l]);
                    temp = temp - tt;
                    l++;
                }
            }
            return res;
        }

        private long rm(HashMap<Integer, Integer> map, int num) {
            long integer = map.get(num);
            long yuanlai = integer * (integer - 1) / 2;
            long xz = (integer - 2) * (integer - 1) / 2;
            map.put(num, (int)integer - 1);
            return yuanlai - xz;
        }

        private long ad(HashMap<Integer, Integer> map, int num) {
            long yuanlai = 0;
            long orDefault = map.getOrDefault(num, 0);
            if (orDefault != 0) {
                yuanlai = orDefault * (orDefault - 1) / 2;
            }
            map.put(num, (int)orDefault + 1);
            long xz = orDefault * (orDefault + 1) / 2;
            return xz - yuanlai;
        }
    }
}
