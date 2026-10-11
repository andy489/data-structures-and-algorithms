// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2593

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<string, int> psi;
typedef pair<int, psi> pipsi;
#define f first
#define s second

int N, Q;

vector<pipsi> arr;

void init() {
    scanf("%d%d", &N, &Q);
    arr.resize(N);
    string name;
    int fn, pts;

    for (int i = 0; i < N; ++i) {
        cin >> name >> fn >> pts;

        arr[i].f = pts;
        arr[i].s.f = name;
        arr[i].s.s = fn;
    }

    sort(arr.begin(), arr.end(), [](pipsi a, pipsi b) {
        if (a.f == b.f) {
            return a.s.s < b.s.s;
        }

        return a.f < b.f;
    });
}

pipsi bin_search(int p) {
    int l = 0;
    int r = N - 1;
    int mid;

    while (l <= r) {
        mid = (l + r) >> 1;

        if (p <= arr[mid].f) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return arr[l];
}

void queries() {
    int p;

    while (Q--) {
        cin >> p;
        auto res = bin_search(p);
        cout << res.s.f << ' ' << res.s.s << endl;
    }
}

int main() {
    init();

    queries();

    return 0;
}
