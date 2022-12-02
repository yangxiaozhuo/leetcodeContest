package one;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author yangxiaozhuo
 * @date 2022/12/01
 */
public class Main01 {
    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int res = -1;
            int min = 0;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == x || points[i][1] == y) {
                    int temp = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                    if(res == -1 || temp < min) {
                        res = i;
                        min = temp;
                    }
                }
            }
            return res;
        }
    }
}
