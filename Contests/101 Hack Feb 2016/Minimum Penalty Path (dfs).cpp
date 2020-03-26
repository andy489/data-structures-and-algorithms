// github.com/andy489

#include <iostream>
#include <vector>
using namespace std;
#define N 1024

vector<pair<int, int> > adj[N];
int used[N][N];

void dfs(int a, int b){
    used[a][b] = 1;
    for (const auto& child:adj[a])
    {
        int to = child.first;
        int cost = child.second;
        cost |= b;
        if (!used[to][cost]){            
            dfs(to, cost);
        }
    }
}
int main(){
    int n,m,a,b,c;    
    cin>>n>>m;
    while(m--){        
        cin >> a >> b >> c;
        adj[a].push_back(make_pair(b, c));
        adj[b].push_back(make_pair(a, c));
    }

    cin >> a >> b;
    dfs(a, 0);

    int ans(-1),i;
    for(i=0;i<N;++i){
        if(used[b][i]){
            ans=i;
            break;
        }
    }
    cout << ans;    
    return 0;
}
