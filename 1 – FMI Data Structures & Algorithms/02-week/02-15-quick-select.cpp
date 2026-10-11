#include <iostream>
#include <vector>
#include <climits>

using namespace std;

/*
partition function from quick_sort(), which takes the last element as pivot 
and moves all smaller element to left of it and greater elements to right
*/

int partition(vector<int> &arr, int left, int right) {
    int X = arr[right];
    int i = left;

    for (int j = left; j <= right - 1; ++j) {
        if (arr[j] <= X) {
            swap(arr[i++], arr[j]);
        }
    }

    swap(arr[i], arr[right]);
    return i;
}


// function that returns the k-th smallest element in an unsorted array
int k_th_smallest(vector<int> &arr, int left, int right, int K) {
    if (K > 0 && K <= right - left + 1) { // Bounds of seq
        // partition the array around last element and get
        // position of pivot element in sorted sequence
        int pos = partition(arr, left, right);

        if (pos - left == K - 1) { // SUCCESS! (position == K)
            return arr[pos];
        } else if (pos - left > K - 1) { // position is further
            return k_th_smallest(arr, left, pos - 1, K);
        } else {
            return k_th_smallest(arr, pos + 1, right, K - pos + left - 1);
        }
    } else { // if k is more than number of elements in array
        return INT_MAX;
    }
}

int main() {
    vector<int> arr = {0, 1, 1, 13, 8, 21, 3, 34, 5, 55, 2};
    int n = arr.size();
    int k = 0;

    cin >> k; // k is in scope

    cout << "k-th smallest element is " << k_th_smallest(arr, 0, n - 1, k);
    return 0;
}
