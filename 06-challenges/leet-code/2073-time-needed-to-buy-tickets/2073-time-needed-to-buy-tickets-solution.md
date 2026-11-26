# 2073. Time Needed to Buy Tickets — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/time-needed-to-buy-tickets/

---

## Solution: Simulation — O(n) time, O(1) space

**Idea:** For each person, they buy min(tickets[i], tickets[k]) tickets before k finishes; those after k buy min(tickets[i], tickets[k]-1).

**Algorithm:**
1. For `i <= k`: time += min(tickets[i], tickets[k]).
2. For `i > k`: time += min(tickets[i], tickets[k] - 1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
