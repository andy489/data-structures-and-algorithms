// https://leetcode.com/problems/contiguous-array/

// Solution: Prefix Sum + HashMap — O(n) time, O(n) space
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, -1);
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1) ? 1 : -1;
            if (firstOccurrence.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum));
            } else {
                firstOccurrence.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
