
//算法训练 最大最小公倍数
//http://lx.lanqiao.cn/problem.page?gpid=T12


#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

int gcd(int a, int b)
{
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}

int main()
{
    LL n;
    cin >> n;
    if (n % 2)
    {
        cout << n * (n - 1) * (n - 2);
    }
    else if (n % 3 == 0)
    {
        cout << (n - 1) * (n - 2) * (n - 3);
    }
    else
    {
        cout << n * (n - 1) * (n - 3);
    }
}