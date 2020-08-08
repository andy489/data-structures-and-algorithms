// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

int merge(vector<int> &col, vector<int> &L, vector<int> &R) {
    int leftCount((int) L.size()), rightCount((int) R.size()), i(0), j(0), k(0), inv(0);

    while (i < leftCount && j < rightCount) {
        if (L[i] < R[j]) col[k++] = L[i++];
        else {
            col[k++] = R[j++];
            inv += leftCount - i;
        }
    }
    while (i < leftCount) col[k++] = L[i++];
    while (j < rightCount) col[k++] = R[j++];
    return inv;
}

long long mergeSort(vector<int> &col) {
    int n((int) col.size()), mid, i;
    long long inv(0);
    if (n < 2) return inv;

    mid = n / 2;

    vector<int> L(mid), R(n - mid);

    for (i = 0; i < mid; ++i) L[i] = col[i];
    for (i = mid; i < n; ++i) R[i - mid] = col[i];

    inv += mergeSort(L);
    inv += mergeSort(R);
    inv += merge(col, L, R);
    return inv;
}

int main() {
    vector<int> col = {4, -2, 8, 9, 3, 4, -1, 0, 5, 1};
    long long inv = mergeSort(col);
    cout << "Count of inversions: " << inv << '\n';
    for (const auto &el : col)cout << el << ' ';
    return 0;
}
