
//算法训练 区间k大数查询
//http://lx.lanqiao.cn/problem.page?gpid=T11


#include <bits/stdc++.h>

using namespace std;

int a[1000000 + 5];

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> a[i];
    int m;
    cin >> m;
    int l, r, k;
    while (m--)
    {

        cin >> l >> r >> k;
        vector<int> v;
        for (; l <= r; ++l)
            v.push_back(a[l]);
        sort(v.begin(), v.end());
        vector<int>::iterator it = v.end();
        cout << *(it - k) << endl;
    }
}