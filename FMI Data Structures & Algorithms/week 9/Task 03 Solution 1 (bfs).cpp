#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>
using namespace std;

typedef unordered_map<int, vector<int>> Graph;
typedef unordered_map<int, bool> Table;

void inp(int m, Graph& g, Table& visited)
{
    while(m--)
    {
        int from, to;
        cin >> from >> to;
        g[from].push_back(to);
        g[to].push_back(from);
        visited[from], visited[to];
    }
}

void BFS(const Graph& g, Table& visited, int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;
    while(!q.empty())
    {
        int curr = q.front();
        q.pop();
        for(int v: g.find(curr)->second)
            if(bool& f=visited[v]; !f)
            {
                f = true;
                q.push(v);
            }
    }
}

int solve(int n, const Graph& g, Table& visited)
{
    int components = 0;
    for(auto& p: visited)
        if(!p.second)
        {
            BFS(g, visited, p.first);
            components++;
        }
    return n - g.size() + components;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    Graph g;
    Table visited;
    inp(m, g, visited);
    cout << solve(n, g, visited) << endl;
}
