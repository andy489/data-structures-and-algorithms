// github.com/andy489

// https://www.hackerrank.com/contests/practice-5-sda/challenges/rotten-from-the-core

#include <iostream>
#include <queue>

using namespace std;

struct Apple {
    int x, y, level;
    bool rotten;

    Apple(bool rotten = 0, int level = -1, int x = 0, int y = 0) :
            rotten(rotten), level(level), x(x), y(y) {};
};

struct Grid {
    vector<int> row{0, 1, 0, -1}, col{-1, 0, 1, 0};
    int r, c, days;
    vector<vector<Apple>> apples;

    Grid(int r, int c, int days) : r(r), c(c), days(days) {
        apples = vector<vector<Apple>>(r);
        for (int i = 0; i < r; ++i)
            apples[i] = vector<Apple>(c);
    }

    void readInput() {
        int i, j;
        for (i = 0; i < r; ++i)
            for (j = 0; j < c; ++j)
                apples[i][j].x = i, apples[i][j].y = j;
    }

    bool valid(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c
               && apples[x][y].rotten == 0;
    }

    void computeRottened(int startX1, int startY1, int startX2, int startY2) {
        queue<Apple *> Q;
        apples[startX1][startY1].rotten = apples[startX2][startY2].rotten = 1;
        apples[startX1][startY1].level = apples[startX2][startY2].level = 0;
        Apple *firstBad(&apples[startX1][startY1]),
                *secondBad(&apples[startX2][startY2]),
                *currApple;
        Q.push(firstBad);
        if (firstBad != secondBad) Q.push(secondBad);
        int X, Y;
        while (!Q.empty()) {
            currApple = Q.front();
            Q.pop();
            int SIZE = row.size();
            for (int i = 0; i < SIZE; ++i) {
                X = currApple->x + row[i], Y = currApple->y + col[i];
                if (valid(X, Y)) {
                    apples[X][Y].level = currApple->level + 1;
                    apples[X][Y].rotten = 1;
                    Q.push(&apples[X][Y]);
                }
            }
        }
    }

    void displayGridLevels() { // utility function for debug
        int i, j;
        for (i = 0; i < r; ++i) {
            for (j = 0; j < c; ++j)
                if (apples[i][j].level <= days)
                    cout << "* ";
                else
                    cout << "O ";
            cout << '\n';
        }
    }

    int countGoodApples() {
        int i, j, countGoodApples(0);
        for (i = 0; i < r; ++i)
            for (j = 0; j < c; ++j)
                if (apples[i][j].level > days)
                    ++countGoodApples;
        return countGoodApples;
    }

    int computeGoodApples() {
        int startX1, startY1, startX2, startY2, goodApples(0);
        pair<int, int> p1, p2;
        queue<pair<int, int>> input;
        while (cin >> startX1 >> startY1)
            input.push({startX1, startY1});
        p1 = input.front();
        startX1 = p1.first, startY1 = p1.second;
        input.pop();
        startX1 = r - startX1;
        startY1 -= 1;
        if (!input.empty()) {
            p2 = input.front();
            startX2 = p2.first;
            startY2 = p2.second;

            startX2 = r - startX2;
            startY2 -= 1;

            computeRottened(startX1, startY1, startX2, startY2);
        } else computeRottened(startX1, startY1, startX1, startY1);
        //displayGridLevels();
        return countGoodApples();
    }
};

int main() {
    int R, C, T;
    cin >> R >> C >> T;
    Grid apples(R, C, T);
    apples.readInput();
    return cout << apples.computeGoodApples(), 0;
}
