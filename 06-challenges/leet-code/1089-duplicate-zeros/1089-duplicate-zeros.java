// https://leetcode.com/problems/duplicate-zeros/

// Solution: Two-Pass In-Place — O(n) time, O(1) space
class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0, n = arr.length;
        for (int x : arr) {
            if (x == 0) zeros++;
        }
        for (int i = n - 1, j = n + zeros - 1; i >= 0; i--, j--) {
            if (arr[i] == 0) {
                if (j < n) arr[j] = 0;
                j--;
                if (j < n) arr[j] = 0;
            } else {
                if (j < n) arr[j] = arr[i];
            }
        }
    }
}
