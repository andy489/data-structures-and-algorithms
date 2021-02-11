#include<cstdio>
#include<algorithm>

using namespace std;

typedef long long ll;
typedef pair<ll, int> pli;
#define f first
#define s second

const int MXN1 = 1e6 + 5, MXN2 = 5e3 + 5;

int a[MXN1], res[MXN2];
pli queries[MXN2];
ll sums[MXN1];
int N, K, Q;

void init() {
    scanf("%d%d%d", &N, &K, &Q);
    for (int i = 0; i < N; ++i)
        scanf("%d", a + i);
}

void precompute() {
    for (int i = 0; i < Q; ++i) {
        scanf("%lld", &queries[i].f);
        queries[i].s = i;
        res[i] = -1;
    }
    for (int i = 0; i < K; ++i)
        sums[0] += a[i];
    for (int i = 1; i < N - K + 1; ++i)
        sums[i] = sums[i - 1] + a[K + i - 1] - a[i - 1];
}

void getAns(int i = 0, int j = 0) {
    while (i < Q && j < N - K + 1)
        if (sums[j] >= queries[i].f)
            res[queries[i++].s] = j;
        else ++j;
}

int main() {
    init(), precompute();
    sort(queries, queries + Q);
    getAns();

    for (int i = 0; i < Q; ++i)
        printf("%d\n", res[i]);

    return 0;
}
