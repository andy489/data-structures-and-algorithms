#include <iostream>
#include <vector>
#include <unordered_set>
#include <deque>
using namespace std;

auto bfs(int s, const vector<unordered_set<int>>& adj, int level = 6)
{
    int N(adj.size()), curr, SIZE(1);
    unordered_set<int> visited;
    vector<int> ans(N, -1);

    deque<int> Q;
    Q.push_back(s);
    visited.insert(s);

    while (!Q.empty())
    {
        curr = Q.front();
        Q.pop_front();
        SIZE--;

        for (const auto& x : adj[curr])
        {            
            if (!visited.count(x))
            {
                ans[x] = level;
                Q.push_back(x);
                visited.insert(x);
            }
        }
        if (SIZE == 0)
        {
            SIZE = Q.size();
            level+=6;
        }
    }
    return ans;
}

int main()
{
    int q, i, j, n, m, a, b, s, k;
    cin >> q;

    for (i = 0; i < q; ++i)
    {
        cin >> n >> m;
        vector<unordered_set<int>> adj(n + 1);
        for (j = 0; j < m; ++j)
        {
            cin >> a >> b;
            adj[a].insert(b);
            adj[b].insert(a);
        }
        cin >> s;
        vector<int> ans = bfs(s, adj);

        for (k = 1; k <= n; ++k)
        {
            if (k != s)
            {
                cout << ans[k] << ' ';
            }
        }cout << '\n';
    }
    return 0;
}
