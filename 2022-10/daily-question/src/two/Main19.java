package two;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * @author yangxiaozhuo
 * @date 2022/10/19
 */
public class Main19 {
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int len = students.length;
            int[] vis = new int[len];
            int index = 0;
            int k = 0;
            while (k < len) {
                int temp = k;
                for (int i = 0; i < students.length; i++) {
                    int j = (i + index) % len;
                    if (vis[j] == 0 && students[j] == sandwiches[k]) {
                        k++;
                        vis[j] = 1;
                    }
                }
                if (k == temp) {
                    return len - k;
                }
            }
            return 0;
        }
    }
}
