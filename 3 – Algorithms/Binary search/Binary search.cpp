#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int bs_iter_fir(const vector<int> &sorted, int x) {
    int first_find = -1;
    int SIZE = (int) sorted.size();

    int l = 0;
    int r = SIZE - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (x == sorted[mid]) {
            first_find = mid;
            r = mid - 1;
        }
        if (x < sorted[mid]) {
            r = mid - 1;
        } else if (x > sorted[mid]) {
            l = mid + 1;
        }
    }

    return first_find;
}

int bs_iter_last(const vector<int> &sorted, int x) {
    int last_find = -1;
    int SIZE = (int) sorted.size();

    int l = 0;
    int r = SIZE - 1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (x == sorted[mid]) {
            last_find = mid;
            l = mid + 1;
        } else if (x < sorted[mid]) {
            r = mid - 1;
        } else if (x > sorted[mid]) {
            l = mid + 1;
        }
    }

    return last_find;
}

int bs_rec_fir(const vector<int> &sorted, int l, int r, int x) {
    if (l <= r) {
        int mid = l + (r - l) / 2;

        if ((mid == 0 || x > sorted[mid - 1]) && sorted[mid] == x) {
            return mid;
        } else if (x > sorted[mid]) {
            return bs_rec_fir(sorted, mid + 1, r, x);
        } else {
            return bs_rec_fir(sorted, l, mid - 1, x);
        }
    }

    return -1;
}

int bs_rec_last(const vector<int> &sorted, int l, int r, int x) {
    if (l <= r) {
        int mid = l + (r - l) / 2;

        if ((mid == sorted.size() - 1 || x < sorted[mid + 1]) && sorted[mid] == x) {
            return mid;
        } else if (x < sorted[mid]) {
            return bs_rec_last(sorted, l, mid - 1, x);
        } else {
            return bs_rec_last(sorted, mid + 1, r, x);
        }
    }

    return -1;
}

int main() {
    vector<int> arr;

    string line;
    cout << "Enter comma separated integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    sort(arr.begin(), arr.end());

    cout << "Sorted: ";
    const int SIZE = arr.size();
    for (int i = 0; i < SIZE; ++i) {
        cout << arr[i] << " ";
    }

    cout << endl << "Enter searched integer: ";
    int x;
    cin >> x;
    // cout << "First encounter iterative: " << bs_iter_fir(arr, x) << endl;
    // cout << "Last encounter iterative: " << bs_iter_last(arr, x) << endl;
    // cout << "First encounter recursive: " << bs_rec_fir(arr, 0, SIZE - 1, x);
    cout << "Last encounter recursive: " << bs_rec_last(arr, 0, SIZE - 1, x) << endl;

    return 0;
}