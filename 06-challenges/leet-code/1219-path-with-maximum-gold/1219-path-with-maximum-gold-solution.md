# 1219. Path With Maximum Gold — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-with-maximum-gold/

---

## Solution: DFS Backtracking — O(m*n*4^k) where k≤25 time, O(m*n) space

**Idea:** Try starting DFS from every non-zero cell. At each step, mark visited by setting to 0, recurse in 4 directions, then restore.

**Algorithm:**
1. For each cell with gold, start DFS.
2. In DFS: mark visited (set to 0), try all 4 directions, restore.
3. Track global maximum.

**Complexity:**

| | |
|---|---|
| Time | O(m*n*4^k) where k≤25 |
| Space | O(m*n) |
