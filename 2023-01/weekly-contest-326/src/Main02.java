import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/01/01
 */
public class Main02 {
    class Solution {
        public int distinctPrimeFactors(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums) {
                for(int i = 2; i < num; i++) {
                    while(num % i == 0) {
                        set.add(i);
                        num /= i;
                    }
                }
                if(num != 1) {
                    set.add(num);
                }
            }
            return set.size();
        }
    }
}
