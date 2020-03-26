// github.com/andy489

#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pii;
typedef vector<int> vi;

pii dfs(int i, const vector<vi> &adj, vector<bool> &vis) {
    vis[i] = true;
    pii r(0, i);
    for(const auto&child:adj[i]) if(!vis[child]) {
        pii p = dfs(child, adj, vis);
        r=max(r, make_pair(p.first + 1, p.second));
    }
    return r;
}

int main(){
    int n,i;
    cin>>n;
    vector<int>c(n);
    for(i=0;i<n;++i){
        cin>>c[i];
    }
    vector<vi>adj(n);
    for(i=1;i<n;++i){
        int p;
        cin>>p;--p;
        adj[p].push_back(i);
        adj[i].push_back(p);
    }
    vector<bool> vis(n), tmp(n);
    for(i=0;i<n;++i){
        tmp[i]=vis[i]=c[i]==0;
    }
    int ans(0);
    for(i=0;i<n;++i){
        if(!vis[i]){
        pii p=dfs(i,adj,tmp);
        pii q=dfs(p.second,adj,vis);
        ans=max(ans,q.first+1);
        }
    }
    cout<<ans;
    return 0;
}
