/*
 * Да се намерят всички възможни начини, по които може да се поставят 8 царици
 * на шахматна дъска така, че да не се атакуват една-друга.
 *
 *
 */

#include <iostream>
#include <set>

using namespace std;

const int SIZE = 8;

int board[SIZE][SIZE];

set<int> attacked_rows;
set<int> attacked_cols;

unsigned cnt;

bool can_place_queen(int row, int col) {
    if (attacked_rows.count(row) || attacked_cols.count(col)) return false;
    // left-up
    for (int i = 1; i < SIZE; i++) {
        int curr_row = row - i;
        int curr_col = col - i;

        if (curr_row < 0 || curr_row >= SIZE || curr_col < 0 || curr_col >= SIZE) {
            break;
        }
        if (board[curr_row][curr_col] == 1) { // queen here
            return false;
        }
    }
    // right-up
    for (int i = 1; i < SIZE; i++) {
        int curr_row = row - i;
        int curr_col = col + i;

        if (curr_row < 0 || curr_row >= SIZE || curr_col < 0 || curr_col >= SIZE) {
            break;
        }
        if (board[curr_row][curr_col] == 1) { // queen here
            return false;
        }
    }
    // left-down
    for (int i = 1; i < SIZE; i++) {
        int curr_row = row + i;
        int curr_col = col - i;

        if (curr_row < 0 || curr_row >= SIZE || curr_col < 0 || curr_col >= SIZE) {
            break;
        }
        if (board[curr_row][curr_col] == 1) { // queen here
            return false;
        }
    }
    // right-down
    for (int i = 1; i < SIZE; i++) {
        int curr_row = row + i;
        int curr_col = col + i;

        if (curr_row < 0 || curr_row >= SIZE || curr_col < 0 || curr_col >= SIZE) {
            break;
        }
        if (board[curr_row][curr_col] == 1) { // queen here
            return false;
        }
    }
    return true;
}

void mark_attacked_fields(int row, int col) {
    board[row][col] = 1;
    attacked_rows.insert(row);
    attacked_cols.insert(col);
}

void unmark_attacked_fields(int row, int col) {
    board[row][col] = 0;
    attacked_rows.erase(row);
    attacked_cols.erase(col);
}

void print_solution() {
    cnt++;
    for (auto &row : board) {
        for (int col : row) {
            if (col == 1) cout << "Q ";
            else cout << "- ";
        }
        cout << endl;
    }
    cout << endl;
}

void solve(int row) {
    if (row == SIZE) {
        print_solution();
        return;
    } else {
        for (int col = 0; col < SIZE; col++) {
            if (can_place_queen(row, col)) {
                mark_attacked_fields(row, col);
                solve(row + 1);
                unmark_attacked_fields(row, col);
            }
        }
    }
}

int main() {
    solve(0);
    cout << "Total count: " << cnt << endl;
    return 0;
}
