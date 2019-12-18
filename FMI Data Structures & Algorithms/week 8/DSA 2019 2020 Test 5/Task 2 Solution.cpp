#include <iostream>
#include <queue>
#include <set>
using namespace std;

int V, E, k, i, a, b, sz, curr,level=0;

vector<vector<int>>adj;
vector<bool>visited;
set<int> ans;

void bfs(int s)
{
    queue<int> Q;
    Q.push(s);
    visited[s] = true;
    sz = 1;
    while (!Q.empty())
    {   
        curr = Q.front();
        Q.pop();
        sz--;

        for (const auto& x : adj[curr])
        {
            if (!visited[x])
            {
                if (level == k-1)
                {
                    ans.insert(x);
                }
                Q.push(x);
                visited[x]=true;
            }
        }
        if (sz == 0)
        {
            sz = Q.size();
            level++;
            if(level>=k) return;
        }
    }    
}

int main()
{
    cin >> V >> E >> k;

    adj.assign(V + 1, vector<int>());
    visited.assign(V + 1, 0);
    for (i = 0;i < E;++i)
    {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    bfs(V);
    
    if(k==0) cout<< V;    
    else if (ans.size() == 0) cout << "-1";
    else
    {
        for (const auto& x : ans)
        {
            cout << x << ' ';
        }
    }

    return 0;
}
