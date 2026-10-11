# 6. Zigzag Conversion — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/zigzag-conversion/

---

## Solution

### Row Simulation — O(n) time, O(n) space

**Idea:** Simulate the zigzag traversal by distributing characters into `numRows` buckets (one per row), then concatenate all buckets.

**Algorithm:**
1. Create `numRows` string buffers.
2. Track `currentRow` (starts at 0) and direction `goingDown` (starts `false`).
3. For each character:
   - Append it to `rows[currentRow]`.
   - If `currentRow == 0` or `currentRow == numRows - 1`, flip direction.
   - Move `currentRow` by +1 or -1 according to direction.
4. Concatenate all rows in order.

**Edge case:** If `numRows == 1` (or `numRows >= s.length`), return `s` unchanged — no zigzag occurs.

**Why direction flip at boundaries:** The zigzag goes down from row 0 to row `numRows-1`, then back up — exactly `numRows - 1` steps per half-cycle.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character processed once |
| Space | O(n) — total characters stored in row buffers |

### Mathematical Index Mapping — O(n) time, O(n) space

Observe the period of the zigzag pattern is `p = 2 * (numRows - 1)`. For row `r`:
- Main diagonal elements: indices `r, r+p, r+2p, ...`
- Middle diagonal elements (for `0 < r < numRows-1`): indices `p-r, 2p-r, 3p-r, ...`

Iterate row by row, computing positions directly without simulation. Same complexity but avoids the auxiliary string buffers at the cost of more index arithmetic.
