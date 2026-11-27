// https://leetcode.com/problems/make-array-elements-equal-to-zero/

// Solution: Prefix Sum Balance Check — O(n) time, O(1) space
class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        int ans = 0;
        int leftSum = 0;
        for (int x : nums) {
            if (x == 0) {
                int rightSum = total - leftSum;
                if (leftSum == rightSum) {
                    ans += 2;
                } else if (leftSum == 0 || rightSum == 0) {
                    ans += 1;
                }
            } else {
                leftSum += x;
            }
        }
        return ans;
    }
}
