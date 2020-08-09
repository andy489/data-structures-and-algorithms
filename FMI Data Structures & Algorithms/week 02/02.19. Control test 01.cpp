// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())
#define F(i, k, n) for(int i=k;i<n;i++)

void cs(vi &v) {
    int N = sz(v);
    int range = 100000;
    vi count(range, 0);
    F(i, 0, N) count[v[i]]++;
    F(i, 0, range - 1) count[i + 1] += count[i];
    vi sorted(N);
    for (int i = N - 1; i >= 0; i--) {
        sorted[count[v[i]] - 1] = v[i];
        --count[v[i]];
    }
    F(i, 0, N) v[N - i - 1] = sorted[i];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N;
    cin >> N;
    vi col(N);
    F(i, 0, N) cin >> col[i];
    cs(col);
    for (const auto &el : col) 
        cout << el << ' ';
    return 0;
}
