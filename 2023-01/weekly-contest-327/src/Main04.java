import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/01/08
 */
public class Main04 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1,9,1,8},{10,10,10,10}};
        System.out.println(solution.findCrossingTime(3, 2, ints));
    }

    static class Solution {
        int time = 0;
        PriorityQueue<int[]> left;
        PriorityQueue<int[]> right;   //0,1,2,3,序号
        ArrayList<int[]> rightCache;
        ArrayList<int[]> leftCache;   //0,1,2,3,序号，时间
        int n;
        int k;

        public int findCrossingTime(int n, int k, int[][] time) {
            rightCache = new ArrayList<>();
            leftCache = new ArrayList<>();
            this.k = k;
            this.n = n;
            left = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] + o1[2] == o2[0] + o2[2]) {
                    return o2[4] - o1[4];
                }
                return o2[0] + o2[2] - o1[0] - o1[2];
            });
            right = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] + o1[2] == o2[0] + o2[2]) {
                    return o2[4] - o1[4];
                }
                return o2[0] + o2[2] - o1[0] - o1[2];
            });
            for (int i = 0; i < time.length; i++) {
                left.add(new int[]{time[i][0], time[i][1], time[i][2], time[i][3], i, 0});
            }
            fun();
            return this.time;
        }

        private void fun() {
            if (n == 0) {
                while (!right.isEmpty() || !rightCache.isEmpty()) {
                    if (!right.isEmpty()) {
                        addtime(right.poll()[2]);
                    } else {
                        int min = rightCache.get(0)[5];
                        for (int[] arr : rightCache) {
                            min = Math.min(min, arr[5]);
                        }
                        addtime(min - time);
                    }
                }
                return;
            }
            while (!right.isEmpty()) {
                int[] poll = right.poll();
                addtime(poll[2]);
                poll[5] = time + poll[3];
                leftCache.add(poll);
            }
            if (!left.isEmpty()) {
                n--;
                int[] poll = left.poll();
                addtime(poll[0]);
                poll[5] = time + poll[1];
                rightCache.add(poll);
                fun();
                return;
            }
            int min = Integer.MAX_VALUE;
            for (int[] arr : leftCache) {
                min = Math.min(min, arr[5]);
            }
            for (int[] arr : rightCache) {
                min = Math.min(min, arr[5]);
            }
            addtime(min - time);
            fun();
        }

        private void addtime(int i) {
            time += i;
            for (int j = 0; j < rightCache.size();) {
                if (rightCache.get(j)[5] <= time) {
                    right.add(rightCache.get(j));
                    rightCache.remove(j);
                } else {
                    j++;
                }
            }
            for (int j = 0; j < leftCache.size();) {
                if (leftCache.get(j)[5] <= time) {
                    left.add(leftCache.get(j));
                    leftCache.remove(j);
                } else {
                    j++;
                }
            }
        }

        private void allRightToLeft() {
            while (!right.isEmpty()) {
                ArrayList<int[]> arrayList = new ArrayList<>();
                while (!right.isEmpty()) {
                    int[] poll = right.poll();
                    if (poll[5] <= time) {
                        time += poll[2];
                        if (!arrayList.isEmpty()) {
                            right.addAll(arrayList);
                        }
                        poll[5] = poll[5] + poll[2] + poll[3];
                        left.add(poll);
                    } else {
                        arrayList.add(poll);
                    }
                }
                if (!arrayList.isEmpty()) {
                    int min = arrayList.get(0)[5];
                    for (int[] arr : arrayList) {
                        min = Math.min(min, arr[5]);
                    }
                    time = min;
                    right.addAll(arrayList);
                }
            }
            return;
        }
    }
}
