package three;

import java.util.Arrays;

/**
 * 2037. 使每位学生都有座位的最少移动次数
 *
 * @author yangxiaozhuo
 * @date 2022/12/31
 */
public class Main31 {
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
}
