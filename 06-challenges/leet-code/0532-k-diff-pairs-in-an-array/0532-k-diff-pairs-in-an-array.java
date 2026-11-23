// https://leetcode.com/problems/k-diff-pairs-in-an-array/

// Solution: HashMap — O(n) time, O(n) space
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : freq.keySet()) {
            if (k == 0) {
                if (freq.get(num) >= 2) {
                    count++;
                }
            } else {
                if (freq.containsKey(num + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
