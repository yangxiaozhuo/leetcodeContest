package text02;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/04/01
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,2};  //[998,2]  true
    }
}

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('a'+i), i + 1);
        }
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(s.charAt(i));
        }
        int res = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp < 0) {
                temp = 0;
            }
            res = Math.max(temp, res);
        }
        return res;
    }
}