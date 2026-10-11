// https://www.hackerrank.com/contests/practice-2-sda/challenges/electrical-energy
// Electrical energy

#include <iostream>
#include <vector>

using namespace std;

long long merge(vector<int> &arr, vector<int> &L, vector<int> &R) {
    int left_cnt = L.size();
    int right_cnt = R.size();

    int i = 0;
    int j = 0;
    int k = 0;

    long long inv = 0;

    while (i < left_cnt && j < right_cnt) {
        if (L[i] < R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
            inv += left_cnt - i;
        }
    }
    
    while (i < left_cnt) arr[k++] = L[i++];
    while (j < right_cnt) arr[k++] = R[j++];

    return inv;
}

long long merge_sort(vector<int> &arr) {
    int n = arr.size();
    int mid;

    long long inv = 0;

    if (n < 2) {
        return inv;
    }

    mid = n / 2;

    vector<int> L(mid), R(n - mid);

    for (int i = 0; i < mid; ++i) {
        L[i] = arr[i];
    }

    for (int i = mid; i < n; ++i) {
        R[i - mid] = arr[i];
    }

    inv += merge_sort(L);
    inv += merge_sort(R);

    inv += merge(arr, L, R);

    return inv;
}

int main() {
    int n;
    cin >> n;

    vector<int> buildings(n);

    for (int i = 0; i < n; ++i) {
        cin >> buildings[i];
    }

    cout << merge_sort(buildings);

    return 0;
}
