# ALGO_3 算法训练 K好数 

## 问题描述

如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。
求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。
由于这个数目很大，请你输出它对1000000007取模后的值。

## 输入格式

输入包含两个正整数，K和L。

## 输出格式

输出一个整数，表示答案对1000000007取模后的值。

## 样例输入

```
4 2
```

## 样例输出

```
7
```

## 数据规模与约定

对于30%的数据，![](http://chart.googleapis.com/chart?cht=tx&chl=B^L\leq1e6);

对于50%的数据，![](http://chart.googleapis.com/chart?cht=tx&chl=K\leq16,L\leq10)；

对于100%的数据，![](http://chart.googleapis.com/chart?cht=tx&chl=1\leq%20K,L\leq100)

## 题解

一道典型的动态规划题目。

我们用dp[i][j]表示i位，以j为首字母的所有符合情况的K好数个数,
数组的大小为(l+1, k)，显然第一行是无用的。

本题的难处也在于上面dp数组的表示方式，可以想到的是，
dp数组必须是能表示可分状况的数组，那么将较短的情况连接起来就必须要注意到连接点的问题，
这里我们是考虑了首字母，当然也可以考虑尾字母，效果是相同的。

既然想出了dp数组的含义，题目就很容易解出了。

![](http://chart.googleapis.com/chart?cht=tx&chl=dp[i][j]=\sum_{m=0}^kdp[i-1][m],%20\quad%20m\not=j-1,m\not=j%2b1)

记得将dp[1][j]初始化为1。

记得取余1000000007

结果为

![](http://chart.googleapis.com/chart?cht=tx&chl=\begin{equation*}result=\sum_{j=1}^kdp[l][j]\end{equation*})
