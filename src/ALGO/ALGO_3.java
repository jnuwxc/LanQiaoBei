package ALGO;
//算法训练 K好数
//http://lx.lanqiao.cn/problem.page?gpid=T13

import java.util.Scanner;

public class ALGO_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        //dp[i][j]表示i位，以j为首字母的所有复合情况的个数
        int[][] dp = new int[l + 1][k];
        for (int j = 0; j < k; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i < l + 1; i++) {
            for (int j = 0; j < k; j++) {
                for (int m = 0; m < k; m++) {
                    if (m == j - 1 || m == j + 1) {
                        continue;
                    }
                    dp[i][j] += dp[i - 1][m];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        int result = 0;
        for (int j = 1; j < k; j++) {
            result += dp[l][j];
            result %= 1000000007;
        }
        System.out.println(result);
    }
}