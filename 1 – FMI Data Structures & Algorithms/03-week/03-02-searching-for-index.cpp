// https://www.hackerrank.com/contests/practice-3-1/challenges
// BiBiBi

#include <iostream>

using namespace std;

long search_first(long target, const long *sortedArr, int n) {
    if (n == 0) {
        return -2;
    }

    int pivot = n / 2;
    int last_encounter = -2;
    int start = 0;

    while (start < n) {
        if (sortedArr[pivot] < target) {
            start = pivot;
        } else if (sortedArr[pivot] > target) {
            n = pivot;
        } else {
            last_encounter = pivot;
            n = pivot; // search first
        }
        if (pivot != (n + start) / 2) {
            pivot = (n + start) / 2;
        } else break;
    }

    return last_encounter + 1;
}

long search_last(long target, const long *sorted_arr, int n) {
    if (n == 0) {
        return -2;
    }

    int pivot = n / 2;
    int last_encounter = -2;
    int start = 0;

    while (start < n) {
        if (sorted_arr[pivot] < target) {
            start = pivot;
        } else if (sorted_arr[pivot] > target) {
            n = pivot;
        } else {
            last_encounter = pivot;
            start = pivot; // search last
        }
        if (pivot != (n + start) / 2) {
            pivot = (n + start) / 2;
        } else {
            break;
        }
    }

    return last_encounter + 1;
}

void print_result(long *result, int n) {
    for (int i = 0; i < n; i += 2) {
        cout << result[i] << ' ' << result[i + 1] << endl;
    }
}

int main() {
    int n;
    cin >> n;

    long *sorted_arr = new long[n];

    for (int i = 0; i < n; ++i) {
        cin >> sorted_arr[i];
    }

    // sort(sorted_arr, sorted_arr + n);

    int q;
    cin >> q;

    long *result = new long[2 * q];

    int index = 0;
    long P;

    for (int i = 0; i < q; ++i) {
        cin >> P;
        result[index++] = search_first(P, sorted_arr, n);
        result[index++] = search_last(P, sorted_arr, n);
    }

    print_result(result, 2 * q);
}
