// https://www.hackerrank.com/contests/practice-5-sda/challenges/rotten-from-the-core

#include <iostream>
#include <queue>

using namespace std;

struct Apple {
    int x, y, level;
    bool rotten;

    explicit Apple(bool rotten = 0, int level = -1, int x = 0, int y = 0) :
            rotten(rotten), level(level), x(x), y(y) {};
};

struct Grid {
    const vector<int> row_dim{0, 1, 0, -1};
    const vector<int> col_dim{-1, 0, 1, 0};
    const int DIM = 4;

    int r, c, days;
    vector<vector<Apple>> apples;

    Grid(int r, int c, int days) : r(r), c(c), days(days) {
        apples = vector<vector<Apple>>(r, vector<Apple>(c));
    }

    void read_input() {
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                apples[i][j].x = i;
                apples[i][j].y = j;
            }
        }
    }

    bool valid(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c && apples[x][y].rotten == false;
    }

    void spread_rot_bfs(int start_x1, int start_y1, int start_x2, int start_y2) {
        queue<Apple *> Q;

        apples[start_x1][start_y1].rotten = apples[start_x2][start_y2].rotten = true;
        apples[start_x1][start_y1].level = apples[start_x2][start_y2].level = 0;

        Apple *firstBad(&apples[start_x1][start_y1]), *secondBad(&apples[start_x2][start_y2]), *currApple;

        Q.push(firstBad);

        if (firstBad != secondBad) {
            Q.push(secondBad);
        }

        int x, y;
        while (!Q.empty()) {
            currApple = Q.front();
            Q.pop();

            for (int i = 0; i < DIM; ++i) {
                x = currApple->x + row_dim[i];
                y = currApple->y + col_dim[i];

                if (valid(x, y)) {
                    apples[x][y].level = currApple->level + 1;
                    apples[x][y].rotten = true;

                    Q.push(&apples[x][y]);
                }
            }
        }
    }

    void display_grid_levels() { // utility function for debug
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j)
                if (apples[i][j].level <= days) {
                    cout << "* ";
                } else {
                    cout << "O ";
                }

            cout << endl;
        }
    }

    int cnt_good_apples() {
        int cnt_good_apples = 0;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (apples[i][j].level > days) {
                    ++cnt_good_apples;
                }
            }
        }

        return cnt_good_apples;
    }

    int compute_good_apples() {
        // set rotten apples
        int start_x1;
        int start_y1;

        int start_x2;
        int start_y2;

        pair<int, int> p1, p2;
        queue<pair<int, int>> input;

        while (cin >> start_x1 >> start_y1) {
            input.push({start_x1, start_y1});
        }

        p1 = input.front();

        start_x1 = p1.first;
        start_y1 = p1.second;
        input.pop();

        start_x1 = r - start_x1;
        start_y1 -= 1;

        if (!input.empty()) { // two apples
            p2 = input.front();
            start_x2 = p2.first;
            start_y2 = p2.second;

            start_x2 = r - start_x2;
            start_y2 -= 1;

            spread_rot_bfs(start_x1, start_y1, start_x2, start_y2);
        } else { // one apple
            spread_rot_bfs(start_x1, start_y1, start_x1, start_y1);
        }

        //displayGridLevels();
        return cnt_good_apples();
    }
};

int main() {
    int rows, cols, days;
    cin >> rows >> cols >> days;

    Grid apples(rows, cols, days);

    apples.read_input();

    cout << apples.compute_good_apples();

    return 0;
}
