package two;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 672. 灯泡开关 Ⅱ
 *
 * @author yangxiaozhuo
 * @date 2022/09/15
 */
public class Main15 {
    class Solution {
        HashSet<String> set = new HashSet<>();

        public int flipLights(int n, int presses) {
            if (presses > 4) return flipLights(n, presses - 2);
            boolean[] light = new boolean[n];
            Arrays.fill(light, true);
            fun(n, presses, 0, light);
            return set.size();
        }

        public void fun(int n, int presses, int index, boolean[] light) {
            if (presses == index) {
                set.add(Arrays.toString(light));
                return;
            }
            boolean[] light1 = Arrays.copyOf(light, light.length);
            boolean[] light2 = Arrays.copyOf(light, light.length);
            boolean[] light3 = Arrays.copyOf(light, light.length);
            boolean[] light4 = Arrays.copyOf(light, light.length);
            for (int i = 0; i < light.length; i++) {
                light1[i] = !light1[i];
            }
            fun(n, presses, index + 1, light1);

            for (int i = 0; i < light.length; i = i + 2) {
                light2[i] = !light2[i];
            }
            fun(n, presses, index + 1, light2);

            for (int i = 1; i < light.length; i = i + 2) {
                light3[i] = !light3[i];
            }
            fun(n, presses, index + 1, light3);

            for (int i = 0; i < light.length; i = i + 3) {
                light4[i] = !light4[i];
            }
            fun(n, presses, index + 1, light4);

        }
    }
}
