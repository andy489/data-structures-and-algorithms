// Iterative implementation of Segment Tree: single element update and range min query

#include <cstdio>
#include <algorithm>
using namespace std;
const int mxN = 1e6;
int n, t[2 * mxN];

void build() {
    for (int i = n - 1; i > 0; --i) t[i] = min(t[i << 1], t[i << 1 ^ 1]);
}
void modify(int p, int val) {
    for (t[p += n] += val; p > 1; p >>= 1) t[p >> 1] = min(t[p], t[p ^ 1]);
}
int query(int l, int r, int res = 1e9) {
    for (l += n, r += n; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
        if (l & 1) res = min(res, t[l]);
        if (!(r & 1)) res = min(res, t[r]);
    } return res;
}
int main() {
    int q, cmd, l, r; scanf("%d%d", &n, &q);
    for (int i = 0; i < n; ++i) scanf("%d", t + n + i);
    build();
    while (q--) {
        scanf("%d", &cmd);
        switch (cmd) {
            case 1: scanf("%d%d", &l, &r), printf("%d\n", query(l, r)); break;
            case 2: scanf("%d%d", &l, &r), modify(l, r); break;
            case 3: printf("...loading\n");
        }
    }
}
