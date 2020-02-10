#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
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
    cin.tie(nullptr);
    ios::sync_with_stdio(false);
    int n,m,a,b,i,j;
    cin>>n>>m;
    adj.resize(n);
    visited.resize(n);    
    while(m--){
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    vector<int>res;    
    for(i=0;i<n;++i){
        int c(0);
        if(!visited[i]){
            dfs(i,c);
            res.push_back(c);
        }
    }
    int s=(int)res.size(),ans(0);
    for(i=0;i<s;++i){
        for(j=i+1;j<s;++j){
            ans+=res[i]*res[j];
        }
    }
    cout<<ans;
    return 0;
}
