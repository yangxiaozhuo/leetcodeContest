import java.util.Arrays;

/**
 * 2433. 找出前缀异或的原始数组
 *
 * @author yangxiaozhuo
 * @date 2022/10/09
 *
 * 给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * 注意 ^ 表示 按位异或（bitwise-xor）运算。
 * 可以证明答案是 唯一 的。
 * <p>
 * 示例 1：
 * 输入：pref = [5,2,0,3,1]
 * 输出：[5,7,2,3,2]
 * 解释：从数组 [5,7,2,3,2] 可以得到如下结果：
 * - pref[0] = 5
 * - pref[1] = 5 ^ 7 = 2
 * - pref[2] = 5 ^ 7 ^ 2 = 0
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pref = new int[]{5, 2, 0, 3, 1};
        System.out.println(Arrays.toString(solution.findArray(pref)));
    }

    static class Solution {
        public int[] findArray(int[] pref) {
            int[] res = new int[pref.length];
            int sum = pref[0];
            res[0] = pref[0];
            for (int i = 1; i < pref.length; i++) {
                res[i] = sum ^ pref[i];
                sum = sum ^ res[i];
            }
            return res;
        }
    }
}
