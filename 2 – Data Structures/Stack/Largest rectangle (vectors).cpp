// https://www.hackerrank.com/challenges/largest-rectangle/problem

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> h(n + 2);
    vector<int> s(n + 2);

    for (int i = 1; i<= n; ++i) {
        cin >> h[i];
    }

    int max_area = 0;
    int pos = 1;
    for (int i = 0; i < n + 2; ++i) {
        while (h[i] < h[s[pos - 1]]) {
            int y = h[s[pos - 1]];
            pos--;
            max_area = max(max_area, (i - s[pos - 1] - 1) * y);
        }

        s[pos++] = i;
    }

    cout << max_area;

    return 0;
}
