# 118. Pascal's Triangle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/pascals-triangle/

---

## Solution: Iterative Row Construction — O(numRows²) time, O(numRows²) space

**Idea:** Build each row from the previous one. Every row starts and ends with 1; each interior element is the sum of the two elements directly above it in the previous row.

**Algorithm:**
1. Initialise `result` with the first row `[1]`.
2. For each row index `i` from `1` to `numRows - 1`:
   - Get the previous row `prev`.
   - Start new row with `[1]`.
   - For `j` from `1` to `i - 1`: append `prev[j-1] + prev[j]`.
   - Append `1` to close the row.
   - Add the new row to `result`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(numRows²) — row i has i+1 elements; total elements = 1+2+…+numRows = numRows*(numRows+1)/2 |
| Space | O(numRows²) — storing the entire triangle |
