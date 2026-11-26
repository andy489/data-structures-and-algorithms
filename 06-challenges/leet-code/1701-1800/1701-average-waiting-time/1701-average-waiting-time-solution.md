# 1701. Average Waiting Time — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/average-waiting-time/

---

## Solution: Greedy Simulation — O(n) time, O(1) space

**Idea:** Track the current time when the chef becomes free. For each customer, the chef starts their order at `max(currentTime, arrival)` and finishes at `startTime + prepTime`. Accumulate the waiting time (finish - arrival) for all customers.

**Algorithm:**
1. Initialize `chefFreeAt = 0` and `totalWait = 0`.
2. For each customer `[arrival, time]`:
   - `chefFreeAt = max(chefFreeAt, arrival) + time`
   - `totalWait += chefFreeAt - arrival`
3. Return `totalWait / n`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
