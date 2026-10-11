// https://codeforces.com/contest/567/problem/D

#include<cstdio>
#include <set>
#include <map>

using namespace std;

int main() {
    int n, k, a;
    scanf("%d %d %d", &n, &k, &a);

    int ans = (n + 1) / (a + 1);

    int m;
    scanf("%d", &m);

    set<int> s;
    map<int, int> vis;

    s.insert(0);
    s.insert(n + 1);

    for (int i = 0; i < m; ++i) {
        int x;
        scanf("%d", &x);

        if (vis[x]) {
            continue;
        }

        vis[x] = 1;

        int c = *s.lower_bound(x);
        int d = *--s.lower_bound(x);

        s.insert(x);

        ans -= (c - d) / (a + 1);
        ans += (c - x) / (a + 1) + (x - d) / (a + 1);

        if (ans < k) {
            printf("%d", i + 1);
            return 0;
        }
    }

    printf("-1");
}