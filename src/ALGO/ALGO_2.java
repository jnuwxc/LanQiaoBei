package ALGO;
//算法训练 最大最小公倍数
//http://lx.lanqiao.cn/problem.page?gpid=T12
//题目详情与解析见ALGO_1.md

import java.util.Scanner;

public class ALGO_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 2) {
            System.out.println(n);
        }
        else if (n % 2 == 1) {
            System.out.println(1l * n * (n - 1) * (n - 2));
        }else {
            if (n % 3 == 0) {
                System.out.println(1l * (n - 1) * (n - 2) * (n - 3));
            }else {
                System.out.println(1l * n * (n - 1) * (n - 3));
            }
        }
    }
}
