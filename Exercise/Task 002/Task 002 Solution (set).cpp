#include <cstdio>
#include <set>
#include <algorithm>
using namespace std;
int main()
{
    int dx[]{ -1,-1,-1,0,0,1,1,1 },
        dy[]{ -1,0,1,-1,1,-1,0,1 },
        n,k,x,y,xx,yy,c(0);

    scanf("%d%d%d%d", &n, &k,&x,&y);
    set<pair<int, int>> bad;
    while (k--)
    {
        scanf("%d%d", &xx, &yy);
        bad.insert({xx, yy});
    }
    
    for (k = 0;k < 8;++k) 
    {
        int nx = x + dx[k];
        int ny = y + dy[k];

        while (true)
        {    
            if(min(nx, ny) < 1 || max(nx, ny) > n || bad.count({nx, ny}))
            {
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
