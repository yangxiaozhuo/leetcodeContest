import java.util.Arrays;

/**
 * @author yangxiaozhuo
 * @date 2022/12/04
 */
public class Main2 {
    public static void main(String[] args) {

    }
    static class Solution {
        public long dividePlayers(int[] skill) {
            int sum = 0;
            for (int a : skill) {
                sum += a;
            }
            if(sum % (skill.length / 2) != 0) {
                return -1;
            }
            int target = sum / (skill.length / 2);
            long res = 0;
            Arrays.sort(skill);
            for (int i = 0; i < skill.length / 2; i++) {
                if(skill[i] + skill[skill.length - 1- i] != target) {
                    return -1;
                } else {
                    res = res + skill[i] * skill[skill.length - 1- i];
                }
            }
            return res;
        }
    }
}
