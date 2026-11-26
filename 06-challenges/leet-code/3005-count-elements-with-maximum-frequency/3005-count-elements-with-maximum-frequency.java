// https://leetcode.com/problems/count-elements-with-maximum-frequency/

// Solution: HashMap + Linear Scan — O(n) time, O(n) space
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) { freq.merge(x, 1, Integer::sum); }
        int maxFreq = 0;
        for (int f : freq.values()) { maxFreq = Math.max(maxFreq, f); }
        int total = 0;
        for (int f : freq.values()) { if (f == maxFreq) { total += f; } }
        return total;
    }
}
