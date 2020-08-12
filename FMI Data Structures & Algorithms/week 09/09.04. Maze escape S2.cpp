// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/maze-9

#include <iostream>
#include <vector>
#include <stdexcept>
#include <queue>
#include <tuple>

using namespace std;

class Maze {
    size_t n, m;
    vector<string> table;
    static constexpr int dx[] = {0, 1, 0, -1},
            dy[] = {-1, 0, 1, 0};
    static constexpr size_t directions = sizeof dx / sizeof *dx;

    pair<size_t, size_t> findStart() const {
        for (size_t i = 0; i < n; i++)
            for (size_t j = 0; j < m; j++)
                if (table[i][j] == 'S')
                    return {i, j};
        throw runtime_error("no start");
    }

public:
    Maze(istream &is) {
        is >> n >> m;
        for (size_t i = 0; i < n; i++) {
            string row;
            is >> row;
            table.push_back(move(row));
        }
    }

    bool isValid(size_t i, size_t j) const {
        return i < n && j < m && table[i][j] != '#';
    }

    bool isVisited(size_t i, size_t j) const {
        return table[i][j] == '%';
    }

    int shortestPath() {
        vector<vector<int>> dist(n, vector<int>(m));
        queue<pair<size_t, size_t>> q;
        auto visit = [&](size_t i, size_t j, size_t iFrom, size_t jFrom) {
            q.emplace(i, j);
            dist[i][j] = dist[iFrom][jFrom] + 1;
            if (table[i][j] == 'F') return true;
            table[i][j] = '%';
            return false;
        };
        auto p = findStart();
        q.push(p);
        table[p.first][p.second] = '%';
        while (!q.empty()) {
            int x, y;
            tie(x, y) = q.front();
            q.pop();
            for (size_t i = 0; i < directions; i++) {
                if (isValid(x + dx[i], y + dy[i]) && !isVisited(x + dx[i], y + dy[i]))
                    if (visit(x + dx[i], y + dy[i], x, y)) return dist[x + dx[i]][y + dy[i]];
                int p = 1;
                while (isValid(x + dx[i] * p, y + dy[i] * p)) p++;
                if (p-- != 2 && !isVisited(x + dx[i] * p, y + dy[i] * p) && visit(x + dx[i] * p, y + dy[i] * p, x, y))
                    return dist[x + dx[i] * p][y + dy[i] * p];
            }
        }
        return -1;
    }
};

constexpr int Maze::dx[], Maze::dy[];
constexpr size_t Maze::directions;

int main() {
    Maze m(cin);
    cout << m.shortestPath() << endl;
}
