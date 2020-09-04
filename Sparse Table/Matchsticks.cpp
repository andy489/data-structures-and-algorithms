// github.com/andy489

// https://www.codechef.com/problems/MSTICK

#include <cstdio>
#include <algorithm>

using namespace std;

const int mxN = 1e5, K = 17;
int Min[mxN + 1][K + 1], Max[mxN + 1][K + 1], Log[mxN + 1];

int getMin(int L, int R) {
    int j = Log[R - L + 1];
    return min(Min[L][j], Min[R - (1 << j) + 1][j]);
}

int getMax(int L, int R) {
    if (L > R)
        return 0;
    int j = Log[R - L + 1];
    return max(Max[L][j], Max[R - (1 << j) + 1][j]);
}

int main() {
    int N, b, i(0), q, L, R;
    scanf("%d", &N);

    for (; i < N; ++i) {
        scanf("%d", &b);
        Min[i][0] = Max[i][0] = b;
    }

    for (i = 2; i <= N; ++i)
        Log[i] = Log[i / 2] + 1;

    for (int j = 1; j <= 17; ++j)
        for (int i = 0; i <= N - (1 << j); ++i) {
            Min[i][j] = min(Min[i][j - 1], Min[i + (1 << (j - 1))][j - 1]);
            Max[i][j] = max(Max[i][j - 1], Max[i + (1 << (j - 1))][j - 1]);
        }

    scanf("%d", &q);

    while (q--) {
        scanf("%d%d", &L, &R);
        int Max0 = getMin(L, R) + getMax(L, R);
        int Max1 = max(getMax(0, L - 1), getMax(R + 1, N - 1)) + getMin(L, R);
        int Ans = max(Max0, Max1 * 2);
        printf("%.1f\n", Ans / 2.0);
    }
    return 0;
}
