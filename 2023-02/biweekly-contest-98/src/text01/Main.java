package text01;


/**
 * @author yangxiaozhuo
 * @date 2023/02/18
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{5, 1, 1, 2, 0, 0};
    }
}

class Solution {
    public int minMaxDifference(int num) {
        String s = "" + num;
        int max = num;
        int min = num;
        for (int i = 0; i < 9; i++) {
            String a = s.replaceAll(""+i, "9");
            max = Math.max(max, Integer.parseInt(a));
            a = s.replaceAll(""+i, "0");
            min = Math.min(min, Integer.parseInt(a));
        }
        return max - min;
    }
}