// https://leetcode.com/problems/ways-to-make-a-fair-array/

// Solution: Prefix Sums — O(n) time, O(1) space
class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int totalEven = 0, totalOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEven += nums[i];
            } else {
                totalOdd += nums[i];
            }
        }
        int prefixEven = 0, prefixOdd = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int remainEven = totalEven - prefixEven - (i % 2 == 0 ? nums[i] : 0);
            int remainOdd  = totalOdd  - prefixOdd  - (i % 2 == 1 ? nums[i] : 0);
            // After removing i, elements after i flip parity
            int newEven = prefixEven + remainOdd;
            int newOdd  = prefixOdd  + remainEven;
            if (newEven == newOdd) {
                count++;
            }
            if (i % 2 == 0) {
                prefixEven += nums[i];
            } else {
                prefixOdd += nums[i];
            }
        }
        return count;
    }
}
