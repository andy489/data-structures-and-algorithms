#include <iostream>
#include <vector>

using namespace std;

unsigned count_pairs(const vector<int> &a, const vector<int> &b, int sum) {
    unsigned answer(0);

    const int MAX = 1e6, MIN = 0, range = MAX - MIN;
    vector<int> buffer_b(range, 0);

    for (int e : b) {
        ++buffer_b[e];
    }

    for (int e : a) {
        if (sum - e >= 0 && buffer_b[sum - e] > 0) {
            answer += buffer_b[sum - e];
        }
    }

    return answer;
}

int main() {
    int n, m;

    cin >> n;
    vector<int> a(n);

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    cin >> m;
    vector<int> b(m);

    for (int i = 0; i < m; ++i) {
        cin >> b[i];
    }

    int sum;
    cin >> sum;

    cout << count_pairs(a, b, sum);
    return 0;
}
