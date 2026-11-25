# 957. Prison Cells After N Days — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/prison-cells-after-n-days/

---

## Solution: Cycle Detection — O(1) time, O(1) space

**Idea:** With 8 cells the state space is at most 256. Detect the cycle period and reduce n modulo it.

**Algorithm:**
1. Simulate one day at a time, storing seen states with their day index.
2. When a repeated state is found, the cycle length is `current_day - first_seen_day`.
3. Reduce n using cycle length and simulate the remainder.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 256 unique states |
| Space | O(1) — fixed state space |
