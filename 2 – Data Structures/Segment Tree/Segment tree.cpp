#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

void update_val_util(vector<int> &seg_tree, int s, int e, int index, int diff, int i) {
    if (index < s || index > e) {
        return;
    }

    seg_tree[i] += diff;

    if (s != e) {
        int mid = s + (e - s) / 2;

        update_val_util(seg_tree, s, mid, index, diff, 2 * i + 1);
        update_val_util(seg_tree, mid + 1, e, index, diff, 2 * i + 2);
    }
}

void update_val(vector<int> &arr, vector<int> &st, int n, int index, int new_val) {
    if (index < 0 || index > n - 1) {
        cout << "Invalid Input ";
        return;
    }

    int diff = new_val - arr[index];
    arr[index] = new_val;

    update_val_util(st, 0, n - 1, index, diff, 0);
}

int get_sum_util(vector<int> &seg_tree, int s, int e, int qs, int qe, int i) {
    if (qs <= s && qe >= e) {
        return seg_tree[i];
    }

    if (qs > e || qe < s) {
        return 0;
    }

    int mid = s + (e - s) / 2;

    return get_sum_util(seg_tree, s, mid, qs, qe, 2 * i + 1) +
           get_sum_util(seg_tree, mid + 1, e, qs, qe, 2 * i + 2);
}

int get_sum(vector<int> &st, int n, int qs, int qe) {
    if (qs < 0 || qe > n - 1 || qs > qe) {
        cout << "Invalid Input ";
        return -1;
    }

    return get_sum_util(st, 0, n - 1, qs, qe, 0);
}

int build_seg_tree_util(vector<int> &arr, int s, int e, vector<int> &seg_tree, int i) {
    if (s == e) {
        seg_tree[i] = arr[s];
        return arr[s];
    }

    int mid = s + (e - s) / 2;

    seg_tree[i] = build_seg_tree_util(arr, s, mid, seg_tree, 2 * i + 1) +
                  build_seg_tree_util(arr, mid + 1, e, seg_tree, 2 * i + 2);

    return seg_tree[i];
}

vector<int> build_seg_tree(vector<int> &arr) {
    int n = (int) arr.size();

    int x = (int) ceil(log2(n));

    int max_size = 2 * (int) pow(2, x) - 1;

    vector<int> st(max_size);
    build_seg_tree_util(arr, 0, n - 1, st, 0);

    return st;
}

int main() {
    vector<int> arr{3, 2, 9, 5, 4, 10};
    vector<int> st = build_seg_tree(arr);
    int n = (int) arr.size();

    cout << get_sum(st, n, 1, 4) << endl;

    update_val(arr, st, n, 2, 1);

    cout << get_sum(st, n, 1, 4) << endl;

    return 0;
}
