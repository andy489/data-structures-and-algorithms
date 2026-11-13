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
