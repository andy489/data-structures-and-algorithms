#include <cstdio>
#include <algorithm>

using namespace std;

const int MXN = 1e5 + 5;
int N, K, hotels[MXN];

void init() {
    scanf("%d%d", &N, &K);
    for (int i = 0; i < N; ++i) {
        scanf("%d", hotels + i);
    }
    sort(hotels, hotels + N);
}

bool valid(int m) {
    int pos = hotels[0], fans = 1;
    for (int i = 1; i < N; ++i) {
        if (hotels[i] - pos >= m) {
            pos = hotels[i];
            ++fans;
            if (fans == K) return true;
        }
    }
    return false;
}

int bsOnAnswer(int ans = -1) {
    int l = hotels[0], r = hotels[N - 1], m;
    while (l <= r) {
        m = l + (r - l) / 2; // l + r overflows
        if (valid(m)) {
            ans = max(ans, m);
            l = m + 1;
        } else
            r = m - 1;
    }
    return ans;
}

int main() {
    return init(), printf("%d", bsOnAnswer()), 0;
}
