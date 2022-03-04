// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Cloning socks

#include <cstdio>

using namespace std;

int main() {
    int t;
    scanf("%d", &t);

    int n, m;
    while (t--) {
        scanf("%d %d", &n, &m);
        printf("%s\n", (m == 0 || m > n + 1 || (m + n) % 2 != 1 || (n > 0 && m == 1) ? "no" : "yes"));
    }
}