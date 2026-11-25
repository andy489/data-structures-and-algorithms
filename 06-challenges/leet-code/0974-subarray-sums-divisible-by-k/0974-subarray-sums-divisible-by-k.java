// https://leetcode.com/problems/subarray-sums-divisible-by-k/

// Solution: Prefix Sum + Remainder Count — O(n) time, O(k) space
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefix = 0, ans = 0;
        for (int x : nums) {
            prefix = ((prefix + x) % k + k) % k;
            ans += count[prefix];
            count[prefix]++;
        }
        return ans;
    }
}
