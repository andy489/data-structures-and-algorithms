// https://www.hackerrank.com/challenges/two-pluses/problem
// Brute force solution

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m, r, R, answer;

bool is_valid(int a, int b, bool rb, bool Rb) {
    return a - (r * rb + R * Rb) >= 0 && b - (r * rb + R * Rb) >= 0 &&
           a + (r * rb + R * Rb) < n && b + (r * rb + R * Rb) < m;
}

int main() {
    cin >> n >> m;
    vector<vector<char> > g(n, vector<char>(m));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> g[i][j];
        }
    }

    for (int x = 0; x < n; ++x) {
        for (int y = 0; y < m; ++y) {
            r = 0;
            while (is_valid(x, y, true, false) && g[x + r][y] == 'G' && g[x - r][y] == 'G' &&
                   g[x][y + r] == 'G' && g[x][y - r] == 'G') {
                g[x + r][y] = g[x - r][y] = g[x][y + r] = g[x][y - r] = 'g';
                for (int X = 0; X < n; ++X) {
                    for (int Y = 0; Y < m; ++Y) {
                        R = 0;
                        while (is_valid(X, Y, false, true) && g[X + R][Y] == 'G' && g[X - R][Y] == 'G' &&
                               g[X][Y + R] == 'G' && g[X][Y - R] == 'G') {
                            answer = max(answer, (1 + 4 * r) * (1 + 4 * R));
                            ++R;
                        }
                    }
                }
                ++r;
            }
            r = 0;

            while (is_valid(x, y, 1, 0) && g[x + r][y] == 'g' && g[x - r][y] == 'g' &&
                   g[x][y + r] == 'g' && g[x][y - r] == 'g') {
                g[x + r][y] = g[x - r][y] = g[x][y + r] = g[x][y - r] = 'G';
                ++r;
            }
        }
    }

    cout << answer;
}
