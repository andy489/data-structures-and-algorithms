// https://www.hackerrank.com/contests/practice-4-sda/challenges/welcome-to-the-jungle

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct Tree {
    int h;
    int pos;

    explicit Tree(int h = 0, int pos = 0) : h(h), pos(pos) {};

    bool operator<=(const Tree &other) const {
        return this->h <= other.h;
    }

    bool operator>(const Tree &other) const {
        return this->h > other.h;
    }

    bool operator<(const Tree &other) const {
        return this->h < other.h;
    }
};


int main() {
    int n; // h = height of a tree
    cin >> n;

    if (n == 0 || n == 1) {
        cout << 0;
        return 0;
    }

    vector<Tree> forest;
    forest.reserve(n);

    int h;
    for (int i = 0; i < n; ++i) {
        cin >> h;
        forest.emplace_back(h, i);
    }

    stack<Tree> S;

    int fullestStack(1);
    int best_view = forest[n - 1].pos - 1;

    for (int i = n - 1; i >= 0; --i) {
        if (S.empty() || forest[i] < S.top()) {
            S.push(forest[i]);

            if (S.size() >= fullestStack) {
                fullestStack = S.size();
                best_view = S.top().pos;
            }
        } else {
            while (!S.empty() && S.top() <= forest[i]) {
                S.pop();
            }

            S.push(forest[i]);

            if (S.size() >= fullestStack) {
                fullestStack = S.size();
                best_view = S.top().pos;
            }
        }
    }

    cout << best_view;

    return 0;
}
