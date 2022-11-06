package two;

import java.util.HashMap;

/**
 * 904. 水果成篮
 *
 * @author yangxiaozhuo
 * @date 2022/10/17
 */
public class Main17 {
    class Solution {
        public int totalFruit(int[] fruits) {
            HashMap<Integer, Integer> map = new HashMap<>(); //key-水果 value-水果数量
            int l = 0;
            int r = 0;
            int max = 0;
            while (r < fruits.length) {
                if (map.containsKey(fruits[r])) {
                    while (r < fruits.length && map.containsKey(fruits[r])) {
                        map.put(fruits[r], map.get(fruits[r]) + 1);
                        r++;
                    }
                } else { //如果没有拿这个水果
                    if (map.size() < 2) {  //如果只拿了0或者1种水果
                        map.put(fruits[r], 1);
                        r++;
                    } else {  //如果拿了两种水果
                        while (l < r) {
                            map.put(fruits[l], map.get(fruits[l]) - 1);
                            if (map.get(fruits[l]) == 0) {
                                map.remove(fruits[l]);
                                l++;
                                break;
                            }
                            l++;
                        }
                    }
                }
                max = Math.max(max, r - l);
            }
            return max;
        }
    }
}
