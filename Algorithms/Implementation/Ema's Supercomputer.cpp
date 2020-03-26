// github.com/andy489


//First Solution (brute force)
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, i, j, x, y, X, Y, r, R, ans;

bool isValid(int a, int b, bool rb, bool Rb){
	return a - (r * rb + R * Rb) >= 0 && b - (r * rb + R * Rb) >= 0 &&
		a + (r * rb + R * Rb) < n && b + (r * rb + R * Rb) < m;
}

int main() {
	cin >> n >> m;
	vector<vector<char>>g(n, vector<char>(m));
	for (i = 0; i < n; ++i) {
		for (j = 0; j < m; ++j) {
			cin >> g[i][j];
		}
	}

	for (x = 0; x < n; ++x) {
		for (y = 0;y < m; ++y) {
			r = 0;
			while (isValid(x, y, 1, 0) && g[x + r][y] == 'G' && g[x - r][y] == 'G' &&
				g[x][y + r] == 'G' && g[x][y - r] == 'G') {
				g[x + r][y] = g[x - r][y] = g[x][y + r] = g[x][y - r] = 'g';
				for (X = 0; X < n; ++X) {
					for (Y = 0; Y < m; ++Y) {
						R = 0;
						while (isValid(X, Y, 0, 1) && g[X + R][Y] == 'G' && g[X - R][Y] == 'G' &&
							g[X][Y + R] == 'G' && g[X][Y - R] == 'G') {
							ans = max(ans, (1 + 4 * r) * (1 + 4 * R));
							++R;
						}
					}
				}
				++r;
			}
			r = 0;
			while (isValid(x, y, 1, 0) && g[x + r][y] == 'g' && g[x - r][y] == 'g' &&
				g[x][y + r] == 'g' && g[x][y - r] == 'g') {
				g[x + r][y] = g[x - r][y] = g[x][y + r] = g[x][y - r] = 'G';
				++r;
			}
		}
	}
	cout << ans;
}
