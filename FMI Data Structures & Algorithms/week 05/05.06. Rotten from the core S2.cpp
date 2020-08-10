// github.com/andy489

// https://www.hackerrank.com/contests/practice-5-sda/challenges/rotten-from-the-core

#include <iostream>
#include <queue>

using namespace std;

struct Apple {
    int row, col, day;

    Apple(int row, int col, int day) : row(row), col(col), day(day) {}
};

bool isValid(int n, int m, int r, int c) {
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
    while (!q.empty()) {
        Apple top = q.front();
        q.pop();
        if (top.day >= t) break;
        if (isValid(n, m, top.row + 1, top.col) && !A[top.row + 1][top.col]) {
            ++rotten;
            q.emplace(top.row + 1, top.col, top.day + 1);
            A[top.row + 1][top.col] = true;
        }
        if (isValid(n, m, top.row - 1, top.col) && !A[top.row - 1][top.col]) {
            ++rotten;
            q.emplace(top.row - 1, top.col, top.day + 1);
            A[top.row - 1][top.col] = true;
        }
        if (isValid(n, m, top.row, top.col + 1) && !A[top.row][top.col + 1]) {
            ++rotten;
            q.emplace(top.row, top.col + 1, top.day + 1);
            A[top.row][top.col + 1] = true;
        }
        if (isValid(n, m, top.row, top.col - 1) && !A[top.row][top.col - 1]) {
            ++rotten;
            q.emplace(top.row, top.col - 1, top.day + 1);
            A[top.row][top.col - 1] = true;
        }
    }
    return n * m - rotten;
}

int main() {
    int n, m, t;
    cin >> n >> m >> t;
    return cout << solve(n, m, t), 0;
}
