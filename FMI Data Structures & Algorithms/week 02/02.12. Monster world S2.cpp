// github.com/andy489

// https://www.hackerrank.com/contests/practice-2-sda/challenges/monster-world/

#include <cstdio>
#include <algorithm>

using namespace std;

const int mxN = 200000 + 5;

int n, x, p, A[mxN],i;

int main() {
    scanf("%d%d", &n, &x);

    for (; i < n; ++i)
        scanf("%d", &A[i]);

    sort(A, A + n);

    for (i = n - 1; i >= 0; --i)
        if (A[i] - p * x > 0 && (i == n - 1 || A[i] != A[i + 1]))
            ++p;

    return printf("%d", p), 0;
}
