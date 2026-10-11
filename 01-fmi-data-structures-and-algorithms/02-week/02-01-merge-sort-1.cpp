#include <iostream>
#include <vector>

using namespace std;

typedef vector<int> vi;

void merge(vi &arr, vi &L, vi &R) {
    int left_sz = L.size();
    int right_sz = R.size();

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left_sz && j < right_sz) {
        if (L[i] < R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }

    while (i < left_sz) {
        arr[k++] = L[i++];
    }

    while (j < right_sz) {
        arr[k++] = R[j++];
    }
}

void merge_sort(vi &arr) {
    int n = arr.size();
    int mid;

    if (n < 2) {
        return;
    }

    mid = (n + 1) / 2; // mid = n/2;

    vi L(mid);
    vi R(n - mid);

    for (int i = 0; i < mid; ++i) {
        L[i] = arr[i];
    }

    for (int j = mid; j < n; ++j) {
        R[j - mid] = arr[j];
    }

    merge_sort(L);
    merge_sort(R);

    merge(arr, L, R);
}

int main() {
    cout << "Enter number of integers: ";

    int n;
    cin >> n;

    vi arr(n);

    cout << "Enter integers: ";

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    merge_sort(arr);

    for (int num : arr) {
        cout << num << ' ';
    }

    return 0;
}
