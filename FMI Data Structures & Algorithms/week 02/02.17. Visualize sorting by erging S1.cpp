// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int> &col, vector<int> &L, vector<int> &R) {
    int lCount(L.size()), rCount(R.size()), i(0), j(0), k(0);

    while (i < lCount && j < rCount) {
        if (L[i] < R[j]) col[k++] = L[i++];
        else col[k++] = R[j++];
    }
    while (i < lCount) col[k++] = L[i++];
    while (j < rCount) col[k++] = R[j++];
    for (const auto &el : col) cout << el << ' ';
}

void mergeSort(vector<int> &col) {
    int n(col.size()), mid, i;
    if (n < 2) {
        cout << col[0] << ' ';
        return;
    }

    mid = (n + 1) / 2;

    vector<int> L(mid);
    vector<int> R(n - mid);

    for (i = 0; i < mid; ++i) L[i] = col[i];
    for (i = mid; i < n; ++i) R[i - mid] = col[i];

    mergeSort(L);
    mergeSort(R);
    merge(col, L, R);
}

int main() {
    int N, i(0);
    cin >> N;
    vector<int> col(N);
    for (; i < N; ++i)
        cin >> col[i];
    mergeSort(col);
    return 0;
}
