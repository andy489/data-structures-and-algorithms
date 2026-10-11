// https://leetcode.com/problems/first-missing-positive/

#include <iostream>
#include <vector>

using namespace std;

/*
This problem was asked by Stripe.

PROBLEM STATEMENT
Given an array of integers, find the first missing
positive integer in linear time and constant space.
The array can contain duplicates and negative numbers
as well.

SOLUTION
The idea behind the solution is as follows:
Rearrange the array so that every positive number
x is located in the element of the array with index
x - 1 and all the numbers in the initial state of the array
are also present after the rearrangement. If we perform
such manipulation in linear time the answer to the problem
will be the 1 + the first index in the array that does not
contains a number not equal to the index + 1.

Time complexity - O(n)
Space - O(1), where n is the length of the array we input.
*/

int first_missing_positive(vector<int> &nums) {
    int n = nums.size();

    for (int i = 0; i < n; ++i) {
        while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
            swap(nums[i], nums[nums[i] - 1]);
            // the value we swap arr[i] with may also need to change position [3, 4, -1, 1]
        }
    }

    for (int i = 0; i < n; ++i) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }

    return n + 1;
}

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0; i < n; ++i) {
        cin >> nums[i];
    }

    cout << first_missing_positive(nums);

    return 0;
}
