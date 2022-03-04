// https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

#include <iostream>
#include <algorithm>

using namespace std;

const int MAX = 1e5 + 5;

bool covered[MAX];
int n, k, arr[MAX];

bool check(int towersCnt) {
    for (int i = 0; i < n; ++i) {
        covered[i] = false;
    }

    for (int i = 0; i < n; ++i) {
        if (!covered[i]) {
            int j = i;
            --towersCnt;

            while (arr[j] <= arr[i] + k && j < n) {
                covered[j++] = true;
            }

            --j;
            int l = j + 1;

            while (arr[l] <= arr[j] + k && l < n) {
                covered[l++] = true;
            }
        }
    }

    return towersCnt >= 0;
}

int get_smallest_number_of_towers_needed() {
    int l = 0;
    int r = 100000;
    int res;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (check(mid)) {
            res = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return res;
}

int main() {
    cin >> n >> k;

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    cout << get_smallest_number_of_towers_needed();

    return 0;
}
