#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<int>visited;

void bfs(int s){
    visited[s]=true;
    queue<int>Q;
    Q.push(s);
    while(!Q.empty()){
        int cur=Q.front();
        Q.pop();
        for(const auto& child:adj[cur]){
            if(!visited[child])
            {
                Q.push(child);
                visited[child]=true;
            }
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
                bfs(v);
                ++count;
            }
        }
        if(count){
            cout<<count<<' ';
        }        
    }    
    return 0;
}
