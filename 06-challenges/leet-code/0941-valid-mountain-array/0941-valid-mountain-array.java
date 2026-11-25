// https://leetcode.com/problems/valid-mountain-array/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < n - 1 && arr[l] < arr[l + 1]) {
            l++;
        }
        while (r > 0 && arr[r] < arr[r - 1]) {
            r--;
        }
        return l == r && l != 0 && r != n - 1;
    }
}
