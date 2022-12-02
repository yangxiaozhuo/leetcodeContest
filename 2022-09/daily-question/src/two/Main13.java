package two;

import java.util.Arrays;

/**
 * 670. 最大交换
 *
 * @author yangxiaozhuo
 * @date 2022/09/13
 */
public class Main13 {
    class Solution {
        public int maximumSwap(int num) {
            String s = num + "";
            char[] chars2 = s.toCharArray();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (int i = 0; i < chars.length; i++) {
                if (chars[chars.length - 1 - i] != chars2[i]) {
                    for (int j = s.length() - 1; j >= i + 1; j--) {
                        if (chars2[j] == chars[chars.length - 1 - i]) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int k = 0; k < i; k++) {
                                stringBuffer.append(chars2[k]);
                            }
                            stringBuffer.append(chars2[j]);
                            for (int k = i + 1; k < j; k++) {
                                stringBuffer.append(chars2[k]);
                            }
                            stringBuffer.append(chars2[i]);
                            for (int k = j + 1; k < s.length(); k++) {
                                stringBuffer.append(chars2[k]);
                            }
                            return Integer.parseInt(stringBuffer.toString());
                        }
                    }
                }
            }
            return num;
        }
    }
}
