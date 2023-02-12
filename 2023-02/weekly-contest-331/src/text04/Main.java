package text04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [84,80,43,8,80,88,43,14,100,88]
//[32,32,42,68,68,100,42,84,14,8]   48 我是117
//        43, 43, 80, 80, 88, 88,
//        32, 32, 42, 42, 68, 68,
        int[] ints = new int[]{8, 14, 43, 43, 80, 80, 84, 88, 88, 100};
        int[] ints2 = new int[]{8, 14, 32, 32, 42, 42, 68, 68, 84, 100};
        Arrays.sort(ints);
        Arrays.sort(ints2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
        System.out.println(solution.minCost(ints, ints2));
    }
}

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        long min = basket1[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {
            min = Math.min(min, basket1[i]);
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            map1.put(basket1[i], map1.getOrDefault(basket1[i], 0) + 1);
        }
        for (int i = 0; i < basket2.length; i++) {
            min = Math.min(min, basket2[i]);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) + 1);
            map2.put(basket2[i], map2.getOrDefault(basket2[i], 0) + 1);
        }
        for (Integer integer : map.values()) {
            if (integer % 2 != 0) {
                return -1;
            }
        }
        long res = 0;
        long sum = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int should = entry.getValue() / 2;
            int have = map1.getOrDefault(entry.getKey(), 0);
            if (should - have != 0) {
                sum = sum + Math.abs(should - have);
                queue.add(new int[]{entry.getKey(), Math.abs(should - have)});
            }
        }
        sum = sum / 2;
        while (sum > 0) {
            int[] poll = queue.poll();
            if (sum >= poll[1]) {
                sum -= poll[1];
                if (poll[0] < 2 * min) {
                    res = res + poll[0] * (long)poll[1];
                } else {
                    res = res +  (long)2 * min * poll[1];
                }
            } else {
                if (poll[0] < 2 * min) {
                    res = res + poll[0] * sum;
                } else {
                    res = res +  (long)2 * min * sum;
                }
                sum -= poll[1];
            }
        }
        return res;
    }
}