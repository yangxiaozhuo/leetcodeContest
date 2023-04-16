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
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0;
        int maxid = 0;
        for(int i = 0; i < mat.length; i++) {
            int sum = 0;
            for(int num : mat[i]) {
                sum += num;
            }
            if(sum > max) {
                max = sum;
                maxid = i;
            }
        }
        return new int[]{maxid ,max};
    }
}