// https://www.hackerrank.com/contests/practice-2-sda/challenges
// Monster World

#include <iostream>
#include <vector>

using namespace std;

int merge(vector<int> &A, vector<int> &L, vector<int> &R) {
    int left_cnt = L.size();
    int right_cnt = R.size();

    int i = 0;
    int j = 0;
    int k = 0;
    int inv = 0;

    while (i < left_cnt && j < right_cnt) {
        if (L[i] < R[j]) {
            A[k++] = L[i++];
        } else {
            A[k++] = R[j++];
            inv += left_cnt - i;
        }
    }

    while (i < left_cnt) {
        A[k++] = L[i++];
    }

    while (j < right_cnt) {
        A[k++] = R[j++];
    }

    return inv;
}

int merge_sort(vector<int> &A) {
    int n = A.size();
    int inv = 0;
    int mid;

    if (n < 2) {
        return inv;
    }

    mid = n / 2;
    vector<int> L(mid), R(n - mid);

    for (int i = 0; i < mid; ++i) {
        L[i] = A[i];
    }
    for (int i = mid; i < n; ++i) {
        R[i - mid] = A[i];
    }

    inv += merge_sort(L);
    inv += merge_sort(R);
    inv += merge(A, L, R);

    return inv;
}

int main() {
    int n, blast;
    cin >> n >> blast;

    vector<int> monsters(n);
    vector<int> unique_monsters;

    unique_monsters.reserve(n);

    for (int i = 0; i < n; ++i) {
        cin >> monsters[i];
    }

    if (n == 0) {
        return cout << 0, 0;
    } else if (n == 1) {
        return cout << 1, 0;
    } else {
        int cnt_blasts = 0;

        merge_sort(monsters);

        int curr = -1;
        for (int i = 0; i < n; ++i) {
            if (monsters[i] != curr) {
                curr = monsters[i];
                unique_monsters.push_back(curr);
            }
        }

        int new_n = unique_monsters.size();

        for (int i = new_n - 1; i >= 0; --i) {
            if (unique_monsters[i] - cnt_blasts * blast <= 0) {
                return cout << cnt_blasts, 0;
            } else {
                ++cnt_blasts;
            }
        }
    }
    
    return cout << unique_monsters.size(), 0;
}
