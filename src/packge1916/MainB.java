package packge1916;
import java.util.Scanner;

public class MainB {
    static long[][] memo;
    static boolean[][] vis;

    static long dp(int m, int n) {
        if (m == 0) return 1;      // 0 个珠子：1 种
        if (n == 0) return 0;      // 没盒子：0 种
        if (n > m) return dp(m, m); // 盒子比珠子多

        if (vis[m][n]) return memo[m][n];
        vis[m][n] = true;
        memo[m][n] = dp(m, n - 1) + dp(m - n, n);
        return memo[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            memo = new long[m + 1][n + 1];
            vis = new boolean[m + 1][n + 1];
            System.out.println(dp(m, n));
        }
        sc.close();
    }
}