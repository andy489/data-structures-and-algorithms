// https://leetcode.com/problems/continuous-subarray-sum/

// Solution: Prefix Sum + HashMap (Remainder) — O(n) time, O(k) space
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderFirstSeen = new HashMap<>();
        remainderFirstSeen.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % k;
            if (remainderFirstSeen.containsKey(prefixSum)) {
                if (i - remainderFirstSeen.get(prefixSum) >= 2) {
                    return true;
                }
            } else {
                remainderFirstSeen.put(prefixSum, i);
            }
        }
        return false;
    }
}
