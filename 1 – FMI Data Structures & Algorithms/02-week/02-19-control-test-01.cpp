// https://www.hackerrank.com/contests/sda-2019-2020-test1/challenges/challenge-2212/problem

#include <iostream>
#include <vector>

using namespace std;

typedef vector<int> vi;

#define sz(x) ((int)x.size())
#define fup(i, k, n) for(int i = k; i < n; ++i)
#define fd(i, n) for(int i = n - 1; i >= 0; --i)

void counting_sort(vi &arr) {
    int n = sz(arr);
    int range = 1e5;

    vi cnt(range);

    fup(i, 0, n) ++cnt[arr[i]];
    fup(i, 0, range - 1) cnt[i + 1] += cnt[i];

    vi sorted(n);
    
    fd(i, n) {
        sorted[cnt[arr[i]] - 1] = arr[i];
        --cnt[arr[i]];
    }

    fup(i, 0, n) arr[n - i - 1] = sorted[i];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;
    vi arr(n);

    fup(i, 0, n) cin >> arr[i];
    
    counting_sort(arr);

    for (int e : arr) {
        cout << e << ' ';
    }

    return 0;
}
