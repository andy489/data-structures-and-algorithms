// https://www.hackerrank.com/contests/practice-8-sda/challenges/maze-9

#include <iostream>
#include <vector>
#include <stdexcept>
#include <queue>
#include <tuple>

using namespace std;

class Maze {
    int n{}, m{};
    vector<string> table;

    static constexpr int dx[] = {0, 1, 0, -1};
    static constexpr int dy[] = {-1, 0, 1, 0};

    static constexpr int DIR = sizeof dx / sizeof *dx;

    [[nodiscard]] pair<int, int> find_start() const {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (table[i][j] == 'S') {
                    return {i, j};
                }
            }
        }

        throw runtime_error("no start");
    }

public:
    explicit Maze(istream &is) {
        is >> n >> m;
        for (int i = 0; i < n; ++i) {
            string row;
            is >> row;
            table.push_back(move(row));
        }
    }

    [[nodiscard]] bool is_valid(int i, int j) const {
        return i < n && j < m && table[i][j] != '#';
    }

    [[nodiscard]] bool is_visited(int i, int j) const {
        return table[i][j] == '%';
    }

    int shortest_path() {
        vector<vector<int>> dist(n, vector<int>(m));
        queue<pair<int, int>> q;

        auto visit = [&](int i, int j, int i_from, int j_from) {
            q.emplace(i, j);
            dist[i][j] = dist[i_from][j_from] + 1;

            if (table[i][j] == 'F') {
                return true;
            }

            table[i][j] = '%';
            return false;
        };

        auto p = find_start();
        q.push(p);
        table[p.first][p.second] = '%';

        while (!q.empty()) {
            int x, y;
            tie(x, y) = q.front();
            q.pop();

            for (int i = 0; i < DIR; ++i) {
                if (is_valid(x + dx[i], y + dy[i]) && !is_visited(x + dx[i], y + dy[i])) {
                    if (visit(x + dx[i], y + dy[i], x, y)) {
                        return dist[x + dx[i]][y + dy[i]];
                    }
                }

                int p = 1;

                while (is_valid(x + dx[i] * p, y + dy[i] * p)) {
                    ++p;
                }

                if (p-- != 2 &&
                    !is_visited(x + dx[i] * p, y + dy[i] * p) &&
                    visit(x + dx[i] * p, y + dy[i] * p, x, y)) {

                    return dist[x + dx[i] * p][y + dy[i] * p];
                }
            }
        }
        return -1;
    }
};

constexpr int Maze::dx[], Maze::dy[];
constexpr int Maze::DIR;

int main() {
    Maze m(cin);
    cout << m.shortest_path() << endl;
}
