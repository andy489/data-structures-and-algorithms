#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int> &arr, vector<int> &L, vector<int> &R) {
    int l_cnt = L.size();
    int r_cnt = R.size();

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < l_cnt && j < r_cnt) {
        if (L[i] < R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];
    }

    while (i < l_cnt) arr[k++] = L[i++];
    while (j < r_cnt) arr[k++] = R[j++];

    for (int e : arr) {
        cout << e << ' ';
    }
}

void merge_sort(vector<int> &arr) {
    int n = arr.size();
    int mid;

    if (n < 2) {
        cout << arr[0] << ' ';
        return;
    }

    mid = (n + 1) / 2;

    vector<int> L(mid);
    vector<int> R(n - mid);

    for (int i = 0; i < mid; ++i) L[i] = arr[i];
    for (int i = mid; i < n; ++i) R[i - mid] = arr[i];

    merge_sort(L);
    merge_sort(R);
    merge(arr, L, R);
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    merge_sort(arr);

    return 0;
}
