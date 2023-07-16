package test02;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/07/08
 */
public class Main {
}

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            if (moveTo[i] == moveFrom[i]) {
                continue;
            }
            map.put(moveTo[i], map.getOrDefault(moveTo[i], 0) +map.getOrDefault(moveFrom[i], 0));
            map.put(moveFrom[i], 0);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }
}