// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2274

#include <iostream>
#include <queue>
#include <set>
#include <unordered_map>

using namespace std;

struct Point {
    int x, type;

    Point(int val = 0, int type = 0) : x(val), type(type) {}

    bool operator<(const Point &p) const {
        if (x == p.x) 
            return type > p.type;
        else 
            return x < p.x;
    }
};

int main() {
    int n, q, a, b, cnt(0);
    cin >> n >> q;

    multiset<Point> ms;

    while (n--) {
        cin >> a >> b;
        Point p1({a, 1}), p2({b, -1});
        ms.insert(p1);
        ms.insert(p2);
    }

    queue<int> queries;

    while(q--) {
        cin >> a;
        queries.push(a);
        ms.insert(a);
    }

    unordered_map<int, int> um;

    auto it = ms.begin();

    while (it != ms.end()) {
        cnt += it->type;
        if (!it->type) 
            um[it->x] = cnt;
        ++it;
    }

    while (!queries.empty()) {
        auto it = um.find(queries.front());
        if (it != um.end())
            cout << it->second << ' ';
        queries.pop();
    }

    return 0;
}
