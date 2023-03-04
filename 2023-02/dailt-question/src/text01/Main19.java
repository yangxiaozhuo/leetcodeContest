package text01;

import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/19
 */
public class Main19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1, 2}, {3, 5}, {2, 2}};
        System.out.println(solution.maxAverageRatio(ints, 2));
    }

    static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<double[]> queue = new PriorityQueue<double[]>((o1, o2) -> {
                if (o1[0] > o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            });
            for (int i = 0; i < classes.length; i++) {
                double temp = (classes[i][0] + 1) / ((double) classes[i][1] + 1) - classes[i][0] / (double) classes[i][1];
                queue.add(new double[]{temp, classes[i][0], classes[i][1]});
            }
            while (extraStudents-- > 0) {
                double[] temp = queue.poll();
                temp[1]++;
                temp[2]++;
                temp[0] = (temp[1] + 1) / (temp[2] + 1) - temp[1] / temp[2];
                queue.add(temp);
            }
            double res = 0;
            while (!queue.isEmpty()) {
                double[] temp = queue.poll();
                res += temp[1] / temp[2];
            }
            return res / classes.length;
        }
    }
}
