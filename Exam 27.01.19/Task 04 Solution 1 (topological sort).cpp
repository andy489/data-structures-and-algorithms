#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<int> visited,top_sort,indexes;

void dfs(int s){//s=start
    visited[s]=true;
    for(const auto& child:adj[s]){
        if(!visited[child]){
            dfs(child);
        }
    }
    top_sort.push_back(s);
    indexes[s]=top_sort.size()-1;
}

int main() {
    int q,V,E,a,b,w;
    cin>>q;
    while(q--){        
        cin>>V>>E;
        adj.assign(V,list<int>());
        visited.assign(V,0);
        top_sort.clear();
        indexes.assign(V,-1);
        while(E--){
            cin>>a>>b>>w;--a;--b;
            adj[a].push_back(b);
        }
        for(a=0;a<V;++a){
            if(!visited[a]){
                dfs(a);
            }
        }
        size_t cycle_edges(0);
        for(a=0;a<V;++a){
            for(const auto& child:adj[a]){
                if(indexes[child]>indexes[a]){
                    ++cycle_edges;
                }
            }
        }
        cout<<(cycle_edges?"true ":"false ");
    }
    return 0;
}
