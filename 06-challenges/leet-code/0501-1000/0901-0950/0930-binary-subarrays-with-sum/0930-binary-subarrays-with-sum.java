// https://leetcode.com/problems/binary-subarrays-with-sum/

// Solution: Prefix Sum + HashMap — O(n) time, O(n) space
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int prefix = 0, result = 0;
        for (int x : nums) {
            prefix += x;
            if (prefix >= goal) {
                result += count[prefix - goal];
            }
            count[prefix]++;
        }
        return result;
    }
}
