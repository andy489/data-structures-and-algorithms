// github.com/andy489

// https://www.hackerrank.com/contests/practice-6-sda/challenges/closest-apartments

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Point {
    long long x, y;
public:
    Point(long long x, long long y) : x(x), y(y) {}

    bool operator>(const Point &p) const {
        long long distSqToOrigin1 = x * x + y * y,
                distSqToOrigin2 = p.x * p.x + p.y * p.y;
        if (distSqToOrigin1 != distSqToOrigin2)
            return distSqToOrigin1 > distSqToOrigin2;
        if (x != p.x)
            return x > p.x;
        return y > p.y;
    }

    friend ostream &operator<<(ostream &os, const Point &p) {
        return os << p.x << ' ' << p.y;
    }
};

vector<Point> inp(int n) {
    vector<Point> v;
    v.reserve(n);
    while (n--) {
        long long x, y;
        cin >> x >> y;
        v.emplace_back(x, y);
    }
    return v;
}

void printBestK(vector<Point> &&v, int k) {
    make_heap(v.begin(), v.end(), greater<Point>{});
    int i(0);
    for (; i < k; ++i) {
        cout << v[0] << endl;
        pop_heap(v.begin(), v.end() - i, greater<Point>{});
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, k;
    cin >> n >> k;
    return printBestK(inp(n), k), 0;
}
