package text01;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}