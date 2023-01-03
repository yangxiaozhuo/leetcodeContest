/**
 * @author yangxiaozhuo
 * @date 2022/12/24
 */
public class Main01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{-1,-1,0,1,0,0,1,-1,1,0};
        System.out.println(solution.captureForts(ints));
    }

    static class Solution {
        public int captureForts(int[] forts) {
            int res = 0;
            for (int i = 0; i < forts.length; i++) {
                if (forts[i] == 1) {
                    int sum = 0;
                    for (int j = i + 1; j < forts.length; j++) {
                        if (forts[j] == -1) {
                            res = Math.max(res, sum);
                            break;
                        } else if (forts[j] == 0) {
                            sum++;
                        } else {
                            break;
                        }
                    }
                }
            }
            for (int i = forts.length - 1; i >= 0; i--) {
                if (forts[i] == 1) {
                    int sum = 0;
                    for (int j = i - 1; j >= 0; j--) {
                        if (forts[j] == -1) {
                            res = Math.max(res, sum);
                            break;
                        } else if (forts[j] == 0) {
                            sum++;
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
