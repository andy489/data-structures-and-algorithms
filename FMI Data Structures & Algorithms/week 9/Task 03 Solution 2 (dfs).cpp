#include <unordered_set>
#include <unordered_map>

using namespace std;

void dfs(int s,
    unordered_map<int, unordered_set<int>>& adj,
    unordered_set<int>& visited)
{
    visited.insert(s);
    for (const auto& x : adj[s])
    {
        if (!visited.count(x))
        {
            dfs(x, adj, visited);
        }
    }
}

int main()
{
    int n, m, i, a, b, c(0); // c is counter
    scanf("%d %d", &n, &m);

    unordered_map<int, unordered_set<int>>adj;

    unordered_set<int> visited;

    for (i = 0;i < m;++i)
    {
        scanf("%d%d", &a, &b);
        adj[a].insert(b);
        adj[b].insert(a);
    }

    for (const auto& x : adj)
    {
        if (!visited.count(x.first))
        {
            dfs(x.first, adj, visited);
            c++;
        }
    }

    printf("%d", n-(int)adj.size()+c);

    return 0;
}
