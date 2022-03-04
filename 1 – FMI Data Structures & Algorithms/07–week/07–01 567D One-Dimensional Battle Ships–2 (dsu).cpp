#include <cstdio>
#include <algorithm>

using namespace std;

const int MAX = 2e5 + 5;

int cap, p[MAX], r[MAX], l[MAX], x[MAX];
bool f[MAX];

int find_set(int v) {
    return (p[v] == v ? v : (p[v] = find_set(p[v])));
}

void union_set(int v, int u) {
    v = find_set(v);
    u = find_set(u);

    if (r[v] < r[u]) {
        swap(v, u);
    }

    if (r[v] == r[u]) {
        ++r[v];
    }

    p[u] = v;
    l[v] += l[u];
}

int main() {
    int n, k, a, m;
    scanf("%d %d %d %d", &n, &k, &a, &m);

    for (int i = 0; i < m; ++i) {
        scanf("%d", &x[i]);
        x[i]--;
        f[x[i]] = true;
    }

    cap = 0;
    for (int i = 0; i < n; i++) {
        p[i] = i;
        r[i] = 0;
        l[i] = 1;

        if (i && !f[i - 1]) {
            if (f[i]) {
                cap += (l[find_set(i - 1)] + 1) / (a + 1);
            } else {
                union_set(i - 1, i);
            }
        }
    }

    if (!f[n - 1]) {
        cap += (l[find_set(n - 1)] + 1) / (a + 1);
    }

    if (cap >= k) {
        printf("-1");
        return 0;
    }

    int i;
    for (i = m - 1; cap < k; --i) {
        f[x[i]] = false;

        if (x[i] && !f[x[i] - 1]) {
            cap -= (l[find_set(x[i] - 1)] + 1) / (a + 1);
        }

        if (x[i] != n - 1 && !f[x[i] + 1]) {
            cap -= (l[find_set(x[i] + 1)] + 1) / (a + 1);
        }

        if (x[i] && !f[x[i] - 1]) {
            union_set(x[i] - 1, x[i]);
        }

        if (x[i] != n - 1 && !f[x[i] + 1]) {
            union_set(x[i], x[i] + 1);
        }

        cap += (l[find_set(x[i])] + 1) / (a + 1);
    }

    printf("%d", i + 2);

    return 0;
}