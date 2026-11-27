// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

// Solution: Linear Scan — O(n * m) time, O(1) space
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i + m < n; i++) {
            if (arr[i] != arr[i + m]) {
                count = 0;
            } else {
                count++;
                if (count == m * (k - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
