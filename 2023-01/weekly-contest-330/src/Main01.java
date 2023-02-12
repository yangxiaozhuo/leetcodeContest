/**
 * @author yangxiaozhuo
 * @date 2023/01/29
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(111);
    }
    static class Solution {
        public int countAsterisks(String s) {
            int res = 0;
            boolean flag = true;
            for(char c : s.toCharArray()) {
                if(c == '|') {
                    flag = !flag;
                } else if(c == '*') {
                    if(flag) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
