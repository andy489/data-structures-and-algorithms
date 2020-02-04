#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>roots, elements;

void init(int n) {
    int i;
    roots.resize(2*n);
    elements.assign(2*n, 1);
    for (i = 0; i < 2*n; ++i) {
        roots[i] = i;
    }
}

int find(int x) {
    return roots[x] = roots[x] == x ? x : find(roots[x]);
}

void join(int x, int y) {
    int root_x = find(x), root_y = find(y);
    if (root_x != root_y) {
        roots[root_x] = root_y;
        elements[root_y] += elements[root_x];
    }
}

int main() {
    int n, i, a, b;
    cin >> n;
    init(n);

    for (i = 0; i < n; ++i) {
        cin >> a >> b;--a;--b;
        join(a, b);
    }

    int _min(2 * n), _max(2);

    for (i = 0; i < 2 * n; ++i) {
        int r = find(i);
        if (elements[r] > 1) {
            _min = min(_min, elements[r]);
            _max = max(_max, elements[r]);
        }
    }
    cout << _min << " " << _max;
    return 0;
}
