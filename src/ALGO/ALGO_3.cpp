
//算法训练 K好数
//http://lx.lanqiao.cn/problem.page?gpid=T13


#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

const int mod = 1000000007;

int main()
{
	int k, l;
	LL dp[105][105];
	memset(dp, 0, sizeof(dp));
	cin >> k >> l;
	for (int i = 0; i < k;++i)
	{
		dp[0][i] = 1;
	}
	for (int i = 1; i < l;++i)
	{
		for (int j = 0; j < k;++j)
		{
			for (int m = 0; m < k;++m)
			{
				if(m!=j+1&&m!=j-1)
				{
					dp[i][j] += dp[i - 1][m];
					dp[i][j] %= mod;
				}
			}
		}
	}
	LL ans = 0;
	for (int i = 1; i < k;++i)
	{
		ans += dp[l - 1][i];
		ans %= mod;
	}
	cout << ans;
}