// https://leetcode.com/problems/time-needed-to-buy-tickets/

// Solution: Formula — O(n) time, O(1) space
var timeRequiredToBuy = function(tickets, k) {
    return tickets.reduce((time, t, i) =>
        time + (i <= k ? Math.min(t, tickets[k]) : Math.min(t, tickets[k] - 1)), 0);
};
