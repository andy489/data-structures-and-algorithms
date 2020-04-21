// github.com/andy489\

#include <stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    int a[n], i, j;
    for (i = 0; i < n; ++i) {
        scanf("%d", a + i);
    }
    int c = 0, pg = 1;
    for (i = 0; i < n; ++i) {
        for (j = 1; j <= a[i]; ++j) {
            if (j == pg)
                ++c;
            if (j % k == 0 && j < a[i])
                ++pg;
        }
        ++pg;
    }
    printf("%d", c);
    return 0;
}
