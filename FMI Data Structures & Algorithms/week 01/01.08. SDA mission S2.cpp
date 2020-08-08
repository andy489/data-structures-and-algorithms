// github.com/andy489

#include <cstdio>

using namespace std;

const int mxN = 1000 + 5;

int m, n, A[mxN],i;
long long tot;

int main() {
    scanf("%d%d", &m, &n);

    for (; i < n; ++i) {
        scanf("%d", &A[i]);
        tot += A[i];
    }

    return tot >= m * n ? printf("yes\n") :
           printf("no\n"), 0;
}
