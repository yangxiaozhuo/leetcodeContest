package two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1636. 按照频率将数组升序排序
 *
 * @author yangxiaozhuo
 * @date 2022/10/19
 */
public class Main19 {
    class Solution {
        public int[] frequencySort(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int num :
                    nums) {
                list.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    Integer val1 = map.get(o1);
                    Integer val2 = map.get(o2);
                    if(val1.equals(val2)) return o2-o1;
                    else return val1-val2;
                }
            });
            for (int i = 0; i < nums.length; i++) {
                nums[i] = list.get(i);
            }
            return nums;
        }
    }
}
