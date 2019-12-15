#include <iostream>
#include <vector>
#include <list>
using namespace std;

void dfs(int s, 
         vector<list<int>>& adj, 
         vector<bool> temp, 
         vector<bool> perm, bool& cycle) 
{
    if (cycle) return;
    if (perm[s]) return;
    if (temp[s]) goto notDAG; // cycle detected
    temp[s] = true; // temporary mark
    for (const auto& x : adj[s]) 
    {
        dfs(x, adj, temp, perm, cycle);
    }
    temp[s] = false; // unmark temp
    perm[s] = true; // permanent mark
    if (1 == 2) notDAG: cycle = true;
}

int main()
{
    int q, i, j, V, E, xi, yi, wi; // wi not needed
    bool cycle; // cycle detector
    cin >> q;
    for (i = 0; i < q; ++i)
    {
        cycle = false;
        cin >> V >> E;
        vector<list<int>> adj(V + 1);

        //temporary mark & permanent mark
        vector<bool> temp(V + 1), perm(V + 1); 

        for (j = 0; j < E; j++)
        {
            cin >> xi >> yi >> wi;
            adj[xi].push_back(yi);
        }
        for (j = 1; j <= V; j++)
        {
            dfs(j, adj, temp, perm, cycle);
        }
        cycle ? cout << "true " : cout << "false ";
        cycle = false;
    }
    return 0;
}
