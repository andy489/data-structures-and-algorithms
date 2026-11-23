# 495. Teemo Attacking — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/teemo-attacking/

---

## Solution: Greedy Interval Merge — O(n) time, O(1) space

**Idea:** Each attack poisons for `duration` seconds, but if the next attack comes before poison expires, only count up to the next attack time. Sum up min(duration, gap to next attack) for each attack.

**Algorithm:**
1. For each i from 0 to n-2: add min(duration, timeSeries[i+1] - timeSeries[i]).
2. Add duration for the last attack.
3. Return total.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
