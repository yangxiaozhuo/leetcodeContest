package text01;

import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [54,6,34,66,63,52,39,62,46,75,28,65,18,37,18,13,33,69,19,40,13,10,43,61,72]
//7   618
        int[] ints = new int[]{54, 6, 34, 66, 63, 52, 39, 62, 46, 75, 28, 65, 18, 37, 18, 13, 33, 69, 19, 40, 13, 10, 43, 61, 72};
        System.out.println(solution.pickGifts(ints, 7));
    }
}

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < gifts.length; i++) {
            queue.add(gifts[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            double sqrt = Math.sqrt(poll);
            int temp = (int) (sqrt);
            queue.add(temp);
        }
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}