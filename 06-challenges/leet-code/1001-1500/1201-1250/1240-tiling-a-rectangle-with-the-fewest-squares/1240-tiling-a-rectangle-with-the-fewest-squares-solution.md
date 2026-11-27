# 1240. Tiling a Rectangle with the Fewest Squares — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/

---

## Solution: DFS with Backtracking — O(exponential, bounded) time, O(n*m) space

**Idea:** Use DFS. Track the 'skyline' (height of filled cells per column). Always fill the leftmost-lowest column. Try all valid square sizes.

**Algorithm:**
1. Track skyline array of column heights.
2. Find leftmost minimum height column.
3. Try placing squares of all valid sizes at that position.
4. Backtrack and track global minimum.

**Complexity:**

| | |
|---|---|
| Time | O(exponential, bounded) |
| Space | O(n*m) |
