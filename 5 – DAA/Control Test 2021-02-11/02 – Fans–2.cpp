// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2871

#include <cstdio>
#include <algorithm>

using namespace std;

const int mxN = 1e5+5;

int n, k;
int hotels[mxN];

void init() {
    scanf("%d %d", &n, &k);

    for (int i = 0; i < n; i++) {
        scanf("%d", &hotels[i]);
    }

    sort(hotels, hotels + n);
}

bool check(int dist) {
    int last_ind = 0;
    int fitted = 1;

    for (int i = 1; i < n; i++) {
        if (hotels[i] - hotels[last_ind] >= dist) {
            last_ind = i;
            ++fitted;
        }
    }

    return fitted >= k;
}

void solve() {
    int left = 1;
    int right = 2 * int(1e9);
    int mid;
    int ans = -1;

    while (left <= right) {
        mid = left + (right - left) / 2;

        if (check(mid)) {
            left = mid + 1;
            ans = mid;
        } else {
            right = mid - 1;
        }
    }

    printf("%d\n", ans);
}

int main() {
    init();

    solve();
}
