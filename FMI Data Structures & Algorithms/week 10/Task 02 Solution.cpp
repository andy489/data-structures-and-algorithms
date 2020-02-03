#include <bits/stdc++.h> 
using namespace std;
 
void dijkstra(vector<unordered_map<int, int>>& adj, int& s, int& e, vector<vector<pair<int, bool>>>& t)
{
    if(t[s][e].second)
    {        
        cout<<t[s][e].first << '\n';      
    }
    else
    {    
        vector<bool> visited(adj.size());
        vector<int> paths(adj.size(), INT_MAX);
        paths[s] = 0;
   
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        q.push({0, s});
   
        while(!q.empty())
        {
            pair<int,int>cur=q.top();
            q.pop();
       
            visited[cur.second]=true;
            for(const auto& x : adj[cur.second])
            {
                if(!visited[x.first] && paths[cur.second] + x.second < paths[x.first])
                {
                    paths[x.first] = x.second + paths[cur.second];
                    q.push({paths[x.first], x.first});
                }
            }        
        }
        int i;
        for(i=1;i<adj.size();++i)
        {
            if(paths[i] != INT_MAX)
            {
                t[s][i] = {paths[i], true};
            }
            else
            {
                t[s][i] = {-1, true};
            }
        }
   
        if(paths[e] != INT_MAX)
        {
            cout << paths[e] << "\n";
        }
        else
        {
            cout << -1 << "\n";
        }
       
    }
}
 
int main()
{
    int V,E,i,u,v,w;
    cin>>V>>E;
   
    vector<unordered_map<int,int>>adj(V+1);
    
    for(i=0;i<E;++i)
    {
        cin>>u>>v>>w;
        if(!adj[u].count(v))
        {
            adj[u][v] = w;
        }
        else
        {
            adj[u].erase(v);
            adj[u][v] = w;
        }
    }
   
    vector<vector<pair<int, bool>>> t(V+1, vector<pair<int, bool>>(V+1, {-1, false}));
   
    int q;
    cin >> q;
    int s, e;
    for(i=0;i<q;++i)
    {
        cin >>s >>e;
        dijkstra(adj, s, e, t);
    }   
}
