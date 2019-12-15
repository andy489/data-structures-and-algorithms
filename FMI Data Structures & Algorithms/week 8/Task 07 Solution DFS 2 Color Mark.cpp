#include <iostream>
#include <vector>
#include <list>
using namespace std;
// green -> temporary mark due to dfs; red - permanent mark (visited)
void dfs(int s, 
         vector<list<int>>& adj, 
         vector<bool> red, 
         vector<bool> green, bool& cycle) 
{
    if (cycle) return;
    if (green[s]) return;
    if (red[s]) goto notDAG; // cycle detected
    red[s] = true;
    for (const auto& x : adj[s]) 
    {
        dfs(x, adj, red, green, cycle);
    }
    red[s] = false;
    green[s] = true;
    if (1 == 2) notDAG: cycle = true;
}

int main()
{
    int q, i, j, V, E, xi, yi, wi;
    bool cycle; // cycle detector
    cin >> q;
    for (i = 0; i < q; ++i)
    {
        cycle = false;
        cin >> V >> E;
        vector<list<int>> adj(V + 1);

        //temporary mark & permanent mark
        vector<bool> red(V + 1), green(V + 1); 

        for (j = 0; j < E; j++)
        {
            cin >> xi >> yi >> wi;
            adj[xi].push_back(yi);
        }
        for (j = 1; j <= V; j++)
        {
            dfs(j, adj, red, green, cycle);
        }
        cycle ? cout << "true " : cout << "false ";
        cycle = false;
    }
    return 0;
}
