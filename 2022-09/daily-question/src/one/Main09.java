package one;

/**
 * 1598. 文件夹操作日志搜集器
 *
 * @author yangxiaozhuo
 * @date 2022/09/09
 */
public class Main09 {
    class Solution {
        public int minOperations(String[] logs) {
            int res = 0;
            for(int i = 0; i < logs.length; i++) {
                if(logs[i].equals("./")) {

                } else if(logs[i].equals("../")) {
                    res--;
                    if(res < 0) res = 0;
                } else {
                    res++;
                }
            }
            return res;
        }
    }
}
