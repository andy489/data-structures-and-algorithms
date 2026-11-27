// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

// Solution: Sort Descending Greedy — O(n log n) time, O(n) space
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int n : nums) total += n;
        List<Integer> res = new ArrayList<>();
        int sub = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sub += nums[i];
            res.add(nums[i]);
            if (sub > total - sub) break;
        }
        return res;
    }
}
