// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Watter Supplies

#include <cstdio>
#include <algorithm>

using namespace std;

const int MAX = 1e4 + 5;

int main() {
    int n;
    scanf("%d", &n);

    int A[MAX];

    for (int i; i < n; ++i) {
        scanf("%d", &A[i]);
    }

    int l = 0;
    int r = n - 1;
    int best = 0;

    while (l < r) {
        best = max(best, min(A[l], A[r]) * (r - l));
        (A[l] < A[r]) ? ++l : --r;
    }

    printf("%d", best);

    return 0;
}
