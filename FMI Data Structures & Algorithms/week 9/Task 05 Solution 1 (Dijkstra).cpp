#include <cstdio>
#include <vector>
#include <queue>
#include <climits>
using namespace std;
typedef pair<int, int> pii;

class Graph
{
    vector<vector<pii>>adj;
    vector<bool> visited;

    int v;

    void clearVisited()
    {
        visited.assign(v + 1, 0);
    }

public:

    vector<int>paths;

    Graph(int v) :v(v)
    {
        adj.resize(v + 1);
        paths.resize(v + 1, INT_MAX);
    }

    void insert(pii v1, pii v2)
    {
        adj[v1.second].push_back(v2);
        adj[v2.second].push_back(v1);
    }

    void djiikstra(int start)
    {
        clearVisited();
        priority_queue<pii, vector<pii>, greater<pii>>pq;
        pq.push({ 0,start });
        paths[start] = 0;

        while (!pq.empty())
        {
            int dist = pq.top().first;
            int v = pq.top().second;
            pq.pop();
            if (visited[v])
            {
                continue;
            }
            visited[v] = true;
            for (const auto& child : adj[v])
            {
                if (visited[child.second])
                {
                    continue;
                }
                if (paths[v] + child.first < paths[child.second])
                {
                    paths[child.second] = paths[v] + child.first;
                    pq.push({ paths[child.second],child.second });
                }
            }
        }
    }
};

int main()
{
    int n, m, i, v1, v2, weight, discos, u, q, student;
    scanf("%d%d", &n, &m);

    Graph G(n);

    for (i = 0;i < m;++i)
    {
        scanf("%d%d%d", &v1, &v2, &weight);
        G.insert({ weight,v1 }, { weight,v2 });
    }

    scanf("%d", &discos);

    for (i = 0;i < discos;++i)
    {
        scanf("%d", &u);
        G.insert({ 0,u }, { 0,n });
    }

    scanf("%d", &q);

    G.djiikstra(n);

    for (i = 0; i < q; ++i)
    {
        scanf("%d", &student);
        printf("%d\n", G.paths[student]);
    }
    return 0;
}
