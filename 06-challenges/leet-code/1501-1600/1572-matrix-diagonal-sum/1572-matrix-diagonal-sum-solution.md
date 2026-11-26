# 1572. Matrix Diagonal Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/matrix-diagonal-sum/

---

## Solution: Single Pass — O(n) time, O(1) space

**Idea:** Sum elements on the primary diagonal (`mat[i][i]`) and secondary diagonal (`mat[i][n-1-i]`). If `n` is odd, the center element is counted twice, so subtract it once.

**Algorithm:**
1. Loop through row indices `i` from 0 to n-1.
2. Add `mat[i][i]` and `mat[i][n-1-i]`.
3. If `n % 2 == 1`, subtract `mat[n/2][n/2]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single loop over n rows |
| Space | O(1) — only a sum variable |
