// https://www.hackerrank.com/challenges/magic-square-forming/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 3;
const int M = 9;

bool is_magic(vector<int> &v) {
    int magic_num = M * (M + 1) / (2 * N);
    int diag1 = 0;
    int diag2 = 0;

    vector<vector<int> > m(N, vector<int>(N));
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            m[i][j] = v[N * i + j];
        }
    }

    for (int i = 0; i < N; ++i) {
        int row = 0;
        int col = 0;

        for (int j = 0; j < N; ++j) {
            row += m[i][j];
            col += m[j][i];
        }

        if (row != col || row != magic_num) {
            return false;
        }

        diag1 += m[i][i];
        diag2 += m[i][N - i - 1];
    }

    if (diag1 != diag2 || diag1 != magic_num) {
        return false;
    }

    return true;
}

void gen_all_magic_squares(vector<vector<int> > &magic_squares) {
    vector<int> v(M);

    for (int i = 0; i < M; ++i) {
        v[i] = i + 1;
    }

    do {
        if (is_magic(v)) {
            magic_squares.push_back(v);
        }
    } while (next_permutation(v.begin(), v.end()));
}

int diff(const vector<int> &x, const vector<int> y) {
    int res = 0;

    for (int i = 0; i < M; ++i) {
        res += abs(x[i] - y[i]);
    }

    return res;
}

int get_min_diff(const vector<int> &v, const vector<vector<int> > &ms) {
    int min_diff = 100;
    int size = ms.size();

    for (int i = 0; i < size; ++i) {
        min_diff = min(min_diff, diff(v, ms[i]));
    }

    return min_diff;
}

int main() {
    vector<vector<int> > magic_squares;
    gen_all_magic_squares(magic_squares);

    int q = 1;
    while (q--) {
        vector<int> input(M);

        for (int i = 0; i < M; ++i) {
            cin >> input[i];
        }

        cout << get_min_diff(input, magic_squares);
    }

    return 0;
}
