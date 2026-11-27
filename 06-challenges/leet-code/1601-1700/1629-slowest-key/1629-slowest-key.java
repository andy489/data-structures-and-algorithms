// https://leetcode.com/problems/slowest-key/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDur = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            char key = keysPressed.charAt(i);
            if (dur > maxDur || (dur == maxDur && key > ans)) {
                maxDur = dur;
                ans = key;
            }
        }
        return ans;
    }
}
