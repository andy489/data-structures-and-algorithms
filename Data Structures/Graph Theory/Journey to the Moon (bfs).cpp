// github.com/andy489

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>>adj;
vector<int>visited;

void bfs(int s,int&c){
    queue<int>q;
    q.push(s);
    visited[s]=true;
    ++c;
    while(!q.empty()){
        int cur=q.front();
        q.pop();
        for(const auto& child:adj[cur]){
            if(!visited[child]){
                q.push(child);
                visited[child]=true;
                ++c;
            }
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
            bfs(i,c);
            sets.push_back(c);
        }
    }
    long long sum(n);
    sum*=sum;
    for(const int& x:sets){
        sum-=x*x;;
    }
    cout<<sum/2;
    return 0;
}
