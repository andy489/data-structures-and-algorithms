#include <cstdio>

using namespace std;

const int MAXN = 1000 + 5;

int m, n, A[MAXN];
long long tot;

int main() {
    scanf("%d%d", &m, &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &A[i]);

        tot += A[i];
    }

    if (tot >= m * n) {
        printf("yes\n");
    } else {
        printf("no\n");
    }

    return 0;
}
