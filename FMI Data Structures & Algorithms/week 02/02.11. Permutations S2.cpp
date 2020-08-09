// github.com/andy489

// https://www.hackerrank.com/contests/practice-2-sda/challenges

#include <cstdio>
#include <cstring>

using namespace std;

const int mxN = 150 * 1e6 + 5;

int n, m, A[26];
char S1[mxN], S2[mxN];

int main() {
    int d;
    scanf("%d %s %s", &d, &S1, &S2);

    n = strlen(S1), m = strlen(S2);
    int i(0);
    for (; i < n; ++i)
        ++A[S1[i] - 'a'];

    for (i = 0; i < m; ++i)
        --A[S2[i] - 'a'];

    for (i = 0; i < 26; ++i)
        if (A[i])
            return printf("no"), 0;
    return printf("yes"), 0;
}
