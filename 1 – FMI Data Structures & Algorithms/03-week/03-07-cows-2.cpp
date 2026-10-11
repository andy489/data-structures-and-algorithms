// https://www.hackerrank.com/contests/practice-3-sda/challenges/cows-sda

#include <cstdio>
#include <algorithm>

using namespace std;
const int MAX = 1e5 + 5;
int A[MAX];

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &A[i]);
    }

    sort(A, A + n);

    int l = 1;
    int r = A[n - 1] - A[0];
    int m;

    while (l != r) {
        m = l + (r - l) / 2 + 1;
        int s = A[0];
        int p = 1;

        for (int i = 1; i < n; ++i) {
            if (A[i] - s >= m) {
                ++p, s = A[i];
            }
        }
        if (p >= k) {
            l = m;
        } else {
            r = m - 1;
        }
    }

    printf("%d", l);

    return 0;
}
