package test1;

/**
 * @author yangxiaozhuo
 * @date 2023/05/13
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (int i = 0; i < details.length; i++) {
            String detail = details[i];
            String substring = detail.substring(11, 13);
            if (Integer.parseInt(substring) > 60) {
                res++;
            }
        }
        return res;
    }
}
