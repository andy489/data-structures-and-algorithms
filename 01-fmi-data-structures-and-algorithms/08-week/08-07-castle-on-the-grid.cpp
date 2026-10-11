// https://www.hackerrank.com/challenges/castle-on-the-grid/problem

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, sx, sy, ex, ey;;

vector<vector<char>> grid;
vector<vector<int>> shortest_paths;

bool is_valid(int x, int y, int prev_x, int prev_y) {
    return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == '.' &&
           (shortest_paths[x][y] == -1 || shortest_paths[x][y] == shortest_paths[prev_x][prev_y] + 1);
}

void bfs() {
    const int DIR = 4;
    const int xd[] = {0, 0, -1, 1};
    const int yd[] = {1, -1, 0, 0};

    shortest_paths[sx][sy] = 0;

    queue<pair<int, int>> q;
    q.push({sx, sy});

    while (!q.empty()) {
        auto p = q.front();
        q.pop();

        for (int i = 0; i < DIR; ++i) {
            int next_x = p.first + xd[i];
            int next_y = p.second + yd[i];

            while(is_valid(next_x, next_y, p.first, p.second)) {
                q.push({next_x, next_y});
                shortest_paths[next_x][next_y] = shortest_paths[p.first][p.second] + 1;

                next_x += xd[i];
                next_y += yd[i];
            }
        }
    }
}

void init_grid() {
    cin >> n;

    grid.resize(n, vector<char>(n));
    shortest_paths.resize(n, vector<int>(n, -1));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> grid[i][j];
        }
    }

    cin >> sx >> sy >> ex >> ey;
}

int main() {
    init_grid();

    bfs();

    cout << shortest_paths[ex][ey];

    return 0;
}