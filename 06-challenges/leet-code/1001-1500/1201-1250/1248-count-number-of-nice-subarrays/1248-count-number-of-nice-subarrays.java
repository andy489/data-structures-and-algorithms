// https://leetcode.com/problems/count-number-of-nice-subarrays/

// Solution: Prefix Sum — O(n) time, O(n) space
// Solution: Prefix Sum — O(n) time, O(n) space
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int x : nums) {
            prefix += x & 1;
            res += count.getOrDefault(prefix - k, 0);
            count.merge(prefix, 1, Integer::sum);
        }
        return res;
    }
}
