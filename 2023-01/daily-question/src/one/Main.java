package one;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int miao = 0;
        int fen = 0;
        int shi = 0;
        while (shi < 240 * 120) {
            miao = miao + 6 * 120;
            fen = fen + 12;
            shi = shi + 1;
            int b = (miao - fen) % (180*120);
            int a = (fen - shi) % (180*120);
            if (Math.abs(2 * b - a) == 0) {
                System.out.println("a:" + a);
                System.out.println(b);
                System.out.println(shi);
                System.out.println(fen);
                System.out.println(miao);
                System.out.println((int) (shi / 60 / 120) + " " + (int) (fen / 360 / 120) + " " + miao % (120 * 360));
                return;
            }
        }

        scan.close();
    }
}