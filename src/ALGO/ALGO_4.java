package ALGO;

//  算法训练 结点选择
//http://lx.lanqiao.cn/problem.page?gpid=T14

import java.util.Scanner;

public class ALGO_4 {

    static int[][] dp;
    static int[][] tree;
    static int[] len;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = scanner.nextInt();
        }
        tree = new int[n + 1][n + 1];
        len = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            tree[a][len[a]++] = b;
            tree[b][len[b]++] = a;
        }
        dfs(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int node, int pre) {
        for (int i = 0; i < len[node]; i++) {
            int child = tree[node][i];
            if (child != pre) {
                dfs(child, node);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }
}
