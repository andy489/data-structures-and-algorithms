# 2022. Convert 1D Array Into 2D Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/convert-1d-array-into-2d-array/

---

## Solution: Reshape — O(m * n) time, O(1) space

**Idea:** Check length equals m*n, then fill row by row.

**Algorithm:**
1. If `original.length != m * n`, return `[]`.
2. Fill result[i][j] = original[i*n + j].

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(1) |
