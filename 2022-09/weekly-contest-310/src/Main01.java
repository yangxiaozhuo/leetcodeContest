import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * @author yangxiaozhuo
 * @date 2022/11/11
 */
public class Main01 {
    class Solution {
        public int mostFrequentEven(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums) {
                if(num%2==0) {
                    map.put(num, map.getOrDefault(num,0) + 1);
                }
            }
            int max = 0;
            int res = -1;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    res = entry.getKey();
                } else if(entry.getValue() == max && entry.getKey() < res) {
                    res = entry.getKey();
                }
            }
            return res;
        }
    }
}
