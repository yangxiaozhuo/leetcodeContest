package text02;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2023/04/09
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 1, 1, 2};  //[998,2]  true
        System.out.println(Arrays.toString(solution.distance(nums)));
    }
}

class Solution {
    public long[] distance(int[] nums) {
        long[] res = new long[nums.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ArrayList<Integer> arrayList = map.get(nums[i]);
                arrayList.add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(nums[i], arrayList);
            }
        }
        HashMap<Integer, long[]> sum = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            if (value.size() > 1) {
                long[] temp = new long[value.size() + 1];
                for (int i = 0; i < value.size(); i++) {
                    temp[i + 1] = temp[i] + value.get(i);
                }
                sum.put(key, temp);
            }
        }
        for (int i = 0; i < res.length; i++) {
            int t = nums[i];
            ArrayList<Integer> arrayList = map.get(t);
            if (arrayList.size() == 1) {
                res[i] = 0;
            } else {
                res[i] = fun(i, map.get(t), sum.get(t));
            }
        }
        return res;
    }

    private long fun(int t, ArrayList<Integer> arr, long[] sum) {
        int index = find(arr, t);
        long res = (index+1) * (long)t - sum[index + 1] + sum[sum.length - 1] - sum[index + 1] - (arr.size() - index - 1) * (long)t;
        return res;
    }

    private int find(ArrayList<Integer> arr, int t) {
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr.get(mid) < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}