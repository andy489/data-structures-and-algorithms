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

---

## Solution 2: Recursion — O(n²) time, O(n) space

**Idea:** Fill the outermost ring of the current sub-matrix, then recurse inward on the `(n-2) × (n-2)` interior, passing the next number to assign and the current offset.

**Algorithm:**
1. Base cases: `n == 0` → return; `n == 1` → fill center cell and return.
2. Fill the four sides of the current ring (top row, right col, bottom row, left col).
3. Recurse: `fill(matrix, offset + 1, n - 2, num after ring)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — every cell filled exactly once |
| Space | O(n) — recursion depth equals number of rings = n/2 |
