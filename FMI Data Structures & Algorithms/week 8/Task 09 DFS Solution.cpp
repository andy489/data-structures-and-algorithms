#include <iostream>
#include <vector>
#include <list>
using namespace std;

int V, E;

vector<list<int>>adj;
vector<bool> visited;

int dfs(int s, int& res)
{
    int currNode = 0;

    visited[s] = true;
    for (const auto& x : adj[s])
    {
        if (!visited[x])
        {
            int subtreeNodeCount = dfs(x, res);

            if (subtreeNodeCount % 2 == 0)
            {
                res++;
            }
            else
            {
                currNode += subtreeNodeCount;
            }
        }
    }
    return currNode + 1;
}

int main()
{
    int i, v1, v2;
    cin >> V >> E;

    adj.resize(V + 1);
    visited.resize(V + 1);

    for (i = 0; i < E; ++i)
    {
        cin >> v1 >> v2;
        adj[v1].push_back(v2);
        adj[v2].push_back(v1);
    }

    int res = 0;

    dfs(V%2019, res);

    cout << res;

    return 0;
}
