package one;

/**
 * 1694. 重新格式化电话号码
 *
 * @author yangxiaozhuo
 * @date 2022/10/01
 */
public class Main01 {
    public static void main(String[] args) {

    }
    static class Solution {
        public String reformatNumber(String number) {
            StringBuffer sb = new StringBuffer(number);
            for(int i = 0; i < sb.length(); ) {
                if(sb.charAt(i)=='-' || sb.charAt(i)==' ') {
                    sb.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            StringBuffer res = new StringBuffer();
            int index = 0;
            if(sb.length() == 4) {
                return sb.substring(0,2) + "-" + sb.substring(2,4);
            }
            for(int i = 0; i < sb.length(); i++){
                res.append(sb.charAt(i));
                index++;
                if(index == 3 && i != sb.length() - 1) {
                    index = 0;
                    res.append('-');
                    if(i == sb.length() - 5) {
                        res.append(sb.charAt(i + 1));
                        res.append(sb.charAt(i + 2));
                        res.append('-');
                        res.append(sb.charAt(i + 3));
                        res.append(sb.charAt(i + 4));
                        return res.toString();
                    }
                }
            }
            return res.toString();
        }
    }
}
