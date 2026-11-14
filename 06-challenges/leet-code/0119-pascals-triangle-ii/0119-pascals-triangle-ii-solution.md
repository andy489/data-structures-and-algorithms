# 119. Pascal's Triangle II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/pascals-triangle-ii/

---

## Solution 1: In-Place Update (Right to Left) — O(rowIndex) time per row, O(rowIndex) space

**Idea:** Maintain a single row array of size `rowIndex + 1`. For each new row, update it in-place by iterating from right to left — this way each `row[j]` is updated using the old `row[j-1]` (not yet overwritten) and the old `row[j]`.

**Algorithm:**
1. Initialise `row = [1]`.
2. For each step `i` from `1` to `rowIndex`:
   - Append `0` to `row` (extend to size `i + 1`).
   - For `j` from `i` down to `1`: set `row[j] = row[j] + row[j-1]`.
3. Return `row`.

**Complexity:**

| | |
|---|---|
| Time | O(rowIndex²) — total updates across all rows |
| Space | O(rowIndex) — single row array, no triangle stored |

---

## Solution 2: Binomial Coefficient — O(rowIndex) time, O(rowIndex) space

**Idea:** The `j`-th element of row `rowIndex` is C(rowIndex, j). Compute the row directly using the multiplicative recurrence `C(n, j) = C(n, j-1) * (n - j + 1) / j`, starting from `C(n, 0) = 1`. No previous rows needed.

**Algorithm:**
1. Start `row = [1]`.
2. For `j` from `1` to `rowIndex`: append `row[j-1] * (rowIndex - j + 1) / j`.
3. Return `row`.

**Complexity:**

| | |
|---|---|
| Time | O(rowIndex) — single pass, one multiplication and division per element |
| Space | O(rowIndex) — single row array |
