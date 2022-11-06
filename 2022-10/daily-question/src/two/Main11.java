package two;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author yangxiaozhuo
 * @date 2022/10/11
 */
public class Main11 {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {

            char[] c1 = s1.toCharArray();
            char[] c2= s2.toCharArray();
            char char1 = ' ';
            char char2 = ' ';
            int num = 0;
            for(int i = 0; i <c1.length; i++) {
                if(c1[i]==c2[i]) {
                    continue;
                } else {
                    num++;
                    if(num>2) {
                        return false;
                    } else if(num==1){
                        char1 = c1[i];
                        char2 = c2[i];
                    } else if(num == 2) {
                        if(c1[i]==char2&&c2[i]==char1) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if(num!=1) {
                return true;
            }
            return false;
        }
    }
}
