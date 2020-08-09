// github.com/andy489

//https://www.hackerrank.com/contests/practice-2-sda/challenges/monster-world

#include <iostream>
#include <vector>

using namespace std;

int merge(vector<int> &A, vector<int> &L, vector<int> &R) {
    int leftCount(L.size()), rightCount(R.size());
    int i(0), j(0), k(0), inv(0);

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

int mergeSort(vector<int> &A) {
    int n(A.size()), mid, i, inv(0);
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
    int N, blast, i(0);
    cin >> N >> blast;

    vector<int> monsters(N), uniqueMonsters;
    uniqueMonsters.reserve(N);

    for (; i < N; ++i)
        cin >> monsters[i];

    if (N == 0)
        return cout << 0, 0;
    else if (N == 1)
        return cout << 1, 0;
    else {
        int countBlasts(0);

        mergeSort(monsters);

        int curr(-1);
        for (i = 0; i < N; ++i) {
            if (monsters[i] != curr) {
                curr = monsters[i];
                uniqueMonsters.push_back(curr);
            }
        }
        int newN = uniqueMonsters.size();
        for (i = newN - 1; i >= 0; --i) {
            if (uniqueMonsters[i] - countBlasts * blast <= 0)
                return cout << countBlasts, 0;
            else
                ++countBlasts;
        }
    }
    return cout << uniqueMonsters.size(), 0;
}
