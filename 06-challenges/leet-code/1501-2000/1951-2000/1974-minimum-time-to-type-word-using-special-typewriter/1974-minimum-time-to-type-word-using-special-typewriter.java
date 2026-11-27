// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        int cur = 0;
        for (char c : word.toCharArray()) {
            int next = c - 'a';
            int diff = Math.abs(cur - next);
            time += Math.min(diff, 26 - diff) + 1;
            cur = next;
        }
        return time;
    }
}
