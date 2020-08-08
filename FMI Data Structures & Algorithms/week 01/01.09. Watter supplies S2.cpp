// github.com/andy489

#include <cstdio>
#include <algorithm>

using namespace std;

const int MAXN = 1000 + 5;

int n, best, l, r, A[MAXN], i;

int main() {
    scanf("%d", &n);

    for (; i < n; ++i)
        scanf("%d", &A[i]);

    r = n - 1;

    while (l < r) {
        best = max(best, min(A[l], A[r]) * (r - l));
        (A[l] < A[r]) ? ++l : --r;
    }

    return printf("%d\n", best), 0;
}
