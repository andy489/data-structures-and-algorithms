// github.com/andy489

// https://www.hackerrank.com/contests/practice-2-sda/challenges/electrical-energy

#include <iostream>
#include <vector>

using namespace std;

long merge(vector<int> &A, vector<int> &L, vector<int> &R) {
    int leftCount(L.size()), rightCount(R.size()), i(0), j(0), k(0);
    long inv(0);

    while (i < leftCount && j < rightCount) {
        if (L[i] < R[j]) A[k++] = L[i++];
        else {
            A[k++] = R[j++];
            inv += leftCount - i;
        }
    }
    while (i < leftCount) A[k++] = L[i++];
    while (j < rightCount) A[k++] = R[j++];
    return inv;
}

long mergeSort(vector<int> &A) {
    int n(A.size()), mid, i;
    long inv(0);
    if (n < 2)
        return inv;

    mid = n / 2;

    vector<int> L(mid), R(n - mid);

    for (i = 0; i < mid; ++i) L[i] = A[i];
    for (i = mid; i < n; ++i) R[i - mid] = A[i];

    inv += mergeSort(L);
    inv += mergeSort(R);
    inv += merge(A, L, R);

    return inv;
}

int main() {
    int N, i(0);
    cin >> N;
    vector<int> buildings(N);
    for (; i < N; ++i)
        cin >> buildings[i];
    return cout << mergeSort(buildings), 0;
}
