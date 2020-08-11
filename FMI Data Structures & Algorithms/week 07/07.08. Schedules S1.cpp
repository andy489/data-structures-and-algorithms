// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2274

#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <algorithm>

using namespace std;

struct Point {
    int x, type;

    Point(int x = 0, int type = 0) : x(x), type(type) {}
};

struct cmp {
    bool operator()(const Point &l, const Point &r) const {
        if (l.x == r.x)
            return l.type > r.type;
        else
            return l.x < r.x;
    }
};

int main() {
    int n, q, i(0), l, r, cnt(0);
    cin >> n >> q;

    vector<Point> arr;
    arr.reserve(2 * n + q + 10);

    queue<int> queries;

    for (; i < n; ++i) {
        cin >> l >> r;
        arr.emplace_back(l, 1);
        arr.emplace_back(r, -1);
    }

    for (i = 0; i < q; ++i) {
        cin >> l;
        arr.emplace_back(l);
        queries.push(l);
    }

    sort(arr.begin(), arr.end(), cmp());

    unordered_map<int, int> ans;

    n = arr.size();
    for (i = 0; i < n; ++i) {
        cnt += arr[i].type;
        if (!arr[i].type)
            ans[arr[i].x] = cnt;
    }

    while (!queries.empty()) {
        cout << ans[queries.front()] << ' ';
        queries.pop();
    }

    return 0;
}
