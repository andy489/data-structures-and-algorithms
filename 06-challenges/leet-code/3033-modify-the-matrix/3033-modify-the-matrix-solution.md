# 3033. Modify The Matrix — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/modify-the-matrix/

---

## Solution: Column Max — O(m*n) time, O(1) space

**Idea:** For each column, find the max (ignoring -1), then replace -1s with that max.

**Algorithm:**
1. For each column j: find max = max of all matrix[i][j] != -1.
2. Replace all -1 in column j with max.
3. Return modified matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — O(m*n) |
| Space | O(1) — O(1) extra (in-place) |
