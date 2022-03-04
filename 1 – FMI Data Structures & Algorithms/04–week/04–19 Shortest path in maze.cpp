#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

int arr1[] = {0, 1, 0, -1};
int arr2[] = {-1, 0, 1, 0};

const int DIR = 4;

int n;

bool is_valid(int i, int j, vector<vector<int>> &maze, vector<vector<int>> &used) {
    if (i < 0 || j < 0 || i >= n || j >= n) {
        return false;
    }

    if (maze[i][j] || used[i][j]) {
        return false;
    }

    return true;
}

void print_path(int endI, int endJ, vector<vector<int>> &used,
                vector<vector<pair<int, int>>> &parent) {
    if (used[endI][endJ] == 0) {
        cout << "no path" << endl;

        return;
    }

    pair<int, int> node = {endI, endJ};
    stack<pair<int, int>> S;

    while (node != pair<int, int>{-1, -1}) {
        S.push(node);
        node = parent[node.first][node.second];
    }

    cout << "Path length is " << S.size() << endl;

    while (!S.empty()) {
        cout << "[" << S.top().first << ", " << S.top().second << "]"<< endl;
        S.pop();
    }
}

void bfs(int startI, int startJ, int endI, int endJ, vector<vector<int>> &maze,
         vector<vector<int>> &used, vector<vector<pair<int, int>>> &parent) {

    pair<int, int> point;
    queue<pair<int, int>> q;

    q.push({startI, startJ});

    used[startI][startJ] = 1;
    parent[startI][startJ] = {-1, -1};

    int x, y;
    while (!q.empty()) {
        point = q.front();
        q.pop();

        for (int i = 0; i < DIR; ++i) {
            x = point.first + arr1[i];
            y = point.second + arr2[i];

            if (is_valid(x, y, maze, used)) {
                q.push({x, y});
                used[x][y] = true;
                parent[x][y] = {point.first, point.second};

                if (x == endI && y == endJ) {
                    return;
                }
            }
        }
    }
}

int main() {
    cin >> n;

    vector<vector<int>> maze(n);
    vector<vector<int>> used(n);

    vector<vector<pair<int, int>>> parent(n);

    for (int i = 0; i < n; ++i) {
        maze[i] = vector<int>(n);
        used[i] = vector<int>(n, 0);
        parent[i] = vector<pair<int, int>>(n);
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> maze[i][j];
        }
    }


    int start_i;
    int start_j;

    int end_i;
    int end_j;

    cin >> start_i >> start_j >> end_i >> end_j;
    cout << endl;

    bfs(start_i, start_j, end_i, end_j, maze, used, parent);

    print_path(end_i, end_j, used, parent);

    return 0;
}

/*
input
5
0 0 0 0 0
0 1 1 1 1
0 0 0 1 1
1 1 0 0 0
1 1 1 0 1
0 4
4 3
output
Path length is 12
[0, 4]
[0, 3]
[0, 2]
[0, 1]
[0, 0]
[1, 0]
[2, 0]
[2, 1]
[2, 2]
[3, 2]
[3, 3]
[4, 3]

input
3
0 0 0
0 1 1
0 0 0
0 2
2 2
output
Path length is 7
[0, 2]
[0, 1]
[0, 0]
[1, 0]
[2, 0]
[2, 1]
[2, 2]

input
6
1 1 0 1 1 1
0 0 0 0 0 0
1 1 1 0 0 0
1 1 1 1 0 0
0 0 1 0 0 0
0 0 0 0 1 1
0 2
4 1
output
Path length is 12
[0, 2]
[1, 2]
[1, 3]
[2, 3]
[2, 4]
[3, 4]
[4, 4]
[4, 3]
[5, 3]
[5, 2]
[5, 1]
[4, 1]

input
4
0 1 0 0
0 0 1 0
0 0 0 1
1 0 0 0
0 0
1 3
output
no path
*/
