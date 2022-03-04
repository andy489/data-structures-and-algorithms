#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

int n, m;
vector<vector<int>> matrix;
vector<vector<int>> sums;

void read_matrix() {
    matrix.resize(n, vector<int>(m));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> matrix[i][j];
        }
    }
}

void build_sums() {
    sums.resize(n, vector<int>(m));

    sums[0][0] = matrix[0][0];

    for (int row = 1; row < n; ++row) {
        sums[row][0] = sums[row - 1][0] + matrix[row][0];
    }

    for (int col = 1; col < m; ++col) {
        sums[0][col] = sums[0][col - 1] + matrix[0][col];
    }

    for (int i = 1; i < n; ++i) {
        for (int j = 1; j < m; ++j) {
            sums[i][j] = max(sums[i - 1][j], sums[i][j - 1]) + matrix[i][j];
        }
    }
}

void display_matrix(const vector<vector<int>> &mat) {
    const int ROWS = mat.size();
    const int COLS = mat[0].size();

    for (int i = 0; i < ROWS; ++i) {
        for (int j = 0; j < COLS; ++j) {
            cout << mat[i][j] << ' ';
        }

        cout << endl;
    }
}

int main() {
    cin >> n >> m;

    read_matrix();

    build_sums();

    // display_matrix(sums);

    stack<string> result_path;

    int curr_row = n - 1;
    int curr_col = m - 1;

    string curr_res = '[' + to_string(curr_row) + ", " + to_string(curr_col) + ']';
    result_path.push(curr_res);

    while (!(curr_row == 0 || curr_col == 0)) {
        int top = sums[curr_row - 1][curr_col];
        int left = sums[curr_row][curr_col - 1];

        if (top > left) {
            curr_res.clear();

            curr_res = '[' + to_string(curr_row - 1) + ", " + to_string(curr_col) + ']';
            result_path.push(curr_res);

            --curr_row;
        } else {
            curr_res.clear();

            curr_res = '[' + to_string(curr_row) + ", " + to_string(curr_col - 1) + ']';
            result_path.push(curr_res);

            --curr_col;
        }
    }

    if (curr_row == 0) {
        for (int i = 0; i < curr_col; ++i) {
            cout << "[0, " + to_string(i) + "] ";
        }
    } else {
        for (int i = 0; i < curr_row; ++i) {
            cout << "[" + to_string(i) + ", 0] ";
        }
    }

    while (!result_path.empty()) {
        cout << result_path.top() << ' ';
        result_path.pop();
    }

    return 0;
}