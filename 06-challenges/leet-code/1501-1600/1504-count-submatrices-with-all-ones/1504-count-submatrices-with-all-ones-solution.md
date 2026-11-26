# 1504. Count Submatrices With All Ones — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-submatrices-with-all-ones/

---

## Solution: Height Array + Stack — O(m*n) time, O(n) space

**Idea:** For each row, compute a `height[]` array where `height[j]` = number of consecutive `1`s ending at row `i` in column `j`. Then for each row, count the number of rectangles with their bottom edge on that row. For a fixed row `i` and right column `j`, the number of valid rectangles with right column `j` equals the sum of `min(height[k..j])` for each left column `k <= j`. This can be computed efficiently using a stack.

**Algorithm:**
1. For each row `i`, update `height[j] = mat[i][j] == 1 ? height[j] + 1 : 0`.
2. For each row, use a monotonic stack to count rectangles. Maintain a stack of `(h, width)` pairs:
   - Pop elements while the top has height >= current height, accumulating their widths.
   - Push `(height[j], width)`.
   - Add the sum of `h * width` over all stack elements (the count of rectangles ending at column `j`).
3. Accumulate counts into result.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) — each element processed once per row via stack |
| Space | O(n) — height array and stack |
