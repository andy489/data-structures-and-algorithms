#include <iostream>
#include <set>

using namespace std;

const int SIZE = 8;

bool board[SIZE][SIZE];

set<int> attacked_cols;
set<int> attacked_left_diagonals;
set<int> attacked_right_diagonals;

int cnt;

bool can_place_queen(int row, int col) {
    bool position_occupied = attacked_cols.count(col) ||
                             attacked_left_diagonals.count(col - row) ||
                             attacked_right_diagonals.count(row + col);
    return !position_occupied;
}

void mark_all_attacked_positions(int row, int col) {
    attacked_cols.insert(col);
    attacked_left_diagonals.insert(col - row);
    attacked_right_diagonals.insert(row + col);
    board[row][col] = true;
}

void unmark_all_attacked_positions(int row, int col) {
    attacked_cols.erase(col);
    attacked_left_diagonals.erase(col - row);
    attacked_right_diagonals.erase(row + col);
    board[row][col] = false;
}

void print_solution() {
    cnt++;
    int row, col;
    for (row = 0; row < SIZE; row++) {
        for (col = 0; col < SIZE; col++) {
            if (board[row][col] == 1) {
                cout << "Q ";
            } else {
                cout << "- ";
            }
        }
        cout << endl;
    }
    cout << endl;
}

void put_queens(int row) {
    if (row == SIZE) {
        print_solution();
    } else {
        int col;
        for (col = 0; col < SIZE; col++) {
            if (can_place_queen(row, col)) {
                mark_all_attacked_positions(row, col);
                put_queens(row + 1);
                unmark_all_attacked_positions(row, col);
            }
        }
    }
}

int main() {
    put_queens(0);
    cout << "Total count: " << cnt << endl;
    return 0;
}