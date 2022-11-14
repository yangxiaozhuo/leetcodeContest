import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2460. 没过
 *
 * @author yangxiaozhuo
 * @date 2022/11/06
 */public class Main04 {
    public static void main(String[] args) {
//        [9,11,99,101]
//[[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]
        Solution solution = new Solution();
        ArrayList<Integer> robot = new ArrayList<>();
        robot.add(9);
        robot.add(11);
        robot.add(99);
        robot.add(101);
        int[][] factory = new int[][]{{7, 1}, {10, 1}, {14, 1}, {96, 1}, {100, 1}, {103, 1}};
        System.out.println(solution.minimumTotalDistance(robot, factory));
    }

    static class Solution {
        public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
            return 0;
        }
    }
}
