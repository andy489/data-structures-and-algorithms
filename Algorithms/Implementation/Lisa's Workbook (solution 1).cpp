// github.com/andy489

#include <stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    int p = 1, c = 0, i, j;
    for(i=0;i<n;++i){
        int t;
        scanf("%d", &t);
        for (j = 0; j < t; ++j) {
            int q = p + j / k;
            if (q == j + 1) {
                ++c;
            }
        }
        p += (t + k - 1) / k;
    }
    printf("%d", c);
    return 0;
}
