package two;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 857. 雇佣 K 名工人的最低成本
 *
 * @author yangxiaozhuo
 * @date 2022/09/11
 */
public class Main11 {
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            double[][] works = new double[quality.length][2];
            for (int i = 0; i < quality.length; i++) {
                works[i] = new double[]{(double) wage[i] / quality[i], quality[i]};
            }
            Arrays.sort(works, (a, b) -> Double.compare(a[0], b[0]));
            PriorityQueue<Double> queue = new PriorityQueue<>();
            double res = Double.MAX_VALUE;
            double qsum = 0.0; //qsum保存K个工人的质量和
            for (double[] work : works) {
                qsum = qsum + work[1];
                queue.add(-work[1]);
                if (queue.size() > k) {
                    qsum = qsum + queue.poll();
                }
                if (queue.size() == k) {
                    res = Math.min(res, qsum * work[0]);
                }
            }
            return res;
        }
    }
}
