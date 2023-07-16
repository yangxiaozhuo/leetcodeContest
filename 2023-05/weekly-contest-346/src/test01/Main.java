package test01;

/**
 * @author yangxiaozhuo
 * @date 2023/05/21
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minLength("ABFCACDB"));
    }
}
class Solution {
    public int minLength(String s) {
        int len = s.length();
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB","");
            s = s.replace("CD","");
        }
        return s.length();
    }
}