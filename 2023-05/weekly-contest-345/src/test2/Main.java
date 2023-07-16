package test2;

/**
 * @author yangxiaozhuo
 * @date 2023/05/14
 */
public class Main {
}
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int t = derived[0];
        for (int i = 1; i < derived.length; i++) {
            t = t ^ derived[i];
        }
        return t == 0;
    }
}