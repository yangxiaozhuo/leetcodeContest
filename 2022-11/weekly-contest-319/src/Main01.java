/**
 * 6233. 温度转换
 *
 * @author yangxiaozhuo
 * @date 2022/11/13
 */
public class Main01 {
    public static void main(String[] args) {

    }

    class Solution {
        public double[] convertTemperature(double celsius) {
            double a = celsius + 273.15;
            double b = celsius * 1.80 + 32.00;
            return new double[]{a, b};
        }
    }
}
