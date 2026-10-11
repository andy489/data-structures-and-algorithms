// https://www.hackerrank.com/contests/practice-8-sda/challenges/maze-9

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Cell {
    char ch;
    int x, y, level;
    bool visited;

    Cell(char ch = 'a', int x = -1, int y = -1, int level = -1, bool visited = false) :
            ch(ch), x(x), y(y), level(level), visited(visited) {}
};

bool is_valid(vector<vector<Cell>> &maze, int x, int y, int n, int m) {
    return x >= 0 && y >= 0 && x < n && y < m &&
           maze[x][y].ch != '#';
}

void bfs(Cell *s, vector<vector<Cell>> &maze, int n, int m) {
    const int DIR = 4;
    int xd[] = {1, 0, -1, 0};
    int yd[] = {0, -1, 0, 1};

    queue<Cell *> q;
    s->visited = true;
    s->level = 0;
    q.push(s);

    while (!q.empty()) {
        Cell *curr = q.front();
        q.pop();

        for (int i = 0; i < DIR; ++i) {
            int newX = curr->x + xd[i];
            int newY = curr->y + yd[i];

            if (is_valid(maze, newX, newY, n, m) && !maze[newX][newY].visited) {
                maze[newX][newY].visited = true;
                maze[newX][newY].level = curr->level + 1;
                q.push(&maze[newX][newY]);
            }

            if (is_valid(maze, newX, newY, n, m)) {
                bool flag_portal = false;
                while (is_valid(maze, newX + xd[i], newY + yd[i], n, m)) {
                    flag_portal = true;
                    newX += xd[i];
                    newY += yd[i];
                }

                if (flag_portal && !maze[newX][newY].visited) { // add portal to queue
                    maze[newX][newY].visited = true;
                    maze[newX][newY].level = curr->level + 1;
                    q.push(&maze[newX][newY]);
                }
            }
        }
    }
}

int main() {
    Cell *start = nullptr;
    Cell *fin = nullptr;

    int n, m;
    cin >> n >> m;

    vector<vector<Cell>> maze;
    maze.assign(n, vector<Cell>(m));

    char ch;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> ch;
            maze[i][j] = {ch, i, j};

            if (ch == 'S') {
                start = &maze[i][j];
            }

            if (ch == 'F') {
                fin = &maze[i][j];
            }
        }
    }

    bfs(start, maze, n, m);

    cout << fin->level;

    return 0;
}
