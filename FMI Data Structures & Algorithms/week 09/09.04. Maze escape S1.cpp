// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/maze-9

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> xd{1, 0, -1, 0}, yd{0, -1, 0, 1};

#define DIRECTIONS 4

struct Cell {
    char ch;
    int x, y, level;
    bool visited;

    Cell(char ch = 'a', int x = -1, int y = -1, int level = -1, bool visited = 0) :
            ch(ch), x(x), y(y), level(level), visited(visited) {}
};

bool isValid(vector<vector<Cell>> &maze, int x, int y, int n, int m) {
    return x >= 0 && y >= 0 && x < n && y < m &&
           maze[x][y].ch != '#';
}

void bfs(Cell *s, vector<vector<Cell>> &maze, int n, int m) {
    queue<Cell *> Q;
    s->visited = true;
    s->level = 0;
    Q.push(s);

    while (!Q.empty()) {
        Cell *curr = Q.front();
        Q.pop();

        for (int i = 0; i < DIRECTIONS; ++i) {
            int newX = curr->x + xd[i];
            int newY = curr->y + yd[i];
            if (isValid(maze, newX, newY, n, m) && !maze[newX][newY].visited) {
                maze[newX][newY].visited = true;
                maze[newX][newY].level = curr->level + 1;
                Q.push(&maze[newX][newY]);
            }

            if (isValid(maze, newX, newY, n, m)) {
                bool flag = false;
                while (isValid(maze, newX + xd[i], newY + yd[i], n, m)) {
                    flag = true;
                    newX += xd[i];
                    newY += yd[i];
                }
                if (flag && !maze[newX][newY].visited) {
                    maze[newX][newY].visited = true;
                    maze[newX][newY].level = curr->level + 1;
                    Q.push(&maze[newX][newY]);
                }
            }
        }
    }
}

int main() {
    int n, m, i, j;
    char ch;

    Cell *start(nullptr), *fin(nullptr);

    cin >> n >> m;

    vector<vector<Cell>> maze;
    maze.assign(n, vector<Cell>(m));

    for (i = 0; i < n; ++i) {
        for (j = 0; j < m; ++j) {
            cin >> ch;
            maze[i][j] = {ch, i, j};
            if (ch == 'S') start = &maze[i][j];
            if (ch == 'F') fin = &maze[i][j];
        }
    }
    bfs(start, maze, n, m);
    return cout << fin->level, 0;
}
