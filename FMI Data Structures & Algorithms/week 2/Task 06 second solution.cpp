#include <cstdio>
#include <algorithm>

using namespace std;

const int MAXN = 200000 + 5;

int n, x, p, A[MAXN];

int main() {
    scanf("%d%d", &n, &x);

    for (int i = 0; i < n; i++) {
        scanf("%d", &A[i]);
    }

    sort(A, A + n);

    for (int i = n - 1; i >= 0; i--) {
        if (A[i] - p * x > 0 && (i == n - 1 || A[i] != A[i + 1])) {
            p++;
        }
    }

    printf("%d\n", p);
    
    return 0;
}
