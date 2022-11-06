package two;

import java.util.ArrayList;
import java.util.List;

/**
 * 902. 最大为 N 的数字组合
 *
 * @author yangxiaozhuo
 * @date 2022/10/18
 */
public class Main18 {
    class Solution {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            String s = Integer.toString(n);
            int m = digits.length, k = s.length();
            List<Integer> bits = new ArrayList<Integer>();
            boolean isLimit = true;
            for (int i = 0; i < k; i++) {
                if (!isLimit) {
                    bits.add(m - 1);
                } else {
                    int selectIndex = -1;
                    for (int j = 0; j < m; j++) {
                        if (digits[j].charAt(0) <= s.charAt(i)) {
                            selectIndex = j;
                        } else {
                            break;
                        }
                    }
                    if (selectIndex >= 0) {
                        bits.add(selectIndex);
                        if (digits[selectIndex].charAt(0) < s.charAt(i)) {
                            isLimit = false;
                        }
                    } else {
                        int len = bits.size();
                        while (!bits.isEmpty() && bits.get(bits.size() - 1) == 0) {
                            bits.remove(bits.size() - 1);
                        }
                        if (!bits.isEmpty()) {
                            bits.set(bits.size() - 1, bits.get(bits.size() - 1) - 1);
                        } else {
                            len--;
                        }
                        while (bits.size() <= len) {
                            bits.add(m - 1);
                        }
                        isLimit = false;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < bits.size(); i++) {
                ans = ans * m + (bits.get(i) + 1);
            }
            return ans;
        }
    }
}
