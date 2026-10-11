// https://www.hackerrank.com/contests/si-practice-5/challenges/labirint/problem

#include <iostream>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> maze;

const int DIR = 4;
// utility arrays to get row and col of 4 neighbours of a cell
int row_num[] = {-1, 0, 0, 1};
int col_num[] = {0, -1, 1, 0};

struct Point {
    int x = 0;
    int y = 0;

    Point(int x = 0, int y = 0) : x(x), y(y) {}
};

struct queue_node {
    Point p;
    int distance;
};

void read_maze() {
    maze.resize(n);

    int input_data;
    for (int i = 0; i < n; ++i) {
        maze[i].resize(m); // initially all cells are 0
        for (int j = 0; j < m; ++j) {
            cin >> input_data;
            maze[i][j] = -input_data; // forbidden cells are marked with -1
        }
    }
}

bool is_valid(int row, int col) { // check if row and col are in range
    return (row >= 0) && (row < n) && (col >= 0) && (col < m);
}

void bfs(int start_x, int start_y) {
    // if src is forbidden to step
    if (maze[start_x][start_y]) {
        // make all cells unreachable
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                maze[i][j] = -1;
            }
        }
        return;
    }

    maze[start_x][start_y] = 1;
    // distance of src cell is 1, because with 0 we mark unvisited cell

    queue<queue_node> q;

    queue_node s = {{start_y, start_y}, 1}; // distance for src cell is 1 (we will fix that later)
    q.push(s); // enqueue src cell

    // do a bfs starting from src cell
    while (!q.empty()) {
        queue_node curr = q.front();
        Point p = curr.p;

        // dequeue the front cell in the queue and enqueue its adjacent cells
        q.pop();

        for (int i = 0; i < DIR; ++i) {
            int row = p.x + row_num[i];
            int col = p.y + col_num[i];

            // in range, passable, not visited [!maze[row][col] will be true <=> maze[row][col] is 0, i.e. not visited]
            if (is_valid(row, col) && !maze[row][col]) {

                maze[row][col] = curr.distance + 1;
                queue_node adjacent_cell = {{row, col}, curr.distance + 1};
                q.push(adjacent_cell);
            }
        }
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (maze[i][j] >= 0) {
                --maze[i][j]; // fix distances
            }
        }
    }
}

int main() {
    int k;
    cin >> n >> m >> k;

    read_maze();

    // traverse once and calc all shortest paths [ smartest decision for queries]
    bfs(0, 0);

    while (k--) {
        int x, y;
        cin >> x >> y; // coordinates of dest

        cout << maze[x][y] << endl;
    }

    return 0;
}

