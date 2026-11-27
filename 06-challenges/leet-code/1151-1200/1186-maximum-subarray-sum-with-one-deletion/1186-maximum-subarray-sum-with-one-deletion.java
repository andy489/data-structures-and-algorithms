// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

// Solution: DP with Two States — O(n) time, O(1) space
class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = 0;
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            oneDelete = Math.max(noDelete, oneDelete + arr[i]);
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }
        return ans;
    }
}
