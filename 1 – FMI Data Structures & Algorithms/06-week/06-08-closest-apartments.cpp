// https://www.hackerrank.com/contests/practice-6-sda/challenges/closest-apartments

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Point {
    long long x, y;
public:
    Point(int x, int y) : x(x), y(y) {}

    bool operator>(const Point &p) const {
        long long dist_sq_to_origin1 = x * x + y * y;
        long long dist_sq_to_origin2 = p.x * p.x + p.y * p.y;

        if (dist_sq_to_origin1 != dist_sq_to_origin2) {
            return dist_sq_to_origin1 > dist_sq_to_origin2;
        }

        if (x != p.x) {
            return x > p.x;
        }

        return y > p.y;
    }

    friend ostream &operator<<(ostream &os, const Point &p) {
        return os << p.x << ' ' << p.y;
    }
};

vector<Point> input(int n) {
    vector<Point> arr;
    arr.reserve(n);

    while (n--) {
        int x, y;
        cin >> x >> y;

        arr.emplace_back(x, y);
    }

    return arr;
}

void print_best_k(vector<Point> &&v, int k) {
    make_heap(v.begin(), v.end(), greater<Point>{});

    for (int i = 0; i < k; ++i) {
        cout << v[0] << endl;
        pop_heap(v.begin(), v.end() - i, greater<Point>{});
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    print_best_k(input(n), k);

    return 0;
}
