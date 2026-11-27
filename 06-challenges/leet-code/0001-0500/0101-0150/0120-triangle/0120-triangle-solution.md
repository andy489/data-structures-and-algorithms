# 120. Triangle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/triangle/

---

## Solution: Bottom-Up DP In-Place (O(n) space) — O(n²) time, O(n) space

**Idea:** Process the triangle from the second-to-last row upward. For each cell, replace its value with `cell + min(below, below-right)`. After processing all rows, `triangle[0][0]` holds the minimum path sum. Modifies the input in-place; uses only O(1) extra space (or O(n) if we copy the last row first).

**Algorithm:**
1. Start from row `n - 2` (second-to-last) going up to row `0`.
2. For each cell `j` in row `i`: `triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])`.
3. Return `triangle[0][0]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — n rows, up to n elements per row |
| Space | O(1) extra — modifies input in-place |

---

## Solution 2: Bottom-Up DP with Auxiliary Array — O(n²) time, O(n) space

**Idea:** Same bottom-up logic but copies the last row into a 1D `dp` array and works upward, so the input is not modified.

**Algorithm:**
1. Copy last row into `dp`.
2. For `i` from `n - 2` down to `0`: for each `j` in `0..i`: `dp[j] = triangle[i][j] + min(dp[j], dp[j+1])`.
3. Return `dp[0]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — same traversal |
| Space | O(n) — 1D dp array of size n |
