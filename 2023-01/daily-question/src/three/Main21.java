package three;

/**
 * @author yangxiaozhuo
 * @date 2023/01/21
 */
public class Main21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{0,1,2,3,0};
        System.out.println(solution.minSideJumps(ints));
    }
    static class Solution {
        public int minSideJumps(int[] obstacles) {
            int res = 0;
            int at = 2;
            int index = 0;
            for(; index < obstacles.length; index++) {
                if(obstacles[index] == 2) {
                    break;
                }
            }
            while(index < obstacles.length - 1) {
                int[] temp = fun(at, index, obstacles);
                at = temp[0];
                index = temp[1];
                res++;
            }
            return res;
        }
        public int[] fun(int at, int index, int[] obstacles) {
            int a = 0;
            int b = 0;
            if(at == 1) {
                a = 2;b = 3;
            } else if(at == 2) {
                a = 1; b = 3;
            } else {
                a = 1; b = 2;
            }
            boolean aFlag = true;
            boolean bFlag = true;
            if(obstacles[index - 1] == a){
                aFlag = false;
            } else if(obstacles[index - 1] == b) {
                bFlag = false;
            }
            int[] res = new int[2];
            for(int i = index; i < obstacles.length; i++) {
                if(obstacles[i] == a) {
                    aFlag = false;
                } else if(obstacles[i] == b) {
                    bFlag = false;
                }
                if(!aFlag && !bFlag) {
                    res[1] = i;
                    if(obstacles[i] == a) {
                        res[0] = a;
                    } else if(obstacles[i] == b) {
                        res[0] = b;
                    }
                    return res;
                }
            }
            res[1] = obstacles.length;
            return res;
        }
    }
}
