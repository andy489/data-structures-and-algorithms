// https://leetcode.com/problems/split-array-into-consecutive-subsequences/

// Solution: Greedy with Two Maps — O(n) time, O(n) space
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendFreq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            if (freq.getOrDefault(num, 0) == 0) {
                continue;
            }
            if (appendFreq.getOrDefault(num, 0) > 0) {
                appendFreq.merge(num, -1, Integer::sum);
                appendFreq.merge(num + 1, 1, Integer::sum);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.merge(num + 1, -1, Integer::sum);
                freq.merge(num + 2, -1, Integer::sum);
                appendFreq.merge(num + 3, 1, Integer::sum);
            } else {
                return false;
            }
            freq.merge(num, -1, Integer::sum);
        }
        return true;
    }
}
