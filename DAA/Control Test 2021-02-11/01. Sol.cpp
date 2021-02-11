#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<string, int> psi;
typedef pair<int, psi> pisi;
#define f first
#define s second

int N, Q;

vector<pisi> arr;

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
    sort(arr.begin(), arr.end(), [](pisi a, pisi b) {
        if (a.f == b.f) return a.s.s < b.s.s;
        return a.f < b.f;
    });
}

pisi bs(int p) {
    int l = 0, r = N-1, m;
    while (l <= r) {
        m = (l + r) >> 1;
        if (p <= arr[m].f) r = m-1;
        else l = m + 1;
    }
    return arr[l];
}

void queries() {
    int p;
    while (Q--) {
        cin >> p;
        auto res = bs(p);
        cout << res.s.f << ' ' << res.s.s << '\n';
    }
}

int main() {
    return init(), queries(), 0;
}
