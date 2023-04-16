package text02;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/04/02
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};  //[998,2]  true
    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] t = new int[210];
        for (int num : nums) {
            t[num]++;
        }
        List<List<Integer>> res = new ArrayList<>();
        while (true) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int i = 0; i < t.length; i++) {
                if (t[i] != 0) {
                    inner.add(i);
                    t[i]--;
                }
            }
            if (inner.isEmpty()) {
                return res;
            }
            res.add(inner);
        }
    }
}