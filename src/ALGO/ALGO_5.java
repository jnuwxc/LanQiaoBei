package ALGO;

import java.util.*;

public class ALGO_5 {

    static int[] len;//存放各个点到源点的最短路
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;//n:节点数目，m:边数
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<node> list[] = new ArrayList[n];//存储路径
        for (int i = 0; i < n; i++) {//必须初始化
            list[i] = new ArrayList<node>();
        }
        len = new int[n];
        Arrays.fill(len, Integer.MAX_VALUE);//初始长度都为MAX
        len[0] = 0;
        boolean jud[] = new boolean[n];//判断是否在队列内
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int l = scanner.nextInt();
            list[u - 1].add(new node(v - 1, l));
        }
        scanner.close();

        Queue<Integer> q1 = new ArrayDeque<>(); //队列
        q1.add(0);//第一个
        while (!q1.isEmpty()) {
            int x = q1.poll();
            jud[x] = false;
            for (int i = 0; i < list[x].size(); i++) {
                int index = list[x].get(i).x; //与x相连的节点编号
                int length = list[x].get(i).len;//x到这个邻居的距离
                if (len[index] > len[x] + length) {
                    len[index] = len[x] + length;
                    if (!jud[index]) { //队列中没有该点
                        q1.add(index);
                        jud[index] = true;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            System.out.println(len[i]);
        }
    }

    static class node{
        int x;
        int len;
        public node(int x, int len){
            this.x = x;
            this.len = len;
        }
    }
}
