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
