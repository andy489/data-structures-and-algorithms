# 1463. Cherry Pickup Ii — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cherry-pickup-ii/

---

## Solution: 3D DP — O(rows * cols^2) time, O(rows * cols^2) space

**Idea:** dp[r][c1][c2] = max cherries when robot1 is at (r,c1) and robot2 at (r,c2). They move together each row.

**Algorithm:**
1. dp[0][0][cols-1] = grid[0][0]+grid[0][cols-1] (or just grid[0][0] if cols==1).
2. For each row r, for each (c1,c2): try all 9 moves. dp[r+1][nc1][nc2] = max over dp[r][c1][c2] + cherries collected.
3. Return max over all dp[rows-1][c1][c2].

**Complexity:**

| | |
|---|---|
| Time | O(rows * cols^2) |
| Space | O(rows * cols^2) |
