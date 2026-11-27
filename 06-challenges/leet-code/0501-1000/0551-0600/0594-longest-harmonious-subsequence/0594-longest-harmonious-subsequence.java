// https://leetcode.com/problems/longest-harmonious-subsequence/
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int key : frequency.keySet()) {
            if (frequency.containsKey(key + 1)) {
                longest = Math.max(longest, frequency.get(key) + frequency.get(key + 1));
            }
        }
        return longest;
    }
}
