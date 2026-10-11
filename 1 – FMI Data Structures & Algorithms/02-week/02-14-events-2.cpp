// https://www.hackerrank.com/contests/practice-2-sda/challenges
// Schedule-SDA

#include <cstdio>
#include <utility>
#include <algorithm>

using namespace std;

const int mxN = 1e6 + 5;

int n, b, l, r, ans;
pair<int, int> A[mxN];

int main() {
    scanf("%d", &n);

    for (int i = 0; i < n; ++i) {
        scanf("%d %d", &l, &r);
        A[i] = {l, l + r};
    }

    auto lambda_sort = [](pair<int, int> p1, pair<int, int> p2) { return p1.second < p2.second; };
    sort(A, A + n, lambda_sort);

    for (int i = 0; i < n; ++i) {
        if (A[i].first >= b) {
            ++ans;
            b = A[i].second;
        }
    }

    return printf("%d", ans), 0;
}
