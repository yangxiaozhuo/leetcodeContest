package three;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author yangxiaozhuo
 * @date 2022/12/30
 */
public class Main30 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }
    static class ExamRoom {
        TreeSet<Integer> set;
        int r;
        public ExamRoom(int n) {
            set = new TreeSet<>();
            r = n - 1;
        }

        public int seat() {
            if(set.isEmpty()) {
                set.add(0);
                return 0;
            }
            int pre = -1;
            int max = 0;
            int res = 0;
            for(int i : set) {
                if(pre == -1) {
                    max = i;
                } else if((i - pre) / 2 > max) {
                    max = (i - pre) / 2 ;
                    res = i + pre >> 1;
                }
                pre = i;
            }
            if(r - pre > max) {
                res = r;
            }
            set.add(res);
            return res;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
