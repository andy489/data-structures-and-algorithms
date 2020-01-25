#include <bits/stdc++.h>
using namespace std;

int main() 
{
    int N,M,K,a,b,w,cost(0);
    cin>>N>>M;
    vector<unordered_map<int,int>>adjList(N);
    while(M--){
        cin>>a>>b>>w;
        adjList[a][b]=w;
        adjList[b][a]=w;
    }
    cin>>K;
    vector<int>path(K);
    for(w=0;w<K;++w){
        cin>>path[w];
    }
    for(w=0;w<K-1;++w){        
        if(adjList[path[w]].count(path[w+1])){
            cost+=adjList[path[w]][path[w+1]];
        }
        else{
            cout<<"-1";
            return 0;
        }
    }
    cout<<cost;
    return 0;
}
