// github.com/andy489

#include <iostream>

using namespace std;

/*
This problem was asked by Stripe.

PROBLEM STATEMENT
Given an array of integers, find the first missing
positive integer in linear time and constant space.
In other words, find the lowest positive integer that
does not exist in the array. The array can contain
duplicates and negative numbers as well.
*/

int arr[1000000], i;

/*
Solution
The idea behind the solution is as follows:
Rearrange the array so that every positive number
x is located in the element of the array with index
x-1 and all the numbers in the initial state of the array
are also present after the rearrangement. If we perform
such manipulation in linear time the answer to the problem
will be the 1 + the first index in the array that does not
contains a number not equal to the index + 1.

Time complexity - O(n)
Space complexity - O(1), where n is the length of the array
we input.
*/

int getAnswer(int arrLen, int *arr) {
    for (i = 0; i < arrLen; ++i) {
        if (arr[i] > 0 && arr[i] <= arrLen && arr[i] != i + 1) {
            std::swap(arr[i], arr[arr[i] - 1]);
            /// here the decrementation if i is needed because the value we swap arr[i] with 
            /// may also need to change position. An example of this is the array [3, 4, -1, 1]
            --i;
        }
    }
    int ans = arrLen + 1;
    for (i = 0; i < arrLen; ++i) {
        if (arr[i] != i + 1) {
            ans = i + 1;
            break;
        }
    }
    return ans;
}

int main() {
    int n;
    cin >> n;
    for (; i < n; ++i)
        cin >> arr[i];
    return cout << getAnswer(n, arr), 0;
}
