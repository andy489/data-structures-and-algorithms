// https://www.hackerrank.com/challenges/pairs/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int bin_search(vector<int> &arr, int x) {
    int SIZE = arr.size();
    int ans = 1;
    int start = 0;
    int end = SIZE - 1;
    int mid;
    int fir_enc = -1;

    while (start <= end) {
        mid = start + (end - start) / 2;

        if (arr[mid] == x) {
            fir_enc = mid, end = mid - 1;
        } else if (arr[mid] > x) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    if (fir_enc == -1) {
        return 0;
    } else {
        while (fir_enc + 1 < SIZE && arr[fir_enc] == arr[fir_enc + 1]) {
            ++ans;
            ++fir_enc;
        }

        return ans;
    }
}

int main() {
    int n, x;
    cin >> n >> x;

    vector<int> arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end(), less<int>());

    int res = 0;
    int curr;
    int prev_res;

    if (n == 0) {
        cout << res;
    } else {
        res += bin_search(arr, arr[0] + x);
        prev_res = bin_search(arr, arr[0] + x);

        for (int i = 1; i < n; ++i) {
            curr = arr[i];
            if (curr != arr[i - 1]) {
                prev_res = bin_search(arr, arr[i] + x);
            }

            res += prev_res;
        }
    }

    cout << res;
    return 0;
}
