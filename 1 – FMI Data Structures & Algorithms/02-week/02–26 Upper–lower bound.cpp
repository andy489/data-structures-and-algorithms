// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int upper_bound(const vector<int> &vec, int l, int r, int target) {
    while (l < r) {
        int mid = (l + r) / 2;

        if (target > vec[mid])
            l = mid + 1;
        else
            r = mid;
    }
    if (vec[l] >= target) {
        return l;
    } else {
        return -1;
    }
}

int lower_bound(const vector<int> &vec, int l, int r, int target) {
    while (l < r) {
        int mid = (l + r + 1) / 2;

        if (target >= vec[mid]) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    if (vec[l] <= target) {
        return l;
    } else {
        return -1;
    }
}

int main() {
    vector<int> arr = {2, 14, 5, 3, 18, 7, 99, 15, 16, 8, -10, 67, 55, 45, -5, 67, 8, 34, 4, 23, 29};

    bool less_ascending = [](int x, int y) { return x < y; };
    sort(arr.begin(), arr.end(), less_ascending);

    for (int e : arr) {
        cout << e << ' ';
    }

    cout << endl;

    int k;
    cout << "Enter integer to search:" << endl;
    cin >> k;

    const int SIZE = arr.size();

    int upper = upper_bound(arr, 0, SIZE - 1, k);
    int lower = lower_bound(arr, 0, SIZE - 1, k);

    cout << "Smallest integer bigger than or equal to searched:" << endl;
    if (upper == -1) {
        cout << "no such element";
    } else {
        cout << arr[upper];
    }

    cout << endl
         << "Biggest integer smaller than or equal to searched:"
         << endl;

    if (lower == -1) {
        cout << "no such element";
    } else {
        cout << arr[lower];
    }

    cout << endl;

    return 0;
}
