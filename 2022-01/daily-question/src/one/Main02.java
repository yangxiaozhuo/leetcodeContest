package one;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/01/02
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        System.out.println(solution.getNumberOfBacklogOrders(ints));
    }

    static class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            HashMap<Integer, Long> cellMap = new HashMap<>(); // 价格 - 数量
            HashMap<Integer, Long> buylMap = new HashMap<>(); // 价格 - 数量
            PriorityQueue<Integer> cell = new PriorityQueue<>();
            PriorityQueue<Integer> buy = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int[] order : orders) {
                if (order[2] == 1) {
                    while (!buy.isEmpty() && buy.peek() >= order[0] && order[1] > 0) {
                        if (order[1] >= buylMap.get(buy.peek())) {
                            order[1] -= buylMap.get(buy.peek());
                            buylMap.remove(buy.poll());
                        } else {
                            buylMap.put(buy.peek(), buylMap.get(buy.peek()) - order[1]);
                            order[1] = 0;
                        }
                    }
                    if (order[1] > 0) {
                        if (cellMap.containsKey(order[0])) {
                            cellMap.put(order[0], cellMap.get(order[0]) + order[1]);
                        } else {
                            cellMap.put(order[0], (long) order[1]);
                            cell.add(order[0]);
                        }
                    }
                } else {
                    while (!cell.isEmpty() && cell.peek() <= order[0] && order[1] > 0) {
                        if (order[1] >= cellMap.get(cell.peek())) {
                            order[1] -= cellMap.get(cell.peek());
                            cellMap.remove(cell.poll());
                        } else {
                            cellMap.put(cell.peek(), cellMap.get(cell.peek()) - order[1]);
                            order[1] = 0;
                        }
                    }
                    if (order[1] > 0) {
                        if (buylMap.containsKey(order[0])) {
                            buylMap.put(order[0], buylMap.get(order[0]) + order[1]);
                        } else {
                            buylMap.put(order[0], (long) order[1]);
                            buy.add(order[0]);
                        }
                    }
                }
            }
            long res = 0;
            int mod = 1000_000_007;
            for (Map.Entry<Integer, Long> entry : cellMap.entrySet()) {
                res = res + entry.getValue();
                res = res % mod;
            }
            for (Map.Entry<Integer, Long> entry : buylMap.entrySet()) {
                res = res + entry.getValue();
                res = res % mod;
            }
            return (int) res;
        }
    }
}
