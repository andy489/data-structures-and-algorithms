#include <iostream>
#include <algorithm>
#include <set>
using namespace std;

 int dx[]{ 1,1,1,0,0,-1,-1,-1 },
     dy[]{ -1,0,1,-1,1,-1,0,1 },n,c(0);
 set<pair<int, int>> obs;

void dfs(int x, int y, int k)
{
    if (min(x,y)<1 || max(x,y)>n || obs.count({ x ,y })) return;
    c++;
    dfs(x + dx[k], y + dy[k], k);
}

int main()
{
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
