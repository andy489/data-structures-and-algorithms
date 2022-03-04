/* Да се напише програма, която намира броя и вида на решенията на произволно частично запълнено судоку 9х9. */

#include <iostream>

using namespace std;

const int EMPTY = 0;
const int BOX_DIM = 3;
const int BOARD_DIM = 9;
const int N = 9;

int grid[N][N] = {{0, 0, 0, 0, 0, 0, 6, 8, 0},
                  {0, 0, 0, 0, 7, 3, 0, 0, 9},
                  {3, 0, 9, 0, 0, 0, 0, 4, 5},
                  {4, 9, 0, 0, 0, 0, 0, 0, 0},
                  {8, 0, 3, 0, 5, 0, 9, 0, 2},
                  {0, 0, 0, 0, 0, 0, 0, 3, 6},
                  {9, 6, 0, 0, 0, 0, 3, 0, 8},
                  {0, 0, 0, 6, 8, 0, 0, 0, 0},
                  {0, 2, 8, 0, 0, 0, 0, 0, 0}};

int cnt = 0;

bool find_unassigned(int &row, int &col) {
    for (row = 0; row < N; ++row) {
        for (col = 0; col < N; ++col) {
            if (grid[row][col] == EMPTY) {
                return true;
            }
        }
    }

    return false;
}

bool used_in_row(int row, int num) {
    for (unsigned col = 0; col < N; ++col) {
        if (grid[row][col] == num) {
            return true;
        }
    }

    return false;
}

bool used_in_col(int col, int num) {
    for (auto &row : grid) {
        if (row[col] == num) {
            return true;
        }
    }

    return false;
}


bool used_in_box(int box_start_row, int box_start_col, int num) {
    for (int row = 0; row < BOX_DIM; ++row) {
        for (int col = 0; col < BOX_DIM; ++col) {
            if (grid[row + box_start_row][col + box_start_col] == num) {
                return true;
            }
        }
    }

    return false;
}

bool is_safe(int row, int col, int num) {
    return !used_in_row(row, num) &&
           !used_in_col(col, num) &&
           !used_in_box(row - row % 3, col - col % 3, num) &&
           grid[row][col] == EMPTY;
}

void display_grid() {
    cnt++;

    for (auto &row : grid) {
        for (int col : row) {
            cout << col << " ";
        }
        cout << endl;
    }

    cout << endl;
}

void solve_sudoku() {
    int row = 0;
    int col = 0;

    if (!find_unassigned(row, col)) {
        display_grid();
    } else {
        // опитваме се да поставим числата от 1 до 9
        for (int num = 1; num <= BOARD_DIM; num++) {
            // ако може да поставим такова число
            if (is_safe(row, col, num)) {
                // поставяме числото на разгуването на рекурсията
                grid[row][col] = num;

                // ако сме попълнили навсякъде връщаме истина
                solve_sudoku();

                // отмаркираме клетката при свиването на рекурсията
                grid[row][col] = EMPTY;
            }
        }
    }
}

int main() {
    solve_sudoku();

    if (!cnt) {
        cout << "No solution exists" << endl;
        return 0;
    }

    cout << "Number of solutions: " << cnt << endl;
    return 0;
}
