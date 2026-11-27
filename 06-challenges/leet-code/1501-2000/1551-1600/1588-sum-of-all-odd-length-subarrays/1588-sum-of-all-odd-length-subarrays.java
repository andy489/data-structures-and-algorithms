// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

// Solution: Math Contribution — O(n) time, O(1) space
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - i;
            int total = left * right;
            int oddCount = (total + 1) / 2;
            sum += arr[i] * oddCount;
        }
        return sum;
    }
}
