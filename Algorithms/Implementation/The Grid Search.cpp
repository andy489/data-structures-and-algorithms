// github.com/andy489

// First Solution
#include <string>
#include <vector>
#include <cstdio>

using namespace std;

int T, R, C, r, c, i, j, a, b;
char G[1000][1000], P[1000][1000];

void solve() {
	scanf("%d%d", &R, &C);
	for (i = 0; i < R; ++i)
		scanf("%s", G[i]);
	scanf("%d%d", &r, &c);
	for (i = 0; i < r; ++i)
		scanf("%s", P[i]);
	for (i = 0; i <= R - r; ++i) {
		for (j = 0; j <= C - c; ++j) {
			for (a = 0; a < r; ++a) {
				for (b = 0; b < c; ++b) {
					if (G[i + a][j + b] != P[a][b])
						goto L1;
				}
			}
			printf("YES\n");
			return;
		L1:;
		}
	}
	printf("NO\n");
}
int main() {
	scanf("%d", &T);
	while (T--) solve();
	return 0;
}

// Second Solution
#include <iostream>
#include <vector>
using namespace std;

int q, R, C, r, c, i, j,a,b;
vector<vector<char>> G, g;

void inputGrid(int r, int c, vector<vector<char>>& grid){
    for (i = 0;i < r;++i){
        for (j = 0;j < c;++j){
            cin >> grid[i][j];
        }
    }
}

bool fingerPrint(int x, int y){
    for(a=0;a<r;++a){
        for(b=0;b<c;++b){
            if(g[a][b]!=G[x+a][y+b]) return false;
        }
    }return true;
}

int main(){
    cin >> q;L:
    while (q--){
        bool isPresent(false);
        cin >> R >> C;
        G.assign(1000, vector<char>(1000));
        inputGrid(R, C, G);
        cin >> r >> c;
        g.assign(1000, vector<char>(1000));
        inputGrid(r, c, g);

        for (i = 0;i < R - r + 1;++i){
            for (j = 0;j < C - c + 1;++j){
                isPresent |= fingerPrint(i, j);                
            }
        }
        cout<<(isPresent?"YES":"NO")<<'\n';        
    }return 0;
}
