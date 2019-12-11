#include <cstdio>
#include <algorithm>

using namespace std;

const int MAXN = 1000 + 5;

int n, best, l, r, A[MAXN];

int main() {
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &A[i]);
    }

    r = n - 1;

    while (l < r) {
        best = max(best, min(A[l], A[r]) * (r - l));
        
        if (A[l] < A[r]) {
            l++;
        } else {
            r--;
        }
    }

    printf("%d\n", best);

    return 0;
}
