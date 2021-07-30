// github.com/andy489

// https://codeforces.com/problemset/problem/981/C

#include <cstdio>
 
const int mxN = 1e5 + 1;
 
using namespace std;
 
int deg[mxN], leaves[mxN];
 
int main() {
    int n, i(1), u, v, top(0), root, all(0);
    scanf("%d", &n);
 
    for (; i < n; ++i)
        scanf("%d %d", &u, &v), ++deg[u], ++deg[v];
 
    for (i = 1; i <= n; ++i) {
        if (deg[i] == 1)
            leaves[++top] = i;
        if (deg[i] > 2)
            root = i, ++all;
    }
 
    if (all > 1)
        return printf("No"), 0;
    printf("Yes\n");
    if (all == 0)
        printf("1\n%d %d\n", leaves[1], leaves[2]);
    else {
        printf("%d\n", top);
        for (i = 1; i <= top; ++i)
            printf("%d %d\n", root, leaves[i]);
    }
    return 0;
}
