#include <iostream>
#include <vector>
using namespace std;

int q, R, C, r, c, i, j,a,b;
vector<vector<char>> G, g;

void inputGrid(int r, int c, vector<vector<char>>& grid)
{
    for (i = 0;i < r;++i)
    {
        for (j = 0;j < c;++j)
        {
            cin >> grid[i][j];
        }
    }
}

bool fingerPrint(int x, int y)
{
    for(a=0;a<r;++a)
    {
        for(b=0;b<c;++b)
        {
            if(g[a][b]!=G[x+a][y+b]) return false;
        }
    }
    return true;
}

int main()
{
    srand((unsigned)time(0));
    cin >> q;L:
    while (q--)
    {
        bool isPresent(false);
        cin >> R >> C;
        G.assign(1000, vector<char>(1000));
        inputGrid(R, C, G);
        cin >> r >> c;
        g.assign(1000, vector<char>(1000));
        inputGrid(r, c, g);

        for (i = 0;i < R - r + 1;++i)
        {
            for (j = 0;j < C - c + 1;++j)
            {
                isPresent |= fingerPrint(i, j);                
            }
        }
        cout<<(isPresent?"YES":"NO")<<'\n';        
    }
    return 0;
}
