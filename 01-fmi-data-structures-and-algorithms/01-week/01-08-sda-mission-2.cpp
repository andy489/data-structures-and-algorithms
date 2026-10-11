// https://www.hackerrank.com/contests/practice-1-sda/challenges
// SDA Mission

#include <cstdio>

using namespace std;

int m, n;
long long total;

int main() {
    scanf("%d %d", &m, &n);

    int a;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a);
        total += a;
    }

    printf(total >= (long long) m * n ? "yes" : "no");

    return 0;
}
