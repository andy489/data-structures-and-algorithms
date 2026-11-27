# 1139. Largest 1-Bordered Square — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-1-bordered-square/

---

## Solution: Prefix Sums (Horizontal + Vertical) — O(m*n*min(m,n)) time, O(m*n) space

**Idea:** Precompute for each cell `(i, j)` the number of consecutive `1`s to the left (`hor[i][j]`) and above (`ver[i][j]`). Then for each possible bottom-right corner `(i, j)` and each square side length `s` (from largest down), check whether all four border sides are entirely `1`s using the precomputed arrays. Return `s^2` for the first valid square found.

**Algorithm:**
1. Build `hor[i][j]` = consecutive 1s ending at `(i, j)` going left.
2. Build `ver[i][j]` = consecutive 1s ending at `(i, j)` going up.
3. For each `(i, j)`, try `s` from `min(hor[i][j], ver[i][j])` down to `1`:
   - Bottom edge: `hor[i][j] >= s`
   - Right edge: `ver[i][j] >= s`
   - Top edge: `hor[i-s+1][j] >= s`
   - Left edge: `ver[i][j-s+1] >= s`
   - If all pass, return `s*s`.
4. Return `0` if no square found.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * min(m, n)) |
| Space | O(m * n) — prefix sum tables |
