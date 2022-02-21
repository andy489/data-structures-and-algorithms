/*
 * Даден е лабиринт, представен чрез матрица от клетки.
 * Целта е да намерим всички пътища от стартовата позиция
 * (клетка с координати (0,0)) до финалната позиция
 * (клетка със символ 'e'). Празните (проходими) клетки са
 * маркирани с '-', а стените (непроходимите клетки) са маркирани със '*'.
 * На първия и втория ред ще получим размерите на лабиринта.
 * На следващите редове ще получаваме клетките на лабиринта.
 * Редът на пътищата е без значение.
 */

#include <iostream>
#include <vector>

using namespace std;

vector<vector<char> > maze;

int rows, cols;
vector<char> path;

void input_maze() {
    cout << "rows: ";
    cin >> rows;
    cout << "cols: ";
    cin >> cols;
    cout << "maze: " << endl;

    maze.resize(rows, vector<char>(cols));

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            cin >> maze[i][j];
        }
    }
}

bool out_of_border(int row, int col) {
    return row < 0 || col < 0 || row > rows - 1 || col > cols - 1;
}

bool is_exit(int row, int col) {
    return maze[row][col] == 'e';
}

bool is_passable(int row, int col) {
    return !(maze[row][col] == 'x' || maze[row][col] == '*');
}

void print_solution() {
    const int PATH_SIZE = path.size();
    for (int i = 1; i < PATH_SIZE; ++i) {
        cout << path[i];
        if (i != PATH_SIZE - 1) {
            cout << "->";
        }
    }

    cout << endl;
}

void solve(int row, int col, char direction) {
    if (out_of_border(row, col)) {
        return;
    }

    path.push_back(direction);

    if (is_exit(row, col)) {
        print_solution();
    } else if (is_passable(row, col)) {
        maze[row][col] = 'x'; // mark visited

        solve(row, col + 1, 'R');
        solve(row, col - 1, 'L');
        solve(row + 1, col, 'D');
        solve(row - 1, col, 'U');

        maze[row][col] = '-';
    }

    path.pop_back();
}

int main() {
    input_maze();
    solve(0, 0, 's');
    return 0;
}

/*
4
4
s - - x
- - - x
- - x -
x - e -
*/
