// https://judge.openfmi.net/practice/open_contest?contest_id=177
// http://www.math.bas.bg/infos/files/2015-11-29-C3.pdf?fbclid=IwAR2APdsgikkAv8IpAILHPHBrpP6pWDwdu1PXzfSpexzPTs2mVZkdhOxkNBQ

#include <cstdio>
#include <algorithm>

using namespace std;

int N, L, D, X1, A, B, ans(-1);
const int mxN = 1e5;

int drops[mxN], aux[mxN];

bool validate(int m) {
    if (drops[0] > D || L - drops[m - 1] - 1 > D) {
        return false;
    }

    for (int i = 1; i < m; ++i) {
        if (drops[i] ^ drops[i - 1] && drops[i] - drops[i - 1] > D) {
            return false;
        }
    }

    return true;
}

void bin_search_on_ans(int l = 1, int r = N) {
    while (l <= r) {
        int m = l + (r - l) / 2;

        sort(drops, drops + m);

        if (validate(m)) {
            ans = m, r = m - 1;
        } else {
            l = m + 1;
        }

        for (int i = 0; i < m; ++i) {
            drops[i] = aux[i]; // recover!
        }
    }
}

void generate() {
    int i = 0;
    drops[i++] = X1, aux[i - 1] = X1;

    for (; i < N; ++i) {
        drops[i] = (int) (drops[i - 1] * 1LL * A + B) % (L + 1);
        aux[i] = drops[i];
    }
}

void init() {
    scanf("%d%d%d%d%d%d", &N, &L, &D, &X1, &A, &B);
    generate();
}

int main() {
    init();

    bin_search_on_ans();

    printf("%d\n", ans);

    return 0;
}
