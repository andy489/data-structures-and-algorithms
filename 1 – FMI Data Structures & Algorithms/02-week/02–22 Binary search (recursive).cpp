#include <iostream>
#include <vector>

using namespace std;

bool bin_search(const vector<int> &arr, int begin, int end, int x) {
    if (begin <= end) {
        int mid = begin + (end - begin) / 2;

        if (arr[mid] == x) {
            return mid;
        }

        if (arr[mid] > x) {
            return bin_search(arr, begin, mid - 1, x);
        } else {
            return bin_search(arr, mid + 1, end, x);
        }
    }

    return false;
}

int main() {
    int searched;
    cin >> searched;

    vector<int> arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 8, 8, 9};
    const int N = arr.size();

    return cout << (bin_search(arr, 0, N - 1, searched) ? "exist" : "not exist"), 0;

}
