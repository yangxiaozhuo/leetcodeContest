package text02;

/**
 * @author yangxiaozhuo
 * @date 2023/04/16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 1, 1, 2};  //[998,2]  true
        System.out.println(solution.sumOfMultiples(10));
    }
}

class Solution {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) || (i % 5) == 0 || (i % 7) == 0) {
                res += i;
            }
        }
        return res;
    }

    private int fun(int n) {
        int res = 0;
        while (n != 0) {
            res  = res + (n % 10);
            n = n / 10;
        }
        return res;
    }
}