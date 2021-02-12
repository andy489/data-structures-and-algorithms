#include<bits/stdc++.h>

using namespace std;

int n,m,dist[560][560];
long long numPaths[560][560];
const int mod=1000000021;

void init(){
    int from,to,weight;

    scanf("%d %d",&n,&m);

    for(int i=0;i<=n;i++){
        fill(dist[i],dist[i]+n+1,INT_MAX/5);
    }

    for(int i=0;i<m;i++){
        scanf("%d %d %d",&from,&to,&weight);
        dist[from][to]=weight;
        dist[to][from]=weight;
        numPaths[from][to]=1;
        numPaths[to][from]=1;
    }

    for(int i=0;i<=n;i++){
        dist[i][i]=0;
    }
}

void floyd(){
    for(int k=1;k<=n;k++){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int newDist=dist[i][k]+dist[k][j];

                if(dist[i][j]<newDist)continue;
                if(dist[i][j]==newDist){
                    numPaths[i][j]=(numPaths[i][j]+numPaths[i][k]*numPaths[k][j])%mod;
                }
                else{
                    dist[i][j]=newDist;
                    numPaths[i][j]=(numPaths[i][k]*numPaths[k][j])%mod;
                }
            }
        }
    }
}

void readQs(){
    int q,from,to;

    scanf("%d",&q);

    scanf("%d %d",&from,&to);
    printf("%d",numPaths[from][to]);

    for(int i=1;i<q;i++){
        scanf("%d %d",&from,&to);
        printf(" %d",numPaths[from][to]);
    }

    printf("\n");
}

int main(){
    init();
    floyd();
    readQs();
}
