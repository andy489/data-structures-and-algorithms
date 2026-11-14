# 59. Spiral Matrix II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/spiral-matrix-ii/

---

## Solution: Layer-by-Layer Boundary Shrink — O(n²) time, O(1) extra space

**Idea:** Maintain four boundaries (`top`, `bottom`, `left`, `right`) and fill the matrix layer by layer, shrinking the boundaries inward after each direction pass.

**Algorithm:**
1. Initialize an `n×n` matrix, `num = 1`, `top = left = 0`, `bottom = right = n - 1`.
2. While `num <= n²`:
   - Left → right along `top` row; `top++`
   - Top → bottom along `right` col; `right--`
   - Right → left along `bottom` row; `bottom--`
   - Bottom → top along `left` col; `left++`
3. Return the matrix.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — every cell filled exactly once |
| Space | O(1) extra — output matrix not counted |
