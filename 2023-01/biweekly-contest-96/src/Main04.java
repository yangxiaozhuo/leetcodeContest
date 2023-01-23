/**
 * @author yangxiaozhuo
 * @date 2023/01/21
 */
public class Main04 extends Thread {
    public static void main(String[] args) {
    }

    static class Solution {
        public boolean isReachable(int targetX, int targetY) {
            while (targetX > 1 && targetY > 1) {
                if (targetY > targetX) {
                    if (targetY % 2 == 0) {
                        targetY /= 2;
                    } else {
                        targetY = targetY - targetX;
                    }
                } else if (targetY < targetX) {
                    if (targetX % 2 == 0) {
                        targetX /= 2;
                    } else {
                        targetX = targetX - targetY;
                    }
                } else {
                    if (targetX % 2 == 1) {
                        return false;
                    } else {
                        targetX /= 2;
                    }
                }
            }
            if (targetX <= 0 || targetY <= 0) {
                return false;
            }
            return true;
        }

    }
}
