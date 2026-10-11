// https://www.hackerrank.com/contests/practice-2-sda/challenges/monster-world/
// Monster World

#include <cstdio>
#include <algorithm>

using namespace std;

const int MAX = 2e5 + 5;

int A[MAX];

int main() {
    int n;
    int x;
    int p;

    scanf("%d%d", &n, &x);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &A[i]);
    }

    sort(A, A + n);

    for (int i = n - 1; i >= 0; --i) {
        if (A[i] - p * x > 0 && (i == n - 1 || A[i] != A[i + 1])) {
            ++p;
        }
    }

    printf("%d", p);

    return 0;
}