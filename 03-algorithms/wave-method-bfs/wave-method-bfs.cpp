#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <sstream>

using namespace std;

struct Cell {
    int x, y, level;
    bool visited, accessible;

    Cell *prev = nullptr;

    explicit Cell(bool visited = 0, bool accessible = 0, int level = -1, int x = 0, int y = 0) :
            visited(visited), accessible(accessible), level(level), x(x), y(y) {};
};

struct Maze {
    vector<int> row{0, 1, 0, -1}, col{-1, 0, 1, 0};

    int w, h;

    vector<vector<Cell>> maze;

    Maze(int w, int h) : w(w), h(h) {
        maze = vector<vector<Cell>>(h, vector<Cell>(h));
    }

    void read_input() {
        int i, j;
        for (i = 0; i < h; ++i) {
            for (j = 0; j < w; ++j) {
                cin >> maze[i][j].accessible;
                maze[i][j].x = i;
                maze[i][j].y = j;
            }
        }
    }

    bool valid(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w && maze[x][y].accessible == 0 && maze[x][y].visited == 0;
    }

    void compute_paths(int start_x, int start_y) {
        queue<Cell *> Q;

        maze[start_x][start_y].visited = true;
        maze[start_x][start_y].level = 0;
        Cell *dummy = &maze[start_x][start_y];

        Cell *currCell;

        Q.push(dummy);
        int X, Y;
        while (!Q.empty()) {
            currCell = Q.front();
            Q.pop();
            int SIZE = row.size();

            for (int i = 0; i < SIZE; ++i) {
                X = currCell->x + row[i];
                Y = currCell->y + col[i];

                if (valid(X, Y)) {
                    maze[X][Y].level = currCell->level + 1;
                    maze[X][Y].visited = true;
                    maze[X][Y].prev = currCell;
                    Q.push(&maze[X][Y]);
                }
            }
        }
    }

    int get_lvl(int x, int y) {
        return maze[x][y].level;
    }

    ostringstream get_path(int x, int y) {
        stack<Cell *> S;
        Cell *end = &maze[x][y];

        while (end != nullptr) {
            S.push(end);
            end = end->prev;
        }

        ostringstream ostream;

        if (S.empty()) {
            ostream << "no path" << endl;
            return ostream;
        }

        ostream << "path:" << endl;

        while (!S.empty()) {
            ostream << "[" << S.top()->x << "," << S.top()->y << "]" << endl;
            S.pop();
        }
        ostream << "-----" << endl;
        return ostream;
    }

    void display_maze_levels() {
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                cout << maze[i][j].level << "  ";
            }
            cout << endl;
        }
    }
};

int main() {
    int M, N, K, start_x, start_y, end_x, end_y;
    cin >> M >> N >> K >> start_x >> start_y;

    Maze maze(M, N);

    maze.read_input();
    maze.compute_paths(start_x, start_y);

    cout << endl;
    maze.display_maze_levels();

    queue<int> results;
    queue<ostringstream> paths;

    for (int i = 0; i < K; ++i) {
        cin >> end_x >> end_y;
        if (end_x >= 0 && end_y >= 0 && end_x < M && end_y < N && maze.maze[end_x][end_y].level != -1) {
            results.push(maze.get_lvl(end_x, end_y));
            paths.push(maze.get_path(end_x, end_y));
        } else {
            results.push(-1);

            paths.push(ostringstream("no path\n-----\n"));
        }
    }
    while (!results.empty()) {

        cout << "distance " << results.front() << endl;
        results.pop();

        cout << paths.front().str();
        paths.pop();
    }

    return 0;
}

/*
5 5 8 3 3
0 0 0 0 0
0 0 0 0 0
1 1 0 0 0
0 1 0 0 0
1 1 0 0 0
0 0
3 0
3 3
4 4
-2 2
5 4
4 0
4 0
*/
