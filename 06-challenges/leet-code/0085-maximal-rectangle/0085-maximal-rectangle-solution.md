# 85. Maximal Rectangle — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximal-rectangle/

---

## Solution: Histogram per Row (LC 84) — O(m·n) time, O(n) space

**Idea:** Build a `heights[]` array of length `n`. For each row `i`, update `heights[j]`: if `matrix[i][j] == '1'` add 1, else reset to 0. This gives the height of consecutive 1s ending at row `i` for each column. Then apply the monotonic-stack largest-rectangle-in-histogram algorithm (LC 84) on `heights` and track the global maximum.

**Algorithm:**
1. Initialize `heights[n] = 0`.
2. For each row `i`:
   - Update `heights[j] += 1` if `matrix[i][j] == '1'`, else `heights[j] = 0`.
   - Run the LC 84 histogram algorithm on `heights`; update `maxArea`.
3. Return `maxArea`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — O(n) histogram solve per row, m rows |
| Space | O(n) — heights array + stack |
