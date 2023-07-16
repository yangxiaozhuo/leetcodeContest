package test03;

import java.util.ArrayList;

/**
 * @author yangxiaozhuo
 * @date 2023/05/21
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.punishmentNumber(37));
        System.out.println(solution.punishmentNumber(45)); //3503
    }
}

class Solution {
    static boolean[] flag = new boolean[1010];

    static {
//        System.out.println(fun(45));
        for (int i = 1; i < flag.length; i++) {
            if (fun(i)) {
                flag[i] = true;
            }
        }
    }

    private static boolean fun(int n) {
        int t = n * n;
        String temp = t + "";
        ArrayList<Integer> res = get(temp);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == n) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> get(String temp) {
        ArrayList<Integer> res = new ArrayList<>();
        if ("".equals(temp)) {
            return res;
        }
        res.add(Integer.parseInt(temp));
        for (int i = 1; i < temp.length(); i++) {
            String substring = temp.substring(0, i);
            String other = temp.substring(i);
            ArrayList<Integer> arrayList = get(other);
            int t = Integer.parseInt(substring);
            if(arrayList.size() == 0) {
                res.add(t);
            }
            for (int j = 0; j < arrayList.size(); j++) {
                res.add(t + arrayList.get(j));
            }
        }
        return res;
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i]) {
                res += i * i;
            }
        }
        return res;
    }
}