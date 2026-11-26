// https://leetcode.com/problems/time-needed-to-buy-tickets/

// Solution: Formula — O(n) time, O(1) space
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) { time += Math.min(tickets[i], tickets[k]); }
            else { time += Math.min(tickets[i], tickets[k] - 1); }
        }
        return time;
    }
}
