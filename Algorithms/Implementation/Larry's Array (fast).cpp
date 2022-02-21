// https://www.hackerrank.com/challenges/larrys-array/problem

#include<iostream>
#include <vector>

using namespace std;

int merge(vector<int> &a, vector<int> &l, vector<int> &r) {
    int lc = l.size();
    int rc = r.size();
    
    int i = 0;
    int j = 0;
    int k = 0;

    int inv = 0;

    while (i < lc && j < rc) {
        if (l[i] < r[j]) {
            a[k++] = l[i++];
        } else {
            a[k++] = r[j++];
            inv += lc - i;
        }
    }

    while (i < lc) {
        a[k++] = l[i++];
    }

    while (j < rc) {
        a[k++] = r[j++];
    }

    return inv;
}

int merge_sort(vector<int> &a) {
    int n = a.size();
    int inv = 0;

    if (n < 2) {
        return 0;
    }

    int mid = n / 2;

    vector<int> l(mid);
    vector<int> r(n - mid);

    for (int i = 0; i < mid; ++i) {
        l[i] = a[i];
    }

    for (int i = mid; i < n; ++i) {
        r[i - mid] = a[i];
    }

    inv += merge_sort(l);
    inv += merge_sort(r);
    inv += merge(a, l, r);

    return inv;
}

vector<int> init() {
    int n;
    cin >> n;

    vector<int> a(n);

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    return a;
}

int main() {
    int q;
    cin >> q;

    while (q--) {
        vector<int> a = init();
        int inv = merge_sort(a);
        cout << (inv % 2 ? "NO" : "YES") << endl;
    }

    return 0;
}
