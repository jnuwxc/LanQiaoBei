/***********************************************************************

算法：树型DP
 
用dp[i][0]表示不选择i点时，i点及其子树能选出的最大权值，
dp[i][1]表示选择i点时，i点及其子树的最大权值。

状态转移方程:
对于叶子节点 dp[k][0] = 0, dp[k][1] = 该点权值
对于非叶子节点i,
dp[i][0] = ∑max(dp[j][0], dp[j][1]) (j是i的儿子)
dp[i][1] = i点权值 + ∑dp[j][0] (j是i的儿子) 
最大权值即为max(dp[1][0], dp[1][1])

用一个变量pre保存当前结点的前一个结点，如果等于pre说明访问到了它的父亲结点，
为了防止重复访问，要在v[node][i]不等于pre时候继续dfs下去否则可能会形成无限循环的环

************************************************************************/

#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 5;

int dp[N][2];

vector< vector<int> > v;//用来存储与该节点连接的所有节点
//注意，两个 > 要分开写不然蓝桥杯的编译器会把它识别为流输入运算符

void dfs(int node, int pre)
{
    for (int i = 0; i < v[node].size(); i++)
    {
        int child = v[node][i];
        if (child != pre)
        {
            dfs(child, node);
            dp[node][0] += max(dp[child][0], dp[child][1]);
            dp[node][1] += dp[child][0];
        }
    }
}

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> dp[i][1];
    }
    int a, b;
    v.resize(n + 1);
    for (int i = 0; i < n - 1; i++)
    {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    dfs(1, 0);
    cout << max(dp[1][0], dp[1][1]);
}