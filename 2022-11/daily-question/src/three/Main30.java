package three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 895. 最大频率栈
 *
 * @author yangxiaozhuo
 * @date 2022/11/30
 */
public class Main30 {
    public static void main(String[] args) {
//        FreqStack freqStack = new FreqStack();
////        ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"]
////[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//        freqStack.push(5);
//        freqStack.push(7);
//        freqStack.push(5);
//        freqStack.push(7);
//        freqStack.push(4);
//        freqStack.push(5);
//        System.out.println(freqStack.pop());
//        System.out.println(freqStack.pop());
//        System.out.println(freqStack.pop());
//        System.out.println(freqStack.pop());
        Solution solution = new Solution();
        int[][] tasks = new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(solution.minimumEffort(tasks));
    }

    /**
     * 1665. 完成所有任务的最少初始能量
     */
    static class Solution {
        public int minimumEffort(int[][] tasks) {
            int[][] ints = new int[tasks.length][3];
            for (int i = 0; i < tasks.length; i++) {
                ints[i][0] = tasks[i][0];
                ints[i][1] = tasks[i][1];
                ints[i][2] = tasks[i][1] - tasks[i][0];
            }
            Arrays.sort(ints, (o1, o2) -> o1[2] - o2[2]);
            int res = ints[0][2];
            for (int i = 0; i < tasks.length; i++) {
               if (res + ints[i][0] >= ints[i][1]) {
                   res = ints[i][0] + res;
               } else {
                   res = ints[i][1];
               }
            }
            return res;
        }
    }

    static class FreqStack {
        //        push 和 pop 的操作数不大于 2 * 104。
        int[] nums;
        int index;
        HashMap<Integer, Integer> map;
        PriorityQueue<int[]> queue;

        public FreqStack() {
            nums = new int[20_000];
            map = new HashMap<>();
            queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            });
            index = 0;
        }

        public void push(int val) {
            nums[index] = val;
            index++;
            int cnt = map.getOrDefault(val, 0) + 1;
            map.put(val, cnt);
            queue.add(new int[]{val, cnt, index});
        }

        public int pop() {
            int[] poll = queue.poll();
            map.put(poll[0], poll[1] - 1);
            while (index > 0 && nums[index - 1] == -1) {
                index--;
            }
            return poll[0];
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
