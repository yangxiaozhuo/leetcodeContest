/**
 * 2437. 有效时间的数目
 *
 * @author yangxiaozhuo
 * @date 2022/10/15
 * 给你一个长度为5的字符串time，表示一个电子时钟当前的时间，格式为"hh:mm"。最早可能的时间是"00:00"，最晚可能的时间是"23:59"。
 * 在字符串time中，被字符?替换掉的数位是 未知的，被替换的数字可能是0到9中的任何一个。
 * 请你返回一个整数answer，将每一个 ?都用0到9中一个数字替换后，可以得到的有效时间的数目。
 * <p>
 * 示例 1：
 * 输入：time = "?5:00"
 * 输出：2
 * 解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String time = "?5:00";
        System.out.println(solution.countTime(time));
    }

    static class Solution {
        public int countTime(String time) {
            int res = 1;
            if (time.charAt(3) == '?') {
                res = 6;
            }
            if (time.charAt(4) == '?') {
                res = res == 1 ? 10 : 60;
            }
            if (time.charAt(0) == '?' && time.charAt(1) == '?') {
                return res * 24;
            }
            if (time.charAt(1) == '?') {
                if (time.charAt(0) == '2') {
                    return res * 4;
                } else {
                    return res * 10;
                }
            }
            if (time.charAt(0) == '?') {
                if (time.charAt(1) > '3') {
                    return res * 2;
                } else {
                    return res * 3;
                }
            }
            return res;
        }
    }
}

