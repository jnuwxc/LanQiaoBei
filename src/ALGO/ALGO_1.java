package ALGO;

//算法训练 区间k大数查询
//http://lx.lanqiao.cn/problem.page?gpid=T11
//题目详情与解析见ALGO_1.md

import java.util.Arrays;
import java.util.Scanner;

public class ALGO_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int l, r, k;
        for (int i = 0; i < m; i++) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            k = scanner.nextInt();
            int[] num2 = Arrays.copyOfRange(num, l - 1, r);
            Arrays.sort(num2);
            System.out.println(num2[r - l - (k - 1)]);
        }

    }
}
