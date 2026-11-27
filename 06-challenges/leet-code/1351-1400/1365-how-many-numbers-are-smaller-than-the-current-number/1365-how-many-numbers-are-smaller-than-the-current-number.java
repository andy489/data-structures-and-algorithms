// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

// Solution: Counting Sort — O(n + max) time, O(max) space
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[102];
        for (int v : nums) cnt[v+1]++;
        for (int i = 1; i < cnt.length; i++) cnt[i] += cnt[i-1];
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) ans[i] = cnt[nums[i]];
        return ans;
    }
}
