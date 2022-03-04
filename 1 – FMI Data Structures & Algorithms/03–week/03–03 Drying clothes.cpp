// https://www.hackerrank.com/contests/practice-3-1/challenges
// WinterWinter

#include <iostream>

using namespace std;

const int mxN = 1e5;
const int MAX = 1e9 + 5;
const int MIN = 0;

int get_max(const int *arr, int size) {
    int current_max = 0;

    for (int i = 0; i < size; ++i) {
        if (current_max < arr[i]) {
            current_max = arr[i];
        }
    }

    return current_max;
}

bool dries_for_time(const int *clothes, int size, int dryer, int time) {
    int accumulated = 0;

    for (int i = 0; i < size; ++i) {
        if (clothes[i] > time) {
            accumulated += (clothes[i] - time) / (dryer - 1) + ((clothes[i] - time) % (dryer - 1) != 0);

            if (accumulated > time) {
                return false;
            }
        }
    }
    return true;
}

int min_dry(int *clothes, int size, int dryer) {
    if (dryer < 2) {
        return get_max(clothes, size);
    }

    int low = MIN;
    int high = MAX;
    int temp_min = high;

    while (low < high) {
        int mid = (low + high) / 2;

        if (dries_for_time(clothes, size, dryer, mid)) {
            temp_min = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return dries_for_time(clothes, size, dryer, low) ? low : temp_min;
}

int main() {
    int n, k;
    cin >> n >> k;

    int clothes[mxN];

    for (int i = 0; i < n; ++i) {
        cin >> clothes[i];
    }

    cout << min_dry(clothes, n, k);

    return 0;
}
