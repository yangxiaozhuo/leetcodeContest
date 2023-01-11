import javax.swing.border.StrokeBorder;

/**
 * @author yangxiaozhuo
 * @date 2023/01/07
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            boolean Bulky = false;
            boolean Heavy = false;
            if (length >= 10000 || width >= 10000 || height >= 10000 || length * width * height >= 1000000000) {
                Bulky = true;
            }
            if (mass >= 100){
                Heavy = true;
            }
            if (Heavy && Bulky) {
                return "Both";
            }
            if (!Heavy && !Bulky) {
                return "Neither";
            }
            if (Heavy) {
                return "Heavy";
            }
            if (Bulky) {
                return "Bulky";
            }
            return "";
        }
    }
}
