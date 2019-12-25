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
    vector<int>paths;

    int v;

    void clearVisited()
    {
        visited.assign(v + 1, 0);
    }
public:
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
        pq.push({0,start});
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

        for (int i = 1;i <= v;++i)
        {
            if (i!=start)
            {
                if (paths[i] == INT_MAX)
                {
                    printf("%d ", -1);
                }
                else
                {
                    printf("%d ", paths[i]);
                }
            }
        }
    }
};


int main()
{
    int t;
    scanf("%d", &t);

    for (int i = 0;i < t;++i)
    {
        int n, m;
        scanf("%d%d", &n, &m);

        int v1, v2, weight;
        Graph G(n);
        for (int j = 0;j < m;++j)
        {
            scanf("%d%d%d", &v1, &v2, &weight);
            G.insert({ weight,v1 }, { weight,v2 });
        }

        int start;
        scanf("%d", &start);

        G.djiikstra(start);
        printf("\n");
    }
    return 0;
}

/*
1
8 12
2 4 2
1 4 1
4 7 3
1 7 5
2 1 2
3 7 4
4 8 2
5 7 3
8 3 1
8 1 1
3 5 1
1 5 2
5

2 4 1 3 -1 3 2
*/
