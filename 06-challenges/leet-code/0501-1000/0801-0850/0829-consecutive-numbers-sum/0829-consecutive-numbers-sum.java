// https://leetcode.com/problems/consecutive-numbers-sum/

// Solution: Math — O(√n) time, O(1) space
class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            int rem = n - k * (k - 1) / 2;
            if (rem % k == 0) {
                count++;
            }
        }
        return count;
    }
}
