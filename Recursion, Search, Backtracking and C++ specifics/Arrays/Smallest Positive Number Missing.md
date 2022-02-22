## Find the smallest positive number missing from an unsorted array

You are given an *unsorted array* with both *positive* and *negative* elements. You have to find the smallest positive number missing from the array in **O(n)** time using *constant extra space*. You can modify the original array.

Example input|Expected output
-|-
2, 3, 7, 6, 8, -1, -10, 15|1
2, 3, -7, 6, 8, 1, -10, 15|4
1, 1, 0, -1, -2|2 

#### Solution

```cpp
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

int find_missing(vector<int> &arr) {
    const int n = arr.size();

    for (int i = 0; i < n; i++) {
        int curr = arr[i];
        // cannot mark in array range
        if (curr <= 0 || curr > n) {
            continue;
        }

        /* traverse the array until we reach at an element which
         is already marked or which could not be marked. */
        while (arr[curr - 1] != curr) {
            int next = arr[curr - 1];
            arr[curr - 1] = curr;
            curr = next;
            if (curr <= 0 || curr > n) {
                break;
            }
        }
    }

    /* find first array index which is not marked which is also the
     smallest positive missing number. */
    for (int i = 0; i < n; i++) {
        if (arr[i] != i + 1) {
            return i + 1;
        }
    }

    /* if all indices are marked, then smallest missing positive number is array size + 1. */
    return n + 1;
}

int main() {
    string line;
    getline(cin, line);
    istringstream iss(line);

    vector<int> arr;

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    cout << find_missing(arr);
    return 0;
}

```
