// https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/

// Solution: Simulation with Earliest Start Time — O(n * m) time, O(n) space
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        // prefSkill[i] = skill[0] + skill[1] + ... + skill[i-1]
        long[] prefSkill = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSkill[i + 1] = prefSkill[i] + skill[i];
        }

        // done[i] = time when wizard i finishes the most recent potion assigned
        long[] done = new long[n];

        for (int j = 0; j < m; j++) {
            long mj = mana[j];
            // Find earliest start time t for potion j
            // wizard i starts at: t + prefSkill[i] * mj
            // constraint: t + prefSkill[i] * mj >= done[i]  => t >= done[i] - prefSkill[i] * mj
            long t = 0;
            for (int i = 0; i < n; i++) {
                t = Math.max(t, done[i] - prefSkill[i] * mj);
            }
            // Update finish times
            for (int i = 0; i < n; i++) {
                done[i] = t + prefSkill[i + 1] * mj;
            }
        }

        return done[n - 1];
    }
}
