import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yangxiaozhuo
 * @date 2023/01/01
 */
public class Main03 {
    class Solution {
        public int minimumPartition(String s, int k) {
            char[] chars = s.toCharArray();
            if (k < 10) {
                for (char c : chars) {
                    if (k < (c - '0')) {
                        return -1;
                    }
                }
                return s.length();
            }
            int res = 0;
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                if (temp * 10 + chars[i] - '0' > k) {
                    res++;
                    temp = chars[i] - '0';
                } else {
                    temp = temp * 10 + chars[i] - '0';
                }
            }
            return res;
        }
    }
}
