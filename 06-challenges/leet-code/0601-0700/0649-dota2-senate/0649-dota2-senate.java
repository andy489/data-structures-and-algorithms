// https://leetcode.com/problems/dota2-senate/

// Solution: Two Queues — O(n) time, O(n) space
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIdx = radiant.poll();
            int dIdx = dire.poll();
            if (rIdx < dIdx) {
                radiant.offer(rIdx + n);
            } else {
                dire.offer(dIdx + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
