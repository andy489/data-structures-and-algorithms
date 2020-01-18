#include <iostream>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>
using namespace std;

typedef unordered_map<string, vector<string>> Graph;
typedef unordered_map<string, bool> Table;

bool DFS(Graph& g, Table& visited, const string& start, vector<string>& res)
{
    visited[start] = true;
    res.push_back(start);
    for(auto& v: g[start])
    {
        if(v == res[0])
        {
            res.push_back(res[0]);
            return true;
        }
        if(!visited[v] && DFS(g, visited, v, res)) return true;
    }
    res.pop_back();
    return false;
}

auto inp(int m)
{
    Graph g;
    while(m--)
    {
        string from, to;
        cin >> from >> to;
        g[move(from)].push_back(move(to));
    }
    return g;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> m >> m;
    auto g = inp(m);
    string start;
    cin >> start;
    Table visited;
    vector<string> res;
    if(DFS(g, visited, start, res))
        for(auto& city: res)
            cout << city << ' ';
    else cout << -1;
    cout << endl;
}
