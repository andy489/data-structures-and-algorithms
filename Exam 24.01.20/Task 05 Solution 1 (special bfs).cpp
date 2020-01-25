#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<int> visited;

int bfs(int start, int end)
{
    queue<int>q;
    q.push(start);
    visited[start] = true;
    int lvl(0);
    while (!q.empty())
    {
        int s = q.size();
        while (s--)
        {
            int cur = q.front();
            visited[cur] = true;
            if (cur == end)
            {
                return lvl;
            }
            for (const auto& child : adj[cur])
            {
                if (!visited[child])
                {
                    q.push(child);
                }
            }
            q.pop();
        }
        ++lvl;
    }
    if (!visited[end])
    {
        return -1;
    }
    return 0;
}

int main()
{
    int N, M, a, b, K;
    cin >> N >> M;

    adj.assign(N, list<int>());
    visited.assign(N, 0);
    while (M--)
    {
        cin >> a >> b;
        adj[a].push_back(b);
    }
    cin >> K;
    vector<int>path(K);
    for (a = 0;a < K;++a)
    {
        cin >> path[a];
    }
    int shortest(0);
    for (a = 0;a < K - 1;++a)
    {
        for (b = a+2;b < K;++b)
        {
            visited[path[b]] = true;
        }
        int dist = bfs(path[a], path[a + 1]);
        fill(visited.begin(), visited.end(), 0);

        if (dist != -1)
        {
            shortest += dist;
        }
        else
        {
            cout << dist;
            return 0;
        }
    }
    cout << shortest;
    return 0;
}
