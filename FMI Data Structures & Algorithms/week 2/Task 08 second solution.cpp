#include <cstdio>
#include <utility>
#include <algorithm>

using namespace std;

const int MAXN = 1e6 + 5;

int n, b, l, r, ans;
pair<int, int> A[MAXN];

int main() {
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d%d", &l, &r);
        A[i] = {l, l + r};
    }

    sort(A, A + n, [](pair<int, int> p1, pair<int, int> p2) { return p1.second < p2.second; });

    for (int i = 0; i < n; i++) {
        if (A[i].first >= b) {
            ans++;
            b = A[i].second;
        }
    }

    printf("%d\n", ans);

    return 0; 
}
