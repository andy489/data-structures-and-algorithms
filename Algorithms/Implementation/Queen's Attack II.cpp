// github.com/andy489

//First Solution BFS
#include <cstdio>
#include <set>
using namespace std;
int main() {
    int dx[]{ -1,-1,-1,0,0,1,1,1 },
        dy[]{ -1,0,1,-1,1,-1,0,1 },
        n,k,x,y,xx,yy,c(0);

    scanf("%d%d%d%d", &n, &k,&x,&y);
    set<pair<int, int>> bad;
    while (k--) {
        scanf("%d%d", &xx, &yy);
        bad.insert({xx, yy});
    }
    
    for (k = 0;k < 8;++k) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        while (true){    
            if(min(nx, ny) < 1 || max(nx, ny) > n || bad.count({nx, ny})) {
                break;
            }
            c++;
            nx += dx[k];
            ny += dy[k];
        }
    }
    printf("%d", c);
    return 0;
}

//Second Solution DFS
#include <iostream>
#include <set>
using namespace std;

 int dx[]{ 1,1,1,0,0,-1,-1,-1 },
     dy[]{ -1,0,1,-1,1,-1,0,1 },n,c(0);
 set<pair<int, int>> obs;

void dfs(int x, int y, int k){
    if (min(x,y)<1 || max(x,y)>n || obs.count({ x ,y })) return;
    c++;
    dfs(x + dx[k], y + dy[k], k);
}

int main(){
    int k, x, y, xx, yy;
    cin >> n >> k >> x >> y;   
    while (k--){
        cin >> xx >> yy;
        obs.insert({ xx,yy });
    }
    for (k = 0;k < 8;++k){
        dfs(x+dx[k], y+dy[k], k);
    }
    cout << c;
    return 0;
}
