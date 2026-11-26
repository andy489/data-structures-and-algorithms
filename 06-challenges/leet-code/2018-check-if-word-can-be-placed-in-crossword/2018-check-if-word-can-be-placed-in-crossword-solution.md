# 2018. Check if Word Can Be Placed In Crossword — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

---

## Solution: Scan for Valid Runs — O(m * n * L) time, O(1) space

**Idea:** For each run of non-'#' cells, check if `word` or `reverse(word)` fits.

**Algorithm:**
1. Scan every row for horizontal runs.
2. Scan every column for vertical runs.
3. For each run of length L == word.length, check if word or reversed word fits.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * L) |
| Space | O(1) |
