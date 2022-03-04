// https://www.hackerrank.com/challenges/frog-in-maze/problem

#include <iostream>
#include <vector>
#include <iomanip>
#include <cmath>

using namespace std;

const int INF = 1e9;
const long double EPS = 1e-9;

const int MAZE_SIZE = 20;
char maze[MAZE_SIZE][MAZE_SIZE];
int tunnel[MAZE_SIZE][MAZE_SIZE];
int ind[MAZE_SIZE][MAZE_SIZE];
char vis[MAZE_SIZE][MAZE_SIZE];

int N;
int n, m;

const int T = MAZE_SIZE * MAZE_SIZE;

long double a[T][T];
long double c[T];

int get_type(int x, int y) { //0-empty, 1-no way, 2 - exit, 3-mine
    if (x < 0 || x >= n || y < 0 || y >= m) return 1;
    if (maze[x][y] == 'O' || maze[x][y] == 'A') return 0;
    if (maze[x][y] == '#') return 1;
    if (maze[x][y] == '%') return 2;
    if (maze[x][y] == '*') return 3;
    return 100;
}

int get_index(int x, int y) {
    if (ind[x][y] == -1) {
        ind[x][y] = N;
        N++;
    }
    return ind[x][y];
}

void dfs(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] == 1 || get_type(x, y) != 0) {
        return;
    }

    vis[x][y] = 1;

    int z = get_index(x, y);

    int h = 0, r = 0;
    int xx = x;
    int yy = y;

    if (tunnel[x][y] != -1) {
        xx = tunnel[x][y] / 100;
        yy = tunnel[x][y] % 100;
    }

    if (get_type(xx - 1, yy) != 1) ++h;
    if (get_type(xx, yy - 1) != 1) ++h;
    if (get_type(xx + 1, yy) != 1) ++h;
    if (get_type(xx, yy + 1) != 1) ++h;

    if (get_type(xx - 1, yy) == 2) ++r;
    if (get_type(xx, yy - 1) == 2) ++r;
    if (get_type(xx + 1, yy) == 2) ++r;
    if (get_type(xx, yy + 1) == 2) ++r;

    if (h == 0) {
        a[z][z] = 1;
        return;
    }

    if (get_type(xx - 1, yy) == 0) a[z][get_index(xx - 1, yy)] = -1;
    if (get_type(xx, yy - 1) == 0) a[z][get_index(xx, yy - 1)] = -1;
    if (get_type(xx + 1, yy) == 0) a[z][get_index(xx + 1, yy)] = -1;
    if (get_type(xx, yy + 1) == 0) a[z][get_index(xx, yy + 1)] = -1;

    a[z][z] += h;
    c[z] = r;

    dfs(xx - 1, yy);
    dfs(xx, yy - 1);
    dfs(xx + 1, yy);
    dfs(xx, yy + 1);
}

int gauss(vector<vector<long double> > &_a, vector<long double> &ans) {
    const int NN = (int) _a.size();
    const int MM = (int) _a[0].size() - 1;

    vector<int> where(MM, -1);

    for (int col = 0, row = 0; col < MM && row < NN; ++col) {
        int sel = row;

        for (int i = row; i < NN; ++i) {
            if (abs(_a[i][col]) > abs(_a[sel][col])) {
                sel = i;
            }
        }

        if (abs(_a[sel][col]) < EPS) {
            continue;
        }

        for (int i = col; i <= MM; ++i) {
            swap(_a[sel][i], _a[row][i]);
        }

        where[col] = row;

        for (int i = 0; i < NN; ++i) {
            if (i != row) {
                long double cc = _a[i][col] / _a[row][col];
                
                for (int j = col; j <= MM; ++j) {
                    _a[i][j] -= _a[row][j] * cc;
                }
            }
        }

        ++row;
    }

    ans.assign(MM, 0);
    for (int i = 0; i < MM; ++i)
        if (where[i] != -1)
            ans[i] = _a[where[i]][MM] / _a[where[i]][i];
    for (int i = 0; i < NN; ++i) {
        long double sum = 0;
        for (int j = 0; j < MM; ++j)
            sum += ans[j] * _a[i][j];
        if (abs(sum - _a[i][MM]) > EPS)
            return 0;
    }

    for (int i = 0; i < MM; ++i)
        if (where[i] == -1)
            return INF;
    return 1;
}


int main() {

    int k;
    cin >> n >> m >> k;


    for (int i = 0; i < n; ++i) {
        cin >> maze[i];
    }

    int x_start, y_start;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            ind[i][j] = -1;
            tunnel[i][j] = -1;
            vis[i][j] = false;

            if (maze[i][j] == 'A') {
                x_start = i;
                y_start = j;
            }
        }
    }

    int start_tunnel_x, start_tunnel_y, end_tunnel_x, end_tunnel_y;
    for (int i = 0; i < k; ++i) {
        cin >> start_tunnel_x >> start_tunnel_y >> end_tunnel_x >> end_tunnel_y;
        --start_tunnel_x, --end_tunnel_x, --start_tunnel_y, --end_tunnel_y;

        tunnel[start_tunnel_x][start_tunnel_y] = 100 * end_tunnel_x + end_tunnel_y;
        tunnel[end_tunnel_x][end_tunnel_y] = 100 * start_tunnel_x + start_tunnel_y;
    }

    for (int i = 0; i < T; ++i) {
        for (int j = 0; j < T; ++j) {
            a[i][j] = 0;
        }

        c[i] = 0;
    }

    dfs(x_start, y_start);

    int no_exit = 1;
    for (int i = 0; i < N; ++i) {
        if (c[i] != 0) {
            no_exit = 0;
        }
    }

    if (no_exit) {
        return printf("0"), 0;
    }

    vector<vector<long double> > aa;
    aa.resize(N);

    for (int i = 0; i < N; ++i) {
        aa[i].resize(N + 1);

        for (int j = 0; j < N; ++j) {
            aa[i][j] = a[i][j];
        }

        aa[i][N] = c[i];
    }

    vector<long double> ans;

    gauss(aa, ans);

    cout << fixed << setprecision(10);
    cout << ans[get_index(x_start, y_start)] << endl;

    return 0;
}