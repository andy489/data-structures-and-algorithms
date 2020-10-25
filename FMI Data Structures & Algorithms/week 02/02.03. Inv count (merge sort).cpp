// github.com/andy489

#include <stdio.h>

using namespace std;

typedef long long ll;

ll cnt = 0;

const int mxN = 2e6;

int a[mxN];
int cpy[mxN];

void merge(int s, int m, int e) {
    int l = s, r = m + 1;

    for (int i = s; i <= e; ++i) {
        if (l <= m && (r > e || a[l] <= a[r])) {
            cpy[i] = a[l];
            l++;
        } else {
            cpy[i] = a[r];
            cnt += (r - i);
            r++;
        }
    }
    for (int i = s; i <= e; ++i)
        a[i] = cpy[i];
}

void mergeSort(int s, int e) {
    if (s < e) {
        int m = s + e >> 1;
        mergeSort(s, m);
        mergeSort(m + 1, e);
        merge(s, m, e);
    }
}


int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", a + i);
    mergeSort(0, n-1);
    return printf("%lld\n", cnt), 0;
}
