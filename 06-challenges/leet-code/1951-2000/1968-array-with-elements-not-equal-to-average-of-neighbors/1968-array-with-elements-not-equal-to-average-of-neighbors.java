// https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        int lo = 0, hi = (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[lo++];
            } else {
                ans[i] = nums[hi++];
            }
        }
        return ans;
    }
}
