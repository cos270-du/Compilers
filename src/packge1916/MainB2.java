package packge1916;

import java.util.Scanner;

public class MainB2 {
    static final int MAX = 100;
    static long[][] dp = new long[MAX][MAX];

    static void init() {
        for (int n = 0; n < MAX; ++n) dp[0][n] = 1;// dp[0][n] = 1：0 个珠子，只有全空一种分法

        for (int m = 1; m < MAX; ++m) {
            for (int n = 1; n < MAX; ++n) {
                if (n > m) {
                    dp[m][n] = dp[m][m];  // 盒子比珠子多，等价于 m 个盒子
                } else {
                    dp[m][n] = dp[m][n - 1] + dp[m - n][n];
                }
            }
        }
    }

    public static void main(String[] args) {
        init();//先把MAX以内所有dp都算出来，然后输出题目要求的
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(dp[m][n]);
        }
        sc.close();
    }
}