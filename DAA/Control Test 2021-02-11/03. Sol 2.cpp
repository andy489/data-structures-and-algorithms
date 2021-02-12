#include <cstdio>
#include <vector>
#include <map>
using namespace std;

int used[int(1e5)*3],n,m,numberOfNodes;
vector<int>gr[int(1e5)*3];
map<int,int>nodeNums;

void init(){
    int from,to;
    scanf("%d %d",&n,&m);

    for(int i=0;i<m;i++){
        scanf("%d %d",&from,&to);

        if(!nodeNums.count(from)){
            nodeNums[from]=numberOfNodes++;
        }
        if(!nodeNums.count(to)){
            nodeNums[to]=numberOfNodes++;
        }

        from = nodeNums[from];
        to = nodeNums[to];

        gr[from].push_back(to);
        gr[to].push_back(from);
    }
}

void dfs(int node){
    if(used[node])return;

    used[node]=1;

    for(int nextNode:gr[node]){
        dfs(nextNode);
    }
}

void solve(){
    int components = 0;

    for(int i=0;i<numberOfNodes;i++){
        if(used[i])continue;

        dfs(i);
        components++;
    }

    printf("%d\n",n-numberOfNodes+components);
}

int main() {
    init();
    solve();
}
