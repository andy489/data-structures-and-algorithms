# 54. Spiral Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/spiral-matrix/

---

## Solution: Layer Boundaries — O(m·n) time, O(1) space

**Idea:** Maintain four boundary pointers (`top`, `bottom`, `left`, `right`). Traverse right along the top row, down along the right column, left along the bottom row, and up along the left column, then shrink the boundaries inward. Repeat until all elements are visited.

**Algorithm:**
1. Initialize `top = 0`, `bottom = m-1`, `left = 0`, `right = n-1`.
2. While `top <= bottom` and `left <= right`:
   - Traverse left → right along `top` row; increment `top`.
   - Traverse top → bottom along `right` column; decrement `right`.
   - If `top <= bottom`: traverse right → left along `bottom` row; decrement `bottom`.
   - If `left <= right`: traverse bottom → top along `left` column; increment `left`.
3. Return the collected elements.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each element visited exactly once |
| Space | O(1) — excluding the output list |

---

## Solution 2: Recursion — O(m·n) time, O(min(m,n)) space

**Idea:** Peel one spiral layer per recursive call. Each call handles the outermost ring defined by `(top, bottom, left, right)` boundaries, then recurses inward by shrinking all four bounds by 1. Base case: `top > bottom` or `left > right`.

**Algorithm:**
1. If `top > bottom` or `left > right`, return.
2. Traverse the top row left → right.
3. Traverse the right column top+1 → bottom.
4. If `top < bottom`: traverse the bottom row right-1 → left.
5. If `left < right`: traverse the left column bottom-1 → top+1.
6. Recurse with `(top+1, bottom-1, left+1, right-1)`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each element visited exactly once |
| Space | O(min(m,n)) — recursion depth equals number of layers |
