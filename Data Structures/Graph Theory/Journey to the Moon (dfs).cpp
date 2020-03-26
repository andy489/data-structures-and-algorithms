// github.com/andy489

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>>adj;
vector<int>visited;

void dfs(int s,int&c){
    visited[s]=true;
    ++c;
    for(const auto& child:adj[s]){
        if(!visited[child]){
            dfs(child,c);
        }
    }
}

int main(){    
    int n,m,a,b,i;
    cin>>n>>m;
    adj.resize(n);
    visited.resize(n);    
    while(m--){
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    vector<int>sets;    
    for(i=0;i<n;++i){
        int c(0);
        if(!visited[i]){
            dfs(i,c);
            sets.push_back(c);
        }
    }
    long long sum(0),res(0);
    for(const int& x:sets){
        res+=sum*x;
        sum+=x;
    }
    cout<<res;
    return 0;
}
