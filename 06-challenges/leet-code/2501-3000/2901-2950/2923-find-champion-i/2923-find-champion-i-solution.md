# 2923. Find Champion I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-champion-i/

---

## Solution: Count In-Degrees — O(n²) time, O(1) space

**Idea:** The champion is the team that no other team beats. In the grid, `grid[i][j] == 1` means team `i` beats team `j`. The champion will have an in-degree of zero — no column `j` has `grid[j][champion] == 1`. Equivalently, sum the rows: the champion's row sum equals `n - 1` (beats everyone else).

**Algorithm:**
1. For each team `i`, compute the sum of row `i` in `grid`.
2. The team whose row sum equals `n - 1` is the champion (beats all others).
3. Return that team's index.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(1) |
