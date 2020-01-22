//https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2299
#include <bits/stdc++.h>
using namespace std;

void bfs(const vector<list<int>>& adj, int V, set<int>& ans, int d)
{
    vector<bool>visited(V);
    int s=V-1;
    queue<int>q;
    q.push(s);

    visited[s] = true;
    int lvl(0);

    while (!q.empty())
    {
        int s = (int)q.size();
        while (s--)
        {
            int cur = q.front();
            q.pop();
            for (const auto& x : adj[cur])
            {
                if (!visited[x])
                {                    
                    q.push(x);
                    visited[x] = true;
                }
            }
            if (lvl == d)
            {
                ans.insert(cur);
            }
        }
        ++lvl;
        if(lvl>d) return;
    }
}

int main()
{
    int V, E, d, a, b;
    cin >> V >> E >> d;
    vector<list<int>>adj;
    adj.assign(V, list<int>());
    while (E--)
    {
        cin >> a >> b;
        --a;--b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    set<int> ans;

    bfs(adj, V, ans, d);

    if (ans.size())
    {
        for (const auto& x : ans) cout << x + 1<<' ';
    }
    else
    {
        cout << "-1";
    }
    return 0;
}
