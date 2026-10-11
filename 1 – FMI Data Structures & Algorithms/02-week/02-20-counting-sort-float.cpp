#include <iostream>
#include <vector>

using namespace std;

void counting_sort(vector<int> &arr) {
    int n = arr.size();

    int min = arr[0];
    int max = min;

    for (int i = 0; i < n; ++i) {
        if (min > arr[i]) {
            min = arr[i];
        }

        if (max < arr[i]) {
            max = arr[i];
        }
    }

    int range = max - min + 1;

    vector<int> cnt(range);

    for (int i = 0; i < n; ++i) {
        cnt[arr[i] - min]++;
    }

    for (int i = 0; i < range - 1; ++i) {
        cnt[i + 1] += cnt[i];
    }

    vector<int> sorted(n);

    for (int i = n - 1; i >= 0; i--) {
        sorted[cnt[arr[i] - min] - 1] = arr[i];
        --cnt[arr[i] - min];
    }

    for (int i = 0; i < n; ++i) {
        arr[i] = sorted[i];
    }
}

int main() { // in range [2.00, 4.00] with two digits after the decimal point
    vector<double> arr_dbl = {2.22, 3.12, 2.00, 2.65, 3.14, 3.40, 2.12, 4.00};
    const int n = arr_dbl.size();

    vector<int> arr(n);

    const double OFFSET = 100.0;

    for (int i = 0; i < n; ++i) {
        arr[i] = OFFSET * arr_dbl[i];
    }

    counting_sort(arr);

    for (int i = 0; i < n; ++i) {
        arr_dbl[i] = arr[i] / OFFSET;
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    for (double e : arr_dbl) {
        cout << e << ' ';
    }

    return 0;
}
