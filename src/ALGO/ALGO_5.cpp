#include <bits/stdc++.h>

using namespace std;

const int N = 2e4 + 5, M = 2e5 + 5;
int head[N], ver[M], edge[M], Next[M], dis[N];
bool vis[N];
int n, m, tot;
priority_queue< pair<int, int> > q;

void add(int u, int v, int l)
{
    ver[++tot] = v;
    edge[tot] = l;
    Next[tot] = head[u];
    head[u] = tot;
}

void Dijkstra()
{
    memset(dis, 0x3f, sizeof(dis));
    dis[1] = 0;
    q.push(make_pair(0, 1));
    while (q.size())
    {
        int u = q.top().second;
        q.pop();
        if (vis[u])
            continue;
        vis[u] = true;
        for (int i = head[u]; i; i = Next[i])
        {
            int v = ver[i];
            int l = edge[i];
            if (dis[v] > dis[u] + l)
            {
                dis[v] = dis[u] + l;
                q.push(make_pair(-dis[v], v));
            }
        }
    }
}

int main()
{
    cin >> n >> m;
    int u, v, l;
    for (int i = 0; i < m; i++)
    {
        cin >> u >> v >> l;
        add(u, v, l);
    }
    Dijkstra();
    for (int i = 2; i <= n; i++)
        cout << dis[i] << endl;
}
