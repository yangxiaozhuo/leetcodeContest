package test04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author yangxiaozhuo
 * @date 2023/05/08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String[] s1 = in.readLine().split(" ");
            HashSet<Integer> set = new HashSet<>();
            int two = 0;
            int one = 0;
            for (int i = 0; i < s1.length; i++) {
                int temp = Integer.parseInt(s1[i]);
                if (temp == -1) {
                    one++;
                } else if (temp == -2) {
                    two++;
                } else {
                    set.add(temp);
                }
            }
            System.out.println(fun(set, one, two, k));
        }
    }

    private static int fun(HashSet<Integer> set, int one, int two, int k) {
        int res = 0;
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            int temp = i + 1;
            //前num坐了i+1个人
            temp = temp + Math.min(num - i - 1, one);
            //k - num 个位置 已经坐了size - i + 1 个
            temp = temp + Math.min(k - num - (arrayList.size() - i - 1), two);
            res = Math.max(res, temp);
        }
        res = Math.max(res, Math.max(one, two));
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > two) {
                temp++;
            }
        }
        res = Math.max(res, temp + two);
        temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) <= k - one) {
                temp++;
            }
        }
        res = Math.max(res, temp + one);
        res = Math.max(res, two + arrayList.size());
        res = Math.max(res, one + arrayList.size());
        return Math.min(res, k);
    }

}
