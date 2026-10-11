// functions that return most left and most right indexes of searched element if exist, or -1 otherwise.
// binary search iterative function O(log(N))

#include <iostream>
#include <vector>

using namespace std;

int bin_search_left_most(const vector<int> &arr, int x) {
    const int SIZE = arr.size();
    int begin = 0;
    int end = SIZE - 1;
    int mid;

    int most_left = -1;

    while (begin <= end) {
        mid = begin + (end - begin) / 2;

        if (arr[mid] == x) {
            most_left = mid;
            end = mid - 1;
        } else if (arr[mid] > x) {
            end = mid - 1;
        } else {
            begin = mid + 1;
        }
    }

    return most_left;
}

int bin_search_right_most(const vector<int> &arr, int x) {
    const int SIZE = arr.size();
    int begin = 0;
    int end = SIZE - 1;
    int mid;

    int most_right = -1;

    while (begin <= end) {
        mid = begin + (end - begin) / 2;

        if (arr[mid] == x) {
            most_right = mid, begin = mid + 1;
        } else if (arr[mid] > x) {
            end = mid - 1;
        } else {
            begin = mid + 1;
        }
    }
    
    return most_right;
}

int main() {
    int searched;
    cin >> searched;

    vector<int> arr_sorted = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 8, 8, 9};

    cout << "Most left position: "
         << bin_search_left_most(arr_sorted, searched) << endl
         << "Most right position: "
         << bin_search_right_most(arr_sorted, searched);

    return 0;
}
