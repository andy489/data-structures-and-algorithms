# 2087. Minimum Cost Homecoming of a Robot in a Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/

---

## Solution: Greedy — O(m + n) time, O(1) space

**Idea:** Always move directly toward home (no detours are cheaper). Sum the costs of all rows and columns traversed.

**Algorithm:**
1. Move row by row from startPos row to homePos row, summing rowCosts.
2. Move column by column, summing colCosts.
3. Skip startPos row/col (not counted).

**Complexity:**

| | |
|---|---|
| Time | O(m + n) |
| Space | O(1) |
