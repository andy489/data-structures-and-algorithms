// https://www.hackerrank.com/challenges/the-grid-search/problem
// 2nd solution

#include <iostream>
#include <vector>

using namespace std;

const int MAX = 1000;

vector<vector<char>> G, g;

void input_grid(int r, int c, vector<vector<char>> &grid) {
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> grid[i][j];
        }
    }
}

bool finger_print(int x, int y, int r, int c) {
    for (int a = 0; a < r; ++a) {
        for (int b = 0; b < c; ++b) {
            if (g[a][b] != G[x + a][y + b]) return false;
        }
    }
    return true;
}

int main() {
    int q;
    cin >> q;

    int R, C, r, c;
    while (q--) {
        bool is_present = false;
        cin >> R >> C;

        G.assign(MAX, vector<char>(MAX));
        input_grid(R, C, G);

        cin >> r >> c;
        g.assign(MAX, vector<char>(MAX));
        input_grid(r, c, g);

        for (int i = 0; i < R - r + 1; ++i) {
            for (int j = 0; j < C - c + 1; ++j) {
                is_present |= finger_print(i, j, r, c);
            }
        }

        cout << (is_present ? "YES" : "NO") << endl;
    }

    return 0;
}
