// https://www.hackerrank.com/contests/practice-4-sda/challenges/welcome-to-the-jungle

#include <iostream>
#include <list>
#include <iterator>

using namespace std;

auto read_input(int n) {
    list<int> l;

    while (n--) {
        int t;
        cin >> t;
        l.push_back(t);
    }

    return l;
}

template<class R>
int removeSmallerAfter(list<int> &trees, R it) {
    auto pos = it.base();
    int currentHeight = *prev(pos, 1);
    int removed = 0;

    while (pos != trees.end()) {
        if (currentHeight < *pos) {
            break;
        }

        pos = trees.erase(pos);
        ++removed;
    }
    return removed;
}

int solve(list<int> &trees) {
    int best_pos;
    int current_pos = trees.size();

    int max_visible_trees = 0;
    int visible_trees = 0;

    for (auto it = trees.rbegin(); it != trees.rend();) {
        --current_pos;
        ++visible_trees;
        visible_trees -= removeSmallerAfter(trees, it++);

        if (visible_trees >= max_visible_trees) {
            max_visible_trees = visible_trees;
            best_pos = current_pos;
        }
    }

    return best_pos;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    auto trees = read_input(n);

    cout << solve(trees) << endl;
}
