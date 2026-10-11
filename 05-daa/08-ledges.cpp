#include <cstdio>
#include <algorithm>

using namespace std;

const int MXN = 5e2 + 5;

int n, w[MXN], ans[MXN][MXN], pref[MXN];

void init(int i = 0) {
    scanf("%d", &n);
    
    for (; i < n; ++i) {
        scanf("%d", &w[i]);
    }
    
    pref[0] = w[0];
    
    for (i = 1; i < n; ++i) pref[i] = pref[i - 1] + w[i];
}

int getMin(int l = 0, int r = n - 1) {
    if (l >= r) {
        return 0;
    }
    if (ans[l][r]) {
        return ans[l][r];
    }

    int curMin = min(getMin(l + 1, r));

    for (int k = l + 1; k < r; ++k){
        curMin = min(curMin, getMin(l, k) + getMin(k + 1, r));
    }

    return ans[l][r] = curMin + pref[r] - (l == 0 ? 0 : pref[l - 1]);
}

int main() {
    init();
    
    getMin();
    
    printf("%d\n", ans[0][n - 1]);
    
    return 0;
}
