#include <cstdio>

using namespace std;

int t, n, m;

int main() {
    scanf("%d", &t);

    while (t--) {
        scanf("%d%d", &n, &m);

        if (m == 0 || m > n + 1 || (m + n) % 2 != 1 || (n > 0 && m == 1)) {
            printf("no\n");
        } else {
            printf("yes\n");
        }
    }
}
