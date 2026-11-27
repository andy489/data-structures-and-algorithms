# 994. Rotting Oranges — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotting-oranges/

---

## Solution: BFS Multi-source — O(m*n) time, O(m*n) space

**Idea:** BFS from all rotten oranges simultaneously. Count minutes until all fresh are rotten.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) — queue |
