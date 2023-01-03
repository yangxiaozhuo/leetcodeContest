import java.util.*;

/**
 * @author yangxiaozhuo
 * @date 2022/12/24
 */
public class Main02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        ["smart","brilliant","studious"]
//["not"]
//["this student is studious","the student is smart"]
//[1,2]
//        2
        String[] a = {"smart", "brilliant", "studious" };
        String[] b = {"not" };
        String[] c = {"this student is not studious", "the student is smart" };
        int[] d = {1, 2};
        System.out.println(solution.topStudents(a, b, c, d, 2));

    }

    static class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            HashSet<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
            HashSet<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < student_id.length; i++) {
                String[] s1 = report[i].split(" ");
                int temp = 0;
                for (String s : s1) {
                    if (negative.contains(s)) {
                        temp -= 1;
                    } else if (positive.contains(s)){
                        temp += 3;
                    }
                }
                map.put(student_id[i], map.getOrDefault(student_id[i], 0) + temp);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.add(new int[]{entry.getValue(), entry.getKey()});
            }
            ArrayList<Integer> res = new ArrayList<>();
            while (k > 0) {
                k--;
                int[] poll = queue.poll();
                res.add(poll[1]);
            }
            return res;
        }
    }
}
