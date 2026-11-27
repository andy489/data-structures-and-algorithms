// https://leetcode.com/problems/task-scheduler/

// Solution: Math/Greedy — O(n) time, O(1) space
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
