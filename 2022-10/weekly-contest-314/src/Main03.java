/**
 * 2434. 使用机器人打印字典序最小的字符串
 *
 * @author yangxiaozhuo
 * @date 2022/10/09
 *
 * 给你一个字符串s和一个机器人，机器人当前有一个空字符串t。执行以下操作之一，直到s 和t都变成空字符串：
 * 删除字符串s的 第一个字符，并将该字符给机器人。机器人把这个字符添加到 t的尾部。
 * 删除字符串t的最后一个字符，并将该字符给机器人。机器人将该字符写到纸上。
 * 请你返回纸上能写出的字典序最小的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "zza"
 * 输出："azz"
 * 解释：用 p 表示写出来的字符串。
 * 一开始，p="" ，s="zza" ，t="" 。
 * 执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
 * 执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
 */
public class Main03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.robotWithString("zza"));
    }

    static class Solution {
        public String robotWithString(String s) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder res = new StringBuilder();
            int r = 0;
            int c = 0;
            while (r < sb.length()) {
                int[] min = findMin(sb, r, sb.length(), c);
                c = min[1];
                if (r > 0) {
                    while (r > 0 && sb.charAt(r - 1) - 'a' <= min[1]) {
                        res.append(sb.charAt(r - 1));
                        sb.deleteCharAt(r - 1);
                        r--;
                        min[0]--;
                    }
                }
                r = min[0];
                res.append(sb.charAt(r));
                sb.deleteCharAt(r);
            }
            while (sb.length() > 0) {
                res.append(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }
            return res.toString();
        }

        //res[0]是序号 res[1] 是字母
        private int[] findMin(StringBuilder sb, int start, int length, int min) {
            int[] res = new int[2];
            res[0] = start;
            res[1] = sb.charAt(start) - 'a';
            for (int i = start; i < sb.length(); i++) {
                if (sb.charAt(i) - 'a' < res[1]) {
                    res[1] = sb.charAt(i) - 'a';
                    res[0] = i;
                    if (res[1] == min) {
                        return res;
                    }
                }
            }
            return res;
        }
    }
}
