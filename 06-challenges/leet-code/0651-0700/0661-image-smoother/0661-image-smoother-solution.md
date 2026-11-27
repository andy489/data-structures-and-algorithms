# 661. Image Smoother — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/image-smoother/

---

## Solution: Brute Force 3×3 Window — O(m·n) time, O(m·n) space

**Idea:** For each cell, sum all valid neighbors in the 3×3 window and divide by count.

**Algorithm:**
1. For each `(i, j)`: iterate over rows `i-1..i+1` and cols `j-1..j+1`.
2. Accumulate sum and count of valid cells.
3. Store `sum / count` in result matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — 9 neighbors per cell (constant factor) |
| Space | O(m·n) — output matrix |
