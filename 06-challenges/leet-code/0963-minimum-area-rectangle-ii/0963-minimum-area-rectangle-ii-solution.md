# 963. Minimum Area Rectangle II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-area-rectangle-ii/

---

## Solution: Enumerate Diagonals — O(n³) time, O(n) space

**Idea:** A rectangle has two diagonals with the same midpoint and equal length. For each pair of points forming a diagonal, check if another such diagonal exists.

**Algorithm:**
1. For each pair (i,j), compute midpoint and diagonal length squared.
2. Group pairs by (midpoint, length²).
3. For each group, pairs form rectangles; compute area.

**Complexity:**

| | |
|---|---|
| Time | O(n²) average with hashing |
| Space | O(n²) |
