package Week01_03二分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 1221. 四平方和
 * https://www.acwing.com/problem/content/1223/
 *
 * @author yangxiaozhuo
 * @date 2023/02/16
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        ArrayList<int[]> arrayList = new ArrayList<>();
        int n = Integer.parseInt(s);
        for (int i = 0; i * i <= n; i++) {
            for (int j = i; j * j + i * i <= n; j++) {
                arrayList.add(new int[]{i * i + j * j, i, j});
            }
        }
        Collections.sort(arrayList, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i * i <= n; i++) {
            for (int j = i; j * j + i * i <= n; j++) {
                int t = n - i * i - j * j;
                int l = 0;
                int r = arrayList.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (arrayList.get(mid)[0] < t) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (arrayList.get(l)[0] == t) {
                    System.out.println(i + " " + j + " " + arrayList.get(l)[1] + " " + arrayList.get(l)[2]);
                    return;
                }
            }
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///**
// * 1221. 四平方和
// * https://www.acwing.com/problem/content/1223/
// *
// * @author yangxiaozhuo
// * @date 2023/02/16
// */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String s = in.readLine();
//        int n = Integer.parseInt(s);
//        for (int i = 0; i * i * 4 <= n; i++) {
//            for (int j = i; i * i + j * j * 3 <= n; j++) {
//                for (int k = j; i * i + j * j + k * k * 2 <= n; k++) {
//                    int t = n - i * i - j * j - k * k;
//                    int tt = (int) Math.sqrt(t);
//                    if (tt * tt == t) {
//                        System.out.println(i + " " + j + " " + k + " " + tt);
//                        return;
//                    }
//                }
//            }
//        }
//    }
//}
