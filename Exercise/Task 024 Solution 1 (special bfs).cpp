#include <bits/stdc++.h>
using namespace std;

vector<int> bfs(vector<unordered_set<int>>&adj,int start){
    int n=(int)adj.size(),i;
    vector<int>shortest_paths(n,-1);
    
    unordered_set<int>visited;
    queue<int>q;
    visited.insert(start);
    q.push(start);

    shortest_paths[start]=0;

    while(!q.empty()&&visited.size()!=n){
        int cur=q.front();
        q.pop();

        for(i=0;i<n;++i){
            if(i!=cur&&!adj[cur].count(i)&&!visited.count(i)){
                visited.insert(i);
                q.push(i);
                shortest_paths[i]=shortest_paths[cur]+1;
            }
        }
    }
    return shortest_paths;
}

int main(){
    int t,n,m,a,b,s,i;
    cin>>t;
    while(t--){        
        cin>>n>>m;
        vector<unordered_set<int>>main_roads(n);
        while(m--){
            cin>>a>>b;
            --a;--b;
            main_roads[a].insert(b);
            main_roads[b].insert(a);
        }
        cin>>s;
        --s;
        vector<int>shortest_paths=bfs(main_roads,s);
        for(i=0;i<n;++i){
            if(i!=s){
                cout<<shortest_paths[i]<<' ';
            }
        }
        cout<<'\n';
    }
    return 0;
}
