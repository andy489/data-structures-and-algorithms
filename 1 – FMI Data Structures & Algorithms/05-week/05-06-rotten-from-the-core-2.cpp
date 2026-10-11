// https://www.hackerrank.com/contests/practice-5-sda/challenges/rotten-from-the-core

#include <iostream>
#include <queue>

using namespace std;

struct Apple {
    int row, col, day;

    Apple(int row, int col, int day) : row(row), col(col), day(day) {}
};

bool is_valid(int n, int m, int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < m;
}

int solve(int n, int m, int t) {
    vector<vector<bool>> A(n, vector<bool>(m));

    queue<Apple> q;
    int r, c, rotten = 0;

    while (cin >> r >> c) {
        q.emplace(r - 1, c - 1, 0);
        A[r - 1][c - 1] = true;
        ++rotten;
    }

    const vector<int> row_dim{0, 1, 0, -1};
    const vector<int> col_dim{-1, 0, 1, 0};
    const int DIM = 4;

    while (!q.empty()) {
        Apple top = q.front();
        q.pop();

        if (top.day >= t) {
            break;
        }

        for (int i = 0; i < DIM; ++i) {
            if (is_valid(n, m, top.row + row_dim[i], top.col + col_dim[i]) &&
                !A[top.row + row_dim[i]][top.col + col_dim[i]]) {

                ++rotten;
                q.emplace(top.row + row_dim[i], top.col + col_dim[i], top.day + 1);

                A[top.row + row_dim[i]][top.col + col_dim[i]] = true;
            }
        }
    }

    return n * m - rotten;
}

int main() {
    int n, m, t;
    cin >> n >> m >> t;

    cout << solve(n, m, t);

    return 0;
}
