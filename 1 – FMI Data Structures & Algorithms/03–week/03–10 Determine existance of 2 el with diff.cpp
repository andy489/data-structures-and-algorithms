// find if there are two elements with difference x in an array with n elements.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool binary(const vector<int> &arr, int x) {
    int n = arr.size();

    int l = 0;
    int r = n - 1;
    int m;

    while (l <= r) {
        m = l + (r - l) / 2;

        if (x == arr[m]) {
            return true;
        } else if (x < arr[m]) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return false;
}

int main() {
    int n;

    scanf("%d", &n);

    vector<int> arr(n);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &arr[i]);
    }

    int x;
    scanf("%d", &x);

    sort(arr.begin(), arr.end());

    for (int i = 0; i < n - 1; ++i) {
        if (binary(arr, x + arr[i]) && x != 0) {
            return cout << "YES", 0;
        } else if (x == 0 && arr[i] == arr[i + 1]) {
            return cout << "YES", 0;
        }
    }

    return cout << "NO", 0;
}
