// github.com/andy489

#include <stdio.h>

const int MXN = 2e5 + 5;

int move[MXN], mark[MXN], n, k, a, m;
 
int valid(int x){
    int cons=0;
    int cur=0;
    for(int i=1; i<=n; ++i) mark[i] = 0;
    for(int i=1; i<=x; ++i) ++mark[move[i]];
    for(int i=1; i<=n; ++i){
        if(!mark[i]) ++cons;
        else cons = 0;
        if(cons == a){ ++cur; cons = -1; }
    }
    if(cur >= k) return 1;
    return 0;
}
 
int bs(int l, int r){
    int m = (l+r)>>1;
    if(l >= r) return l;
    if(!valid(m)) return bs(l, m);
    else return bs(m+1, r);
}
 
int main(){
    scanf("%d%d%d", &n, &k, &a);
    scanf("%d", &m);
    for(int i=1; i<=m; ++i) scanf("%d", &move[i]);
    if(valid(m) == 1) printf("-1");
    else printf("%d", bs(1, m));
    return 0;
}
