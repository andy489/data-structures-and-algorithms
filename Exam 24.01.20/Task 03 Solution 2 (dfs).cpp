#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<int>visited;

void dfs(int s){
    visited[s]=true;
    for(const auto& child:adj[s]){
        if(!visited[child]){
            dfs(child);
        }
    }
}

int main() 
{
    int q,n,m,a,b;
    cin>>q;
    while(q--){
        cin>>n>>m;
        adj.assign(n,list<int>());
        visited.assign(n,0);        
        while(m--){
            cin>>a>>b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        int count(0),v;
        for(v=0;v<n;++v){
            if(!visited[v]){
                dfs(v);
                ++count;
            }
        }
        if(count){
            cout<<count<<' ';
        }        
    }    
    return 0;
}
